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
        chemicals.setCrit_systems(chemicalsDto.getCrit_systems());
        return chemicals;
    }

    public ChemicalsDto fromChemicalToChemicalDto(Chemicals chemicals) {
        return ChemicalsDto.builder()
                .casrn(chemicals.getCasrn())
                .cname(chemicals.getCname())
                .crit_systems(chemicals.getCrit_systems())
                .build();
    }
}
