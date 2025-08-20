package dev.gabrielmoreira.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//Aqui definimos que aqui ira ir todas as rotas de nossa API
@RestController

//Aqui mapearemos todas as nossas api
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoes(@PathVariable Long id){
        return missoesService.listarMissoesPorID(id);
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
