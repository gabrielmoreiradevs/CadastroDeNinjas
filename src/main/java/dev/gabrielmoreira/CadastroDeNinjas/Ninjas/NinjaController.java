package dev.gabrielmoreira.CadastroDeNinjas.Ninjas;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // CRUD
    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criar(){
        return "Ninja criada com sucesso!";
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/todos")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.mostrarTodosOsNinjas();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/todos/{id}")
    public NinjaModel mostrarTodosOsNinjasPorID(@PathVariable Long id){
        return ninjaService.mostrarTodosOsNinjasPorID(id);
    }

    // Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorID(){
        return "Ninja alterado com sucesso!";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorID(){
        return "Ninja deletado com sucesso!";
    }

}
