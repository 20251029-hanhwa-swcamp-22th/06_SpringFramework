package com.ohgiraffers.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

  /* application.yml 파일에서 파일 경로 얻어오기 */
  @Value("${spring.servlet.multipart.location}")
  private String filePath;

  // MultipartFile :
  // - 요청 형식이 multipart/form-data 일 때
  //   MultipartResolver가 구분하여 처리한 데이터 중 File을 지칭하는 객체

  @PostMapping("/single-file")
  public String singleFileUpload(
      @RequestParam String singleFileDescription,
      @RequestParam MultipartFile singleFile
      ){

    System.out.println("singleFileDescription = " + singleFileDescription);
    System.out.println("singleFile = " + singleFile);
    System.out.println(singleFile.getOriginalFilename()); // 제출 파일명
    System.out.println(singleFile.getSize()); // 파일 크기(byte)

    /* 서버 컴퓨터에 제출된 파일을 저장 */

    // 1. 저장할 폴더를 지정
    File dir = new File(filePath);
    if(!dir.exists()){
      dir.mkdirs(); // 경로 내 모든 폴더 생성
    }

    // 2. 서버에 저장할 파일명 변경하기
    // * 같은 폴더 내에는 같은 이름의 파일이 중복 저장될 수 없다!!
    String savedName = generateSavedFileName(singleFile);

    // 3. 지정된 경로에 변경된 이름으로 파일 저장하기
    // * 파일 저장 전 파일은 어디에 있을까??
    // - 기본적으로는 메모리에 로드되어 있음
    // - 설정해둔 메모리 제한 용량보다 파일이 크면
    //   지정된 임시 경로에 저장
    try {
      singleFile.transferTo(new File(filePath + "/" + savedName));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return "result";
  }


  @PostMapping("/multi-file")
  public String multiFileUpload(
      @RequestParam String multiFileDescription,
      @RequestParam List<MultipartFile> multiFile
  ){

    /* 서버 컴퓨터에 제출된 파일을 저장 */

    // 1. 저장할 폴더를 지정
    File dir = new File(filePath);
    if(!dir.exists()){
      dir.mkdirs(); // 경로 내 모든 폴더 생성
    }

    for(MultipartFile singleFile : multiFile) {
      // 2. 서버에 저장할 파일명 변경하기
      // * 같은 폴더 내에는 같은 이름의 파일이 중복 저장될 수 없다!!
      String savedName = generateSavedFileName(singleFile);

      // 3. 지정된 경로에 변경된 이름으로 파일 저장하기
      // * 파일 저장 전 파일은 어디에 있을까??
      // - 기본적으로는 메모리에 로드되어 있음
      // - 설정해둔 메모리 제한 용량보다 파일이 크면
      //   지정된 임시 경로에 저장
      try {
        singleFile.transferTo(new File(filePath + "/" + savedName));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    return "result";
  }




  @PostMapping("/multi-file-db")
  public String multiFileUpdateDB(
      @RequestParam String multiFileDescription,
      @RequestParam List<MultipartFile> multiFile,
      Model model
  ){

    /* 다른 계층에 전달할 file 정보를 모아두는 List */
    List<FileDTO> files = new ArrayList<>();

    try{
      for(MultipartFile singleFile : multiFile){

        // 파일명 변경
        String savedName = generateSavedFileName(singleFile);

        // FileDTO 생성
        FileDTO f = new FileDTO(
            singleFile.getOriginalFilename(),
            savedName,
            filePath,
            multiFileDescription
        );

        // files에 생성한 DTO 추가
        files.add(f);

        // 지정된 경로에 파일로 저장
        singleFile.transferTo(new File(filePath + "/" + savedName));

        if(files.size() >= 3){ // 저장된 파일이 3개가 되면 임의로 예외 발생
          throw new IOException("임의 예외 발생");
        }
        
      }

      model.addAttribute("message", "파일 업로드 성공");

    }catch (IOException e){
      // 중간에 오류 발생 시
      // 이미 저장된 파일을 모두 삭제

      for(FileDTO f : files){
        File file
            = new File(f.getFilePath() + "/" + f.getSavedName());

        if(file.exists()) file.delete();
      }

      model.addAttribute("message", "파일 업로드 실패 ㅠㅠ");

    }

    return "result";
  }




  // UUID(Universally Unique IDentifier, 범용 고유 식별자)
  // - 네트워크 상에서 중복되지 않는 유일한 아이디를 만들때 사용하는 표준 규약
  // - 128비트 숫자로 이루어짐(출력 시 16진수로 변환되서 보임)

  private String generateSavedFileName(MultipartFile file) {
    String originFileName = file.getOriginalFilename();
    String ext = originFileName.substring(originFileName.lastIndexOf("."));
    return UUID.randomUUID() + ext;
  }


}
