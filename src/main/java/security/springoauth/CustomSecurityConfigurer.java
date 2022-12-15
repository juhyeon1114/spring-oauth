package security.springoauth;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Slf4j
public class CustomSecurityConfigurer extends AbstractHttpConfigurer<CustomSecurityConfigurer, HttpSecurity> {

    private Boolean isSecure;

    @Override
    public void init(HttpSecurity builder) throws Exception {
        super.init(builder);
        log.info("=== init method");
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        super.configure(builder);
        log.info("=== configure method");

        if (isSecure) {
            log.warn("=== HTTPS is required");
        } else {
            log.warn("=== HTTPS is optional");
        }
    }

    public CustomSecurityConfigurer setSecure(Boolean secure) {
        isSecure = secure;
        return this;
    }
}
