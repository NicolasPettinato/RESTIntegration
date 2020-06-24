package edu.utn.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CallsTotalByMonthDto {
    @ApiModelProperty(notes = "name of client")
    String name;

    @ApiModelProperty(notes = "lastname of client")
    String lastname;

    @ApiModelProperty(notes = "total user calls")
    int totalCall;

}
