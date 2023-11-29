//package com.dictionary.dictionary.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Optional;
//
//@Service
//public class OxfordApiService {
//
//    @Autowired
//    private RestTemplate oxfordApiClient;
//
////    public Optional<OxfordResponse> getWordDefinition(String word) {
////        String url = String.format("%s/definition/en/%s", baseUrl, word);
////        ResponseEntity<OxfordResponse> response = oxfordApiClient.getForEntity(url, OxfordResponse.class);
////        return response.getStatusCode().is2xxSuccessful() ? Optional.of(response.getBody()) : Optional.empty();
////    }
//}
