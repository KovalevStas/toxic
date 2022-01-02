package com.vesna.toxic.service;

import com.vesna.toxic.dto.ChemicalsDto;
import com.vesna.toxic.entity.Chemicals;
import org.springframework.stereotype.Component;

@Component
public class ChemicalConverter {

    public Chemicals fromChemicalDtoToChemical(ChemicalsDto chemicalsDto) {
        Chemicals chemicals = new Chemicals();
        chemicals.setCasrn(chemicalsDto.getCasrn());
        chemicals.setCname(chemicalsDto.getCname());
        chemicals.setRoute(chemicalsDto.getRoute());
        return chemicals;
    }

    public ChemicalsDto fromChemicalToChemicalDto(Chemicals users) {
        return ChemicalsDto.builder()
                .casrn(users.getCasrn())
                .cname(users.getCname())
                .route(users.getRoute())
                .build();
    }
}
