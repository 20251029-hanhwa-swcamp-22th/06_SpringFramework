package com.kang.thymelef;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

        return mv;
    }

    @GetMapping("/etc")
    public ModelAndView etc(ModelAndView mv) {

        return mv;
    }


}

