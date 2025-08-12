package dev.gabrielmoreira.CadastroDeNinjas.Missoes;

import dev.gabrielmoreira.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "dificuldade")
    private String dificuldade;

    //@OneToMany Uma Missao tera varios ninja
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
