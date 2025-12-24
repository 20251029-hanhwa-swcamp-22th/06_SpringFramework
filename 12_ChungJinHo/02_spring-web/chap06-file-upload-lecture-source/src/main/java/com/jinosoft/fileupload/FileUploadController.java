package com.jinosoft.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 파일 업로드를 처리하는 컨트롤러 클래스입니다.
 * <p>
 * 단일 파일 업로드와 다중 파일 업로드를 처리하는 핸들러 메소드를 포함하고 있습니다.
 * application.yml에서 설정한 파일 저장 경로를 주입받아 사용합니다.
 * </p>
 */
@Controller
public class FileUploadController {

    /**
     * application.yml 파일의 spring.servlet.multipart.location 값을 주입받습니다.
     */
    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    /**
     * 파일 업로드 테스트를 위한 메인 페이지를 보여줍니다.
     * 
     * @return main 뷰 페이지 이름
     */
    @GetMapping(value = { "/", "/main" })
    public String main() {
        return "main";
    }

    /**
     * 단일 파일 업로드 폼 페이지로 이동합니다.
     * 
     * @return single-file 뷰 페이지 이름
     */
    @GetMapping("/single-file")
    public String showSingleUploadForm() {
        return "single-file";
    }

    /**
     * 단일 파일 업로드 요청을 처리합니다.
     *
     * @param singleFile            업로드된 파일 객체 (@RequestParam으로 바인딩)
     * @param singleFileDescription 파일 설명
     * @param model                 뷰에 데이터를 전달하기 위한 Model 객체
     * @return 성공 시 result 뷰 페이지
     */
    @PostMapping("/single-file")
    public String singleFileUpload(@RequestParam MultipartFile singleFile,
            String singleFileDescription,
            Model model) {

        System.out.println("singleFile : " + singleFile);
        System.out.println("singleFileDescription : " + singleFileDescription);

        // 파일을 저장할 디렉토리 객체 생성
        File dir = new File(filePath);
        System.out.println("저장 경로 : " + dir.getAbsolutePath());

        // 디렉토리가 존재하지 않으면 생성
        if (!dir.exists()) {
            boolean mkdirsResult = dir.mkdirs();
            System.out.println("디렉토리 생성 여부 : " + mkdirsResult);
        }

        // 파일명 변경 처리 (UUID 사용)
        String savedName = generateSavedFileName(singleFile);

        try {
            // 파일을 지정된 경로에 저장
            singleFile.transferTo(new File(filePath + "/" + savedName));
            model.addAttribute("message", "파일 업로드 성공!");
            model.addAttribute("fileName", singleFile.getOriginalFilename());
            model.addAttribute("savedName", savedName);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "파일 업로드 실패!!");
        }

        return "result";
    }

    /**
     * 다중 파일 업로드 폼 페이지로 이동합니다.
     * 
     * @return multi-file 뷰 페이지 이름
     */
    @GetMapping("/multi-file")
    public String showMultiUploadForm() {
        return "multi-file";
    }

    /**
     * 다중 파일 업로드 요청을 처리합니다.
     *
     * @param multiFiles           업로드된 파일 리스트 (@RequestParam으로 바인딩)
     * @param multiFileDescription 파일 설명
     * @param model                뷰에 데이터를 전달하기 위한 Model 객체
     * @return 성공 시 result 뷰 페이지
     */
    @PostMapping("/multi-file")
    public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles,
            String multiFileDescription,
            Model model) {

        System.out.println("multiFiles : " + multiFiles);
        System.out.println("multiFileDescription : " + multiFileDescription);

        // 파일을 저장할 디렉토리 객체 생성
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        List<FileDTO> files = new ArrayList<>();

        try {
            // 업로드된 파일 리스트를 순회하며 처리
            for (MultipartFile file : multiFiles) {
                // 파일이 비어있는지 확인 (선택하지 않고 전송했을 경우 등)
                if (file.isEmpty()) {
                    continue;
                }

                // 파일명 변경 처리
                String savedName = generateSavedFileName(file);

                // DTO 객체 생성 및 리스트에 추가 (DB 저장 시뮬레이션)
                files.add(new FileDTO(file.getOriginalFilename(), savedName, filePath, multiFileDescription));

                // 파일 저장
                file.transferTo(new File(filePath + "/" + savedName));
            }
            model.addAttribute("message", "파일 업로드 성공! (총 " + files.size() + "개)");
        } catch (Exception e) {
            e.printStackTrace();

            // 실패 시 이미 저장된 파일들을 삭제하여 롤백 처리
            for (FileDTO file : files) {
                new File(filePath + "/" + file.getSavedName()).delete();
            }

            model.addAttribute("message", "파일 업로드 실패!!");
        }

        return "result";
    }

    /**
     * 저장될 파일의 이름을 UUID를 이용하여 생성하는 메소드입니다.
     * 파일명 충돌을 방지하기 위해 랜덤한 UUID 문자열과 원본 확장자를 조합합니다.
     *
     * @param file 업로드된 파일 객체
     * @return 저장될 파일 이름
     */
    private String generateSavedFileName(MultipartFile file) {
        String originFileName = file.getOriginalFilename();

        // 확장자가 없는 경우 처리
        String ext = "";
        if (originFileName != null && originFileName.contains(".")) {
            ext = originFileName.substring(originFileName.lastIndexOf("."));
        }

        return UUID.randomUUID().toString() + ext;
    }
}
