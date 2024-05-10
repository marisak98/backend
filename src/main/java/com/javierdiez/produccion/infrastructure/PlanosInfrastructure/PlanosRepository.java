package com.javierdiez.produccion.infrastructure.PlanosInfrastructure;

import com.javierdiez.produccion.domian.planosDomain.Planos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanosRepository extends JpaRepository<Planos, Long> {
    Optional <Planos> findByName(String name);
}
