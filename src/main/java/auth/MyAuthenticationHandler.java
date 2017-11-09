package auth;

import org.apereo.cas.authentication.*;
import org.apereo.cas.authentication.principal.DefaultPrincipalFactory;
import org.apereo.cas.authentication.principal.PrincipalFactory;

import javax.annotation.PostConstruct;
import java.security.GeneralSecurityException;

public class MyAuthenticationHandler implements AuthenticationHandler {
    protected PrincipalFactory principalFactory = new DefaultPrincipalFactory();


    @PostConstruct
    private void init() {
    }
    @Override
    public HandlerResult authenticate(Credential credential) throws GeneralSecurityException, PreventedException {
        return new DefaultHandlerResult(this, new BasicCredentialMetaData(credential),
                this.principalFactory.createPrincipal("test"));
    }

    @Override
    public boolean supports(Credential credential) {
        return credential instanceof UsernamePasswordCredential;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}