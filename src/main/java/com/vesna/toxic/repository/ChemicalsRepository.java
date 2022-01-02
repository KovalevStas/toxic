package com.vesna.toxic.repository;

import com.vesna.toxic.entity.Chemicals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChemicalsRepository extends JpaRepository<Chemicals,String> {

    Chemicals findByCasrn(String casrn);
}
