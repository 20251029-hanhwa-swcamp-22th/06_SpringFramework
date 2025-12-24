package com.ohgiraffers.fileupload;

import lombok.*;

@Setter// 밖에서 설정
@Getter // vlfemrkqt wlwjdf 필드 설정
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileDTO {

    /* FileDTO :Sevice, Repository(DAO, DB) 계층에
    * File에 대한 정보만 전달하기 위한 DTO 객체
    *  (실제파일이 아닌 정보만 저장)*/

    private String originFileName;
    private String savedName;
    private String filePath;
    private String fileDescription;

}
