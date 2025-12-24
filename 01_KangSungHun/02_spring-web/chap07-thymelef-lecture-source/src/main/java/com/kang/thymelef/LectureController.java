package com.kang.thymelef;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lecture")
public class LectureController {

    @GetMapping("/c")
    public ModelAndView expression(ModelAndView mv) {

        return mv;
    }

    @GetMapping("/expression")
    public ModelAndView expression(ModelAndView mv) {

        return mv;
    }

    @GetMapping("/")
    public ModelAndView expression(ModelAndView mv) {

        return mv;
    }


}
