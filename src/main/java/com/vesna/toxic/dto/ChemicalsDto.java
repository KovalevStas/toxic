package com.vesna.toxic.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChemicalsDto {
    private String casrn;
    private String cname;
    private String route;
}
