package com.vesna.toxic.service;

import com.vesna.toxic.dto.ChemicalsDto;
import com.vesna.toxic.exception.ValidationException;

import java.util.List;

public interface ChemicalsService {
    ChemicalsDto saveChemical(ChemicalsDto chemicalsDto) throws ValidationException;

    void deleteChemical(String casrn);

    ChemicalsDto findByCasrn(String casrn);

    List<ChemicalsDto> findAll();
}
