package com.apbdoo.hrm.service;

import com.apbdoo.hrm.entity.Competenta;

import java.util.List;

public interface CompetentaService {
    List<Competenta> getCompetente();

    Competenta readCompetenta(long idCompetenta);

    Competenta saveCompetenta(Competenta competenta);

    void deleteCompetenta(long idCompetenta);
}
