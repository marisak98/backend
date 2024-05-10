package com.javierdiez.produccion.domian.tareaDomain;

import com.javierdiez.produccion.domian.planosDomain.Planos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "task")
@Setter @Getter
public class Tarea {

    @Id
    @Column(name = "id_task", nullable = false)
    private Long id;

    @Column(name = "name_task", nullable = false)
    private String name;

    @Column(name = "area", nullable = false)
    private String area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_blueprint")
    private Planos plano;
}