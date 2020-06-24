package edu.utn.rest.service.integration;

import edu.utn.rest.dto.CallsTotalByMonthDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
@Component
public class IntegrationComponent {

    private RestTemplate rest;
      private static String url = "http://localhost:8080/calls/{month}";

    @PostConstruct
    private void init() {
        rest = new RestTemplateBuilder()
                .build();
    }

    public ResponseEntity<List<CallsTotalByMonthDto>> getCallsByMonthFromAPI(int month) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("month", String.valueOf(month));

        URI uri = UriComponentsBuilder.fromUriString(url)
                .buildAndExpand(urlParams)
                .toUri();

        ResponseEntity<List<CallsTotalByMonthDto>> response = rest.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<CallsTotalByMonthDto>>() {
        });
        return response;
    }


}
