package com.apbdoo.hrm.config;

import com.apbdoo.hrm.util.EncryptionUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(EncryptionUtil.encrypt("user1")).roles("USER")
                .and()
                .withUser("user2").password(EncryptionUtil.encrypt("user2")).roles("USER")
                .and()
                .withUser("admin").password(EncryptionUtil.encrypt("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/utilizator/**").hasAnyRole("DIRECTOR", "ADMIN")
            .antMatchers("/functie/**").hasAnyRole("DIRECTOR", "HR")
            .antMatchers("/angajat/**").hasAnyRole("DIRECTOR", "HR")
            .antMatchers("/candidat/**").hasAnyRole("DIRECTOR", "RECRUITER")
            .antMatchers("/competenta/**").hasAnyRole("DIRECTOR", "RECRUITER")
            .antMatchers("/evaluare/**").hasAnyRole("DIRECTOR", "RECRUITER", "PROJECT MANAGER")
            .antMatchers("/login*").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }

}
