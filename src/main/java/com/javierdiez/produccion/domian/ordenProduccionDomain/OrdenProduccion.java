package com.javierdiez.produccion.domian.ordenProduccionDomain;

import com.javierdiez.produccion.domian.planosDomain.Planos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "order_production")
@Getter @Setter
public class OrdenProduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_op", nullable = false)
    private Long id;

    @Column(name = "name_op", nullable = false)
    private String name;

    @Column(name = "description_op", nullable = false)
    private String description;

    @Column(name = "quantity_op", nullable = false)
    private int quantity;

    @Column(name = "status_op", nullable = false)
    private String status;


    @OneToMany(mappedBy = "ordenProduccion", cascade = CascadeType.ALL)
    private List<Planos> planos;

}
