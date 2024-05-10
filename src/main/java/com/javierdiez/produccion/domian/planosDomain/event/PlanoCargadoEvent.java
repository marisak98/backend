package com.javierdiez.produccion.domian.planosDomain.event;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlanoCargadoEvent {

    private final Long id;
    private final String areaDisenio;
    private final String nombreDiseniador;

    public PlanoCargadoEvent(Long id, String areaDisenio, String nombreDiseniador) {
        this.id = id;
        this.areaDisenio = areaDisenio;
        this.nombreDiseniador = nombreDiseniador;
    }

}
