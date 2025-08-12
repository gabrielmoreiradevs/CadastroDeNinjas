package dev.gabrielmoreira.CadastroDeNinjas.Ninjas;

import dev.gabrielmoreira.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//JPA = Java persistence API
//Entity transforma uma classe em uma entidade do Banco de dados.
@Entity

//Table Cria uma tabela com as colunas(Definindo o nome da tabela inteira!)
@Table(name = "tb_cadastro")

//Trabalhando com Lombok, tirando o gasto de ficar fazendo overload.
@NoArgsConstructor
@AllArgsConstructor
@Data //Cria todos Getter's and Setter's
public class NinjaModel {

    //Definindo o ID com a annotation
    @Id
    //Passando a estrategia de definir a sequencia dos ID's
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;


    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    //@ManyToOne Um ninja tera apenas uma unica missao!
    @ManyToOne
    @JoinColumn(name="missoes_id")//Foreina Key ou Chave Estrangeira
    private MissoesModel missoes;

}