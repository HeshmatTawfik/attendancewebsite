package attendancewebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web
        .configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web
        .configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).
                usersByUsernameQuery
                        ("select studentName as username,pass as password,true from  student where studentName=?")
                .authoritiesByUsernameQuery("select studentName, authority from student where studentName=?")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

   http.authorizeRequests().antMatchers("/homePage","/changepassword").access("hasRole('ROLE_USER')").antMatchers("/","/**").access("permitAll").and().
            formLogin().loginPage("/login").defaultSuccessUrl("/homePage").usernameParameter("username").and().logout().logoutSuccessUrl("/").permitAll().and().exceptionHandling().accessDeniedPage("/login").and().rememberMe();

    }

    @Bean
    public HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }
}