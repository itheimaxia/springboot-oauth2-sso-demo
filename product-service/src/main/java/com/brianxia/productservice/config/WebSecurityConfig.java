package com.brianxia.productservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author brianxia
 * @version 1.0
 * @date 2020/11/22 15:12
 */
@EnableOAuth2Sso
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${oauth2.logout}")
    private String logoutUrl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout().logoutSuccessUrl(logoutUrl);
        http.authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
    }
}
