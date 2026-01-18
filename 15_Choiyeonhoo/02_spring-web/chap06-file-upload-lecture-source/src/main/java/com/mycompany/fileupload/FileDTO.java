package com.mycompany.fileupload;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {
  /* FileDTO : Service, Repository(DAO, DB) 계층에
  *  File에 대한 정보만 전달하는 객체
  *  (실제 파일은 아님)
  * */
  private String originFileName;
  private String savedName;
  private String filePath;
  private String fileDescription;
}
