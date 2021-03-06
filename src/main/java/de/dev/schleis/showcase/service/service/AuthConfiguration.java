package de.dev.schleis.showcase.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter
{

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{bcrypt}$2a$10$tvdJ8njst9h5J0BovBFzqelV9O6lEuOXTPTJF5R3Sfm9DWMmp5.lO").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/customer/deleteAll").hasRole("ADMIN")
                .antMatchers("/customer/*").hasRole("USER")
                .anyRequest().authenticated();

        http.csrf().disable();
    }
}
