package com.sparta.miniproject02.config;

import com.sparta.miniproject02.controller.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsFilter corsFilter;
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) {
// h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
        web
                .ignoring()
                .antMatchers("/v2/api-docs", "/configuration/ui",
                        "/swagger-resources", "/configuration/security",
                        "/swagger-ui.html", "/webjars/**", "/swagger/**")
                .antMatchers("/h2-console/**")
                .antMatchers("/api/v1/upload")
                .antMatchers("/api/category/**")
                .antMatchers("/user/kakao/callback/**")
                .antMatchers("/api/user/**");
//                .antMatchers("/api/posting");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
// 회원 관리 처리 API (POST /user/**) 에 대해 CSRF 무시
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(corsFilter, SecurityContextPersistenceFilter.class)
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class)
                .formLogin().disable()
                .httpBasic().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/api/user/**").permitAll()
                .antMatchers("/api/category/**").permitAll()
                .antMatchers("/v2/api-docs", "/configuration/ui",
                        "/configuration/security", "/swagger-ui.html", "/swagger-resources/**",
                        "/webjars/**", "/swagger/**").permitAll()
                .antMatchers("/user/kakao/callback/**").permitAll()
                .antMatchers("/api/v1/upload").permitAll()
                .anyRequest().authenticated();

    }
}