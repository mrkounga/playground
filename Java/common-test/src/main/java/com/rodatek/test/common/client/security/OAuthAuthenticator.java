package com.rodatek.test.common.client.security;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.OAuthSignature;
import com.jayway.restassured.specification.RequestSpecification;
import com.rodatek.client.WebProperties;
import com.rodatek.test.common.client.security.ITestAuthenticator;
import com.rodatek.test.common.client.security.TokenResponse;

@Component
@Profile("client")
public class OAuthAuthenticator implements ITestAuthenticator {
    private Logger log = LoggerFactory.getLogger(getClass());

    private static final String CLIENT_ID = "live-test";
    private static final String CLIENT_SECRET = "bGl2ZS10ZXN0";

    @Autowired
    private WebProperties webProps;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public OAuthAuthenticator() {
        super();
    }

    // API
    
   

    @Override
    public final RequestSpecification givenAuthenticated(final String username, final String password) {
    	System.out.println("Request for Access token ");
        final String accessToken = getAccessToken(username,password);
        System.out.println("Access token is : "+accessToken);
        return RestAssured.given().auth().oauth2(accessToken, OAuthSignature.HEADER);
    }

    final String getAccessToken(final String username, final String password) {
        try {
        	 System.out.println(">>> password : "+password);
            final URI uri = new URI(webProps.getProtocol(), null, webProps.getHost(), webProps.getPort(), webProps.getPath() + webProps.getOauthPath(), null, null);
            final String url = uri.toString();
            final String encodedCredentials = new String(Base64.encodeBase64((CLIENT_ID + ":" + CLIENT_SECRET).getBytes()));

            final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("grant_type", "password");
            params.add("client_id", CLIENT_ID);
            params.add("username", username);
            String encodedPassword="$2a$10$IzKFYrQdv9R..03/Jg1xm.wgRdrM5fklIwGKkZW8cVG2RLI7j7oJe";
            System.out.println(">>>>>>>Encoded password  : "+encodedPassword);
            params.add("password", encodedPassword);

            final HttpHeaders headers = new HttpHeaders();
           headers.add("Authorization", "Basic " + encodedCredentials);
           // headers.add("Authorization", "Basic "+params);
            System.out.println(">>> Param : ");
            final HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

            final RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            
            System.out.println(">>> url : "+url);
            System.out.println(">>> request : "+request);
            final TokenResponse tokenResponse = restTemplate.postForObject(url, request, TokenResponse.class);
            final String accessToken = tokenResponse.getAccessToken();
            return accessToken;
        } catch (final HttpClientErrorException e) {
            log.warn("", e);
            log.info("Full Body = {}", e.getResponseBodyAsString());
        } catch (final URISyntaxException e) {
            log.warn("", e);
        }

        return null;
    }

}
