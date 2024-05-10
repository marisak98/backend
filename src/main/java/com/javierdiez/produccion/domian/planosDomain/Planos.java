package com.javierdiez.produccion.domian.planosDomain;

import com.javierdiez.produccion.domian.ordenProduccionDomain.OrdenProduccion;
import com.javierdiez.produccion.domian.tareaDomain.Tarea;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "blueprint")
@Getter @Setter
public class Planos {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_blueprint", nullable = false)
        private Long id;

        @Column(name = "name_blueprint", nullable = false)
        private String name;

        @Column(name = "description_blueprint", nullable = false)
        private String description;

        @Column(name = "s3_url", nullable = false)
          private String s3Url;

        @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL)
        private List<Tarea> tareas;

        @ManyToOne
        @JoinColumn(name = "id_order_production")
        private OrdenProduccion ordenProduccion;

}
