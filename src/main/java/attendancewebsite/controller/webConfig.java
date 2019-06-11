package attendancewebsite.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class webConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("http://localhost:8080").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("http://localhost:8080/login?error").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/homePage").setViewName("homePage");
        registry.addViewController("/changepassword").setViewName("changepassword");
    }

}
