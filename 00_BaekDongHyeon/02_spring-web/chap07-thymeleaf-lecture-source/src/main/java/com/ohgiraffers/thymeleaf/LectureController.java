package com.ohgiraffers.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lecture")
public class LectureController {

  @GetMapping("/expression")
  public ModelAndView expression(ModelAndView mv) {
  
    mv.addObject(
        "member",
        new MemberDTO("홍길동", 20, '남', "서울시 중구"));

    mv.addObject(
        "hello",
        "hello!<h3>Thymeleaf</h3>");

    // forward할 뷰 이름 작성
    // -> View Resolver가 접두사, 접미사를 붙여 해당 html로 forward
    mv.setViewName("lecture/expression");
    
    return mv;
  }

  @GetMapping("/conditional")
  public ModelAndView conditional(ModelAndView mv) {

    mv.addObject("num", 1);
    mv.addObject("str", "바나나");

    List<MemberDTO> memberList = new ArrayList<>();
    memberList.add(new MemberDTO("홍길동", 20, '남', "서울시 종로구"));
    memberList.add(new MemberDTO("유관순", 16, '여', "서울시 노원구"));
    memberList.add(new MemberDTO("장보고", 30, '남', "서울시 성북구"));
    memberList.add(new MemberDTO("신사임당", 40, '여', "서울시 서초구"));
    mv.addObject("memberList", memberList);

    mv.setViewName("lecture/conditional");

    return mv;
  }

  @GetMapping("/etc")
  public ModelAndView etc(ModelAndView mv) {

    SelectCriteria selectCriteria = new SelectCriteria(1, 10, 3);
    mv.addObject(selectCriteria);

    mv.addObject("member", new MemberDTO("홍길동", 20, '남', "서울시 종로구"));

    List<MemberDTO> memberList = new ArrayList<>();
    memberList.add(new MemberDTO("홍길동", 20, '남', "서울시 종로구"));
    memberList.add(new MemberDTO("유관순", 16, '여', "서울시 노원구"));
    memberList.add(new MemberDTO("장보고", 30, '남', "서울시 성북구"));
    memberList.add(new MemberDTO("신사임당", 40, '여', "서울시 서초구"));
    mv.addObject("memberList", memberList);

    Map<String, MemberDTO> memberMap = new HashMap<>();
    memberMap.put("m01", new MemberDTO("홍길동", 20, '남', "서울시 종로구"));
    memberMap.put("m02", new MemberDTO("유관순", 16, '여', "서울시 노원구"));
    memberMap.put("m03", new MemberDTO("장보고", 30, '남', "서울시 성북구"));
    memberMap.put("m04", new MemberDTO("신사임당", 40, '여', "서울시 서초구"));
    mv.addObject("memberMap", memberMap);

    mv.setViewName("lecture/etc");

    return mv;
  }


}
