package com.example.W2_board0_jar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import com.example.W2_board0_jar.outh2.JwtAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                // CSRF 비활성화 (JWT + 쿠키 사용하므로)
                .csrf().disable()

                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/",
                                "/member/moveLogin",
                                "/member/login",
                                "/member/moveJoin",
                                "/member/movefindID",
                                "/member/movefindPW",
                                "/member/findID",
                                "/member/findPW",
                                "/static/**",
                                "/WEB-INF/jsp/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )

                // JWT 필터 추가
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)

                .formLogin(form -> form
                        .loginPage("/member/moveLogin")
                        .loginProcessingUrl("/member/login")
                        .usernameParameter("userId")
                        .passwordParameter("userPw")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/member/moveLogin?error=true")
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutUrl("/member/logout")
                        .logoutSuccessUrl("/member/moveLogin")
                        .invalidateHttpSession(true)
                );


        return http.build();
    }
}