package com.javierdiez.produccion.domian.planosDomain.handler;

import org.springframework.stereotype.Component;

@Component
public class PlanoCargadoEvent implements DomainEventHandler<PlanoCargadoEvent> {
    @Override
    public void handle(PlanoCargadoEvent domainEvent) {
        System.out.println("Plano cargado con id: ");
    }
}
