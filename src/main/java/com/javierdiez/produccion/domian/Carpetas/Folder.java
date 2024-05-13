package com.javierdiez.produccion.domian.Carpetas;

import com.javierdiez.produccion.domian.planosDomain.Planos;
import com.javierdiez.produccion.domian.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "folder")
@Getter @Setter
public class Folder {

    public Folder(String name_folder, String path, Long parentId, String teamId, Team team, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name_folder = name_folder;
        this.path = path;
        this.parentId = parentId;
        this.teamId = teamId;
        this.team = team;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Folder() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_folder;

    @Column(name = "name_folder", nullable = false)
    private String name_folder;

    @Column(name= "path", nullable = false)
    private String path;

    @Column
    private Long parentId;

    @OneToMany(mappedBy = "folder")
    private List<Planos> planos;

    @ManyToOne
    @JoinColumn(name = "parentId", insertable = false, updatable = false)
    private Folder parentFolder;

    @Column(nullable = false)
    private String teamId;

   @ManyToOne
   @JoinColumn(name = "teamId", insertable = false, updatable = false)
    private Team team;

   @Column(nullable = false)
    private LocalDateTime createdAt;

   @Column(nullable = false)
    private LocalDateTime updatedAt;


}
