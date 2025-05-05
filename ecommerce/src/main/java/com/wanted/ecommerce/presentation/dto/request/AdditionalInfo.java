package com.wanted.ecommerce.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AdditionalInfo {

    @JsonProperty("assembly_required")
    private Boolean assemblyRequired;

    @JsonProperty("assembly_time")
    private String assemblyTime;

}
