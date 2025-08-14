package dev.gabrielmoreira.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

//Aqui definimos que aqui ira ir todas as rotas de nossa API
@RestController

//Aqui mapearemos todas as nossas api
@RequestMapping("missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Lista de missoes";
    }

    @PostMapping("/criar")
    public String criarMissoes(){
        return "Missao Criada com sucesso!";
    }

    @PutMapping("/alterarID")
    public String alterarMissaoID(){
        return "Missao Alterada com sucesso!";
    }

    @DeleteMapping("/deletar")
    public String deletarMissaoID(){
        return "Missao Deletada com sucesso!";
    }
}
