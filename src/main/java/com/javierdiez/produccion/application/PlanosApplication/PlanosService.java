package com.javierdiez.produccion.application.PlanosApplication;

import com.javierdiez.produccion.domian.planosDomain.Planos;
import com.javierdiez.produccion.infrastructure.PlanosInfrastructure.PlanosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanosService {

    private final PlanosRepository planosRepository;

    @Autowired
    public PlanosService(PlanosRepository planosRepository) {
        this.planosRepository = planosRepository;
    }

    public List<Planos> getAllPlanos() {
        return planosRepository.findAll();
    }

    public Planos getPlanosById(Long id) {
        return planosRepository.findById(id).orElse(null);
    }


}
