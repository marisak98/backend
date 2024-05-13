package com.javierdiez.produccion.domian.team;

import com.javierdiez.produccion.domian.Carpetas.Folder;
import com.javierdiez.produccion.domian.emails.Emails;
import com.javierdiez.produccion.domian.planosDomain.Planos;
import com.javierdiez.produccion.domian.salaDeDatos.DataRoom;
import com.javierdiez.produccion.domian.usuarioDomain.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "team")
@Accessors(chain = true)
@Setter @Getter
public class Team {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id_team;

   @Column(name = "name_team", nullable = false)
    private String name;

   @OneToMany
   @Column(name = "id_user")
    private List<Usuario> usuarios;

   @OneToMany(mappedBy = "team")
   @Column(name = "id_blueprint")
    private List<Planos> planos;

   @OneToMany(mappedBy = "team")
    private List<Folder> folders;

   @OneToMany(mappedBy = "team")
    private List<Emails> email;

   @OneToMany(mappedBy = "team")
    private List<DataRoom> dataRooms;

   @Column(nullable = false)
    private LocalDateTime createdAt;

   @Column(nullable = false)
    private LocalDateTime updatedAt;
}
