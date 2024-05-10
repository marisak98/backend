package com.javierdiez.produccion.domian.planosDomain.factory;

import com.javierdiez.produccion.domian.planosDomain.Planos;
import com.javierdiez.produccion.domian.planosDomain.event.PlanoCargadoEvent;

public class PlanoFactory {
    public Planos planoCargado(Long id, String areaDisenio, String nombreDiseniador){
        Planos planos = new Planos();
        PlanoCargadoEvent event = new PlanoCargadoEvent(planos.getId(), areaDisenio, nombreDiseniador);

        return planos;
    }
}
