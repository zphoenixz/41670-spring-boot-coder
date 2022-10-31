//package com.coderhouse.springbootcoder.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class BasicAuthWebSecurityConfiguration
//{
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests().anyRequest().authenticated()
//                .and()
//                .httpBasic();
//
//        return http.build();
//    }
//
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails user1 = User.builder().username("myUser2").password(
//                passwordEncoder().encode("myPassword2")
//        ).roles("USER").build();
////        UserDetails user2 = User.builder().username("admin").password("password").roles("ADMIN").build();
//        inMemoryUserDetailsManager.createUser(user1);
////        inMemoryUserDetailsManager.createUser(user2);
//        return new InMemoryUserDetailsManager(user1);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
