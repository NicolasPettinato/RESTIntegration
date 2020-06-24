package edu.utn.rest.service;

import edu.utn.rest.dto.CallsTotalByMonthDto;
import edu.utn.rest.service.integration.IntegrationComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegrationService {

    @Autowired
    IntegrationComponent integrationComponent;

    public IntegrationService(IntegrationComponent integrationComponent) {
        this.integrationComponent = integrationComponent;
    }

    public ResponseEntity<List<CallsTotalByMonthDto>> getCallsByMonthFromAPI(int month) {
        return integrationComponent.getCallsByMonthFromAPI(month);
    }


}
