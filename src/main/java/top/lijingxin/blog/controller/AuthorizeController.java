package top.lijingxin.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.lijingxin.blog.dto.AccessTokenDTO;
import top.lijingxin.blog.dto.GithubUser;
import top.lijingxin.blog.mapper.UserMapper;
import top.lijingxin.blog.model.User;
import top.lijingxin.blog.provider.GithubProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author Ali
 */
@Controller
public class AuthorizeController {

    @Autowired
    GithubProvider githubProvider;
    @Autowired
    UserMapper userMapper;

    /**
     * 当springboot启动的时候会吧配置文件中的内容全部读取到一个map中，在用的时候可以根据@Value注解来读取
     */
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                            HttpServletRequest request){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (null != githubUser){
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            // 登录成功，写Cookie和Session
            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else {
            // 登录失败，重新登陆
            return "redirect:/";
        }
    }
}
