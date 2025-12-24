package com.jinosoft.fileupload;

import lombok.*;

/**
 * 업로드된 파일의 정보를 담는 DTO (Data Transfer Object) 클래스입니다.
 * <p>
 * 파일의 원본 이름, 저장된 이름, 저장 경로, 파일 설명을 저장하여
 * 추후 데이터베이스 저장이나 파일 관리에 사용됩니다.
 * </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileDTO {

    /** 파일의 원본 이름 */
    private String originFileName;

    /** 서버에 저장될 때 변경된 파일 이름 (UUID 적용) */
    private String savedName;

    /** 파일이 저장된 경로 */
    private String filePath;

    /** 파일에 대한 설명 */
    private String fileDescription;

}
