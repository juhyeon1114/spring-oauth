package security.springoauth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;

/**
 * 자동(기본) 설정
 */
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Throwable {
//        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
//        httpSecurity.formLogin();
//        httpSecurity.apply(new CustomSecurityConfigurer().setSecure(false ));
//        return httpSecurity.build();
//    }
//
//}

/**
 *
 */
//@Configuration
//@Slf4j
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Throwable {
//        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
//
//        /**
//         * 인증 방식 2가지
//         */
//        httpSecurity.formLogin(); // #1
////        httpSecurity.httpBasic(); // #2
//
//        /**
//         * 인증에 실패했을 때 처리
//         */
//        httpSecurity.exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
//            @Override
//            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//                log.info("=== Custom entry point");
//            }
//        });
//        return httpSecurity.build();
//    }
//}

@Configuration
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Throwable {
        /**
         * Http Basic 챕터
         */
//        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
//        httpSecurity.httpBasic();
//        httpSecurity.httpBasic().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
//        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        /**
         * CORS 설정
         */
//        httpSecurity.cors().configurationSource(corsConfigurationSource());

        return httpSecurity.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("*");
        configuration.addAllowedOrigin("http://localhost:8081");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
