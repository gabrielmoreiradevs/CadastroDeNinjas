package dev.gabrielmoreira.CadastroDeNinjas.Missoes;

import dev.gabrielmoreira.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dificuldade;

    //@OneToMany Uma Missao tera varios ninja
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
