package dev.gabrielmoreira.CadastroDeNinjas.Ninjas;

import dev.gabrielmoreira.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

//JPA = Java persistence API
//Entity transforma uma classe em uma entidade do Banco de dados.
@Entity
//Table Cria uma tabela com as colunas(Definindo o nome da tabela inteira!)
@Table(name = "tb_cadastro")
public class NinjaModel {

    //Definindo o ID com a annotation
    @Id
    //Passando a estrategia de definir a sequencia dos ID's
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private int idade;

    //@ManyToOne Um ninja tera apenas uma unica missao!
    @ManyToOne
    @JoinColumn(name="missoes_id")//Foreina Key ou Chave Estrangeira
    private MissoesModel missoes;

    //NoArgs
    public NinjaModel() {
    }
    //AllArgs
    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    //Getter and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}