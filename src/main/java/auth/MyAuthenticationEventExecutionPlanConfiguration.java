package auth;

import org.apereo.cas.authentication.*;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.configuration.CasConfigurationProperties;

import org.apereo.cas.authentication.principal.DefaultPrincipalFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.security.GeneralSecurityException;

@Configuration("MyAuthenticationEventExecutionPlanConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class MyAuthenticationEventExecutionPlanConfiguration implements AuthenticationEventExecutionPlanConfigurer{

    @Autowired
    private CasConfigurationProperties casProperties;

    @RefreshScope
    @Bean
    public AuthenticationHandler myAuthHandler() {
        final MyAuthenticationHandler h = new MyAuthenticationHandler();
        return h;
    }

    @Override
    public void configureAuthenticationExecutionPlan(AuthenticationEventExecutionPlan authenticationEventExecutionPlan) {
        authenticationEventExecutionPlan.registerAuthenticationHandler(myAuthHandler());
    }
}