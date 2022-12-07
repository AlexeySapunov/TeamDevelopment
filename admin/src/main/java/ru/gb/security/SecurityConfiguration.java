package ru.gb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    @Autowired
    public void authConfig(AuthenticationManagerBuilder authBuild,
                           UserDetailServiceImpl userDetailService,
                           PasswordEncoder encoder) throws Exception {
        authBuild.inMemoryAuthentication()
                .withUser("mem_user")
                .password(encoder.encode("password"))
                .roles("SUPER_ADMIN")
                .and()
                .withUser("guest")
                .password(encoder.encode("password"))
                .roles("GUEST")
                .and()
                .withUser("admin")
                .password(encoder.encode("password"))
                .roles("ADMIN")
                .and()
                .withUser("manager")
                .password(encoder.encode("password"))
                .roles("MANAGER");

        authBuild.userDetailsService(userDetailService);
    }

    @Configuration
    public static class UiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/**/*.css", "/**/*.js").permitAll()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/**").authenticated()
                    .and()
                    .formLogin().loginPage("/login")
                    .loginProcessingUrl("/login_processing")
                    .defaultSuccessUrl("/user")
                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/access_denied");
        }
    }
}
