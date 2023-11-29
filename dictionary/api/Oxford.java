//package com.dictionary.dictionary.api;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.client.ClientHttpRequestExecution;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.http.client.ClientHttpResponse;
//
//import java.io.IOException;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.IOException;
//import java.util.Collections;
//@Configuration
//public class Oxford {
//    @Value("${oxford.api.base-url}")
//    private String baseUrl;
//    @Value("${oxford.api.key}")
//    private String apiKey;
//
//    @Bean
//    public RestTemplate oxfordApiClient() {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setInterceptors(Collections.singletonList(new OxfordApiKeyInterceptor(apiKey)));
//        return restTemplate;
//    }
//
//    private static class OxfordApiKeyInterceptor implements ClientHttpRequestInterceptor {
//        private final String apiKey;
//
//        public OxfordApiKeyInterceptor(String apiKey) {
//            this.apiKey = apiKey;
//        }
//
//        @Override
//        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException, IOException {
//            request.getHeaders().add("apikey", apiKey);
//            return execution.execute(request, body);
//        }
//    }
//
//
//}
