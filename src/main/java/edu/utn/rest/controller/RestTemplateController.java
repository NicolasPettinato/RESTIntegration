package edu.utn.rest.controller;

import edu.utn.rest.dto.CallsTotalByMonthDto;
import edu.utn.rest.service.IntegrationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    IntegrationService integrationService;

    @Autowired
    public RestTemplateController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @GetMapping("/calls/month/{month}")
    @ApiOperation(value = "get total calls by month")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "get total calls by month OK"),
            @ApiResponse(code = 204, message = "not content of calls by month"),
            @ApiResponse(code = 400, message = "bad request")

    })
    public ResponseEntity<List<CallsTotalByMonthDto>> getCallsByMonthFromAPI(@PathVariable int month ) throws HttpClientErrorException, NumberFormatException {
        ResponseEntity<List<CallsTotalByMonthDto>> callsTotalByMonth = integrationService.getCallsByMonthFromAPI(month);
        return callsTotalByMonth;
    }}
