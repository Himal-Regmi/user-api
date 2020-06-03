package com.regmi.userApi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        System.out.println("Authentication started--");
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("authorization started--");
        http .authorizeRequests()
//                .antMatchers("/**").permitAll()
        .anyRequest().permitAll();
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST,"/**").permitAll()
//
//                //.antMatchers(HttpMethod.GET,"/user**").hasRole("user")
////                .antMatchers("/offers/**").hasRole("MANAGER")
////                .antMatchers("/systemSettings/**").hasRole("ADMIN")
//                //.and()
//                //.formLogin()
////                .loginPage("/showloginpage")
////                .loginProcessingUrl("/authenticateUser")
////                .permitAll()
//                .and()
//                .logout().permitAll();
////                .and()
////                .exceptionHandling().accessDeniedPage("/accessdenied");
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };
}
