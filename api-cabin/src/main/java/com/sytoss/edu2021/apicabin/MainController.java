package com.sytoss.edu2021.apicabin;

import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/")
    @ResponseBody
    public String home(@RequestParam(name = "nickname") String nickname) {

        return "Hello Docker World " + nickname;
    }

}