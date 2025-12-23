package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/* class level @RequestMapping
* - 요청 URL의 공통 시작 부분을 지정하는 어노테이션
* - 내부 핸들러 메서드에서 중복 URL을 작성하지 않아도 된다
* - order 로 시작하는 요청은 이 컨트롤러에서 시작 하겠음
* */

@Controller // bean등록 + 제어의역할임을 명시
@RequestMapping("/order")
public class ClassMappingTestController {

    @GetMapping("/regist")
    public String registOrder(Model model){
        model.addAttribute(
                "message",
                "GET 방식의 주문 등록 핸들러 메서드 호춯");

        return "mappingResult";
    }/*
    @PostMapping ("/modify")
    public String registOrderModify(Model model) {
        model.addAttribute(
                "message",
                "POST방식 메뉴 수정");
        return "mappingResult";
    }

    @PostMapping ("/delete")
    public String registOrderDelete(Model model) {
        model.addAttribute("message", "POST 방식 메뉴 삭제");
        return "mappingResult";
    }*/

    /* 위 주석친 각각의 주소값을
    *  하나의 핸들러 메서드에 매핑*/
    @PostMapping ({"/modify","/delete"})
    public String registOrderModifyDelete(Model model) {
        model.addAttribute(
                "message",
                "POST방식 메뉴 수정||삭제");
        return "mappingResult";
    }

    /* PathVariable : 요청주소에 포함된 값을 매개 변수에 저장
    * (요청 주소에 포함된 변수)*/
    @GetMapping("/detail/{orderNo}")
    public String selectOneOrederDetail(Model model, @PathVariable("orderNo") int orderNo){
        model.addAttribute(
                "message",
                "GET 방식"+orderNo+"번 메뉴 상세 주문 핸들러 메서드 호출"
        );

        return "mappingResult";
    }


    /* 얘는 그냥 /order (GET) 요청 핸들러 메서드
    * - 뒤에 아무 주소도 없다*/
    @GetMapping
    public String otherRequest(Model model){
        model.addAttribute(
                "message",
                "order 요청이긴 하지만 다른 기능은 준비되지 않음"
        );

        return "mappingResult";
    }

    }


