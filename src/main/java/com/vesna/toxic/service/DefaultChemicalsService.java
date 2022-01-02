package com.vesna.toxic.service;

import com.vesna.toxic.dto.ChemicalsDto;
import com.vesna.toxic.entity.Chemicals;
import com.vesna.toxic.exception.ValidationException;
import com.vesna.toxic.repository.ChemicalsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@AllArgsConstructor
@Service
public class DefaultChemicalsService implements ChemicalsService{
    private final ChemicalsRepository chemicalsRepository;
    private final ChemicalConverter chemicalsConverter;

    private void validateChemicalDto(ChemicalsDto chemicalsDto) throws ValidationException {
        if (isNull(chemicalsDto)) {
            throw new ValidationException("Object chemical is null");
        }
        if (isNull(chemicalsDto.getCasrn()) || chemicalsDto.getCasrn().isEmpty()) {
            throw new ValidationException("Casrn is empty");
        }
    }

    @Override
    public ChemicalsDto saveChemical(ChemicalsDto chemicalsDto) throws ValidationException {
        validateChemicalDto(chemicalsDto);
        Chemicals savedChemical = chemicalsRepository.save(chemicalsConverter.fromChemicalDtoToChemical(chemicalsDto));
        return chemicalsConverter. fromChemicalToChemicalDto(savedChemical);
    }

    @Override
    public void deleteChemical(String casrn) {
        chemicalsRepository.deleteById(casrn);
    }

    @Override
    public ChemicalsDto findByCasrn(String casrn) {
        Chemicals Chemicals = chemicalsRepository.findByCasrn(casrn);
        if (Chemicals != null) {
            return chemicalsConverter.fromChemicalToChemicalDto(Chemicals);
        }
        return null;
    }

    @Override
    public List<ChemicalsDto> findAll() {
        return chemicalsRepository.findAll()
                .stream()
                .map(chemicalsConverter::fromChemicalToChemicalDto)
                .collect(Collectors.toList());
    }

}
