package com.ohgiraffers.fileupload;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileDTO {
  /* FileDTO : Service, Repository(DAO, DB) 계층에
  *  File에 대한 정보만 전달하기 위한 DTO 객체
  *  (실제 파일 X)
  * */

  private String originFileName;
  private String savedName;
  private String filePath;
  private String fileDescription;

}
