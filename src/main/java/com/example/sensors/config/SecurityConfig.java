package com.example.sensors.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${credential.admin.username}")
  private String usernameAdmin;

  @Value("${credential.admin.password}")
  private String passwordAdmin;

  @Value("${credential.viewer.password}")
  private String passwordViewer;

  @Value("${credential.viewer.username}")
  private String usernameViewer;

  @Bean
  @Override
  protected UserDetailsService userDetailsService() {
    return new InMemoryUserDetailsManager(
        User.builder()
            .username(usernameAdmin)
            .password(passwordEncoder().encode(passwordAdmin))
            .roles("ADMIN")
            .build(),

        User.builder()
            .username(usernameViewer)
            .password(passwordEncoder().encode(passwordViewer))
            .roles("VIEWER")
            .build()
    );
  }

  @Bean
  protected PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(7);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.csrf().disable()
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
  }
}
