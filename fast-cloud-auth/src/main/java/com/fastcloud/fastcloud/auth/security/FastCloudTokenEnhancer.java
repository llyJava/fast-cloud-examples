package com.fastcloud.fastcloud.auth.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Describe:
 *
 * @Author sunliang
 * @Since 2019/07/10
 */
@Slf4j
public class FastCloudTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        log.info(":>>> MermaidTokenEnhancer enhance ");
        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("userId", 1001L);
        additionalInfo.put("roles", "admin");
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        log.debug(":>>> MermaidTokenEnhancer {$accessToken}:{}", accessToken);
        return accessToken;
    }
}
