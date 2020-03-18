package top.lijingxin.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Ali
 */
@Controller
public class HelloController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
