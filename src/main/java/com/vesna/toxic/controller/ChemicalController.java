package com.vesna.toxic.controller;

import com.vesna.toxic.dto.ChemicalsDto;
import com.vesna.toxic.exception.ValidationException;
import com.vesna.toxic.service.ChemicalsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chemicals")
@AllArgsConstructor
@Log
public class ChemicalController {

    private final ChemicalsService chemicalsService;

    @PostMapping("/save")
    public ChemicalsDto saveChemicals(@RequestBody ChemicalsDto chemicalsDto) throws ValidationException {
        log.info("Handling save chemicals: " + chemicalsDto);
        return chemicalsService.saveChemical(chemicalsDto);
    }

    @GetMapping("/findAll")
    public List<ChemicalsDto> findAllChemicals() {
        log.info("Handling find all chemicals request");
        return chemicalsService.findAll();
    }

    @GetMapping("/findByCasrn")
    public ChemicalsDto findByCasrn(@RequestParam String casrn) {
        log.info("Handling find by casrn request: " + casrn);
        return chemicalsService.findByCasrn(casrn);
    }

    @DeleteMapping("/delete/{casrn}")
    public ResponseEntity<Void> deleteChemicals(@PathVariable String casrn) {
        log.info("Handling delete chemical request: " + casrn);
        chemicalsService.deleteChemical(casrn);
        return ResponseEntity.ok().build();
    }
}
