package top.lijingxin.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import top.lijingxin.blog.mapper.UserMapper;
import top.lijingxin.blog.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class indexController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if (null == cookies){
            return "index";
        }
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())){
                User user = userMapper.getByToken(cookie.getValue());
                if (user != null) {
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }
}
