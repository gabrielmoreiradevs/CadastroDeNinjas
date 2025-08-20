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
    public MissoesModel criarMissoes(@RequestBody MissoesModel missoesModel){
        return missoesService.criarMissoes(missoesModel);
    }

    @PutMapping("/alterarID")
    public String alterarMissaoID(){
        return "Missao Alterada com sucesso!";
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoID(@PathVariable Long id){missoesService.deletarMissoesPorId(id);}

}
