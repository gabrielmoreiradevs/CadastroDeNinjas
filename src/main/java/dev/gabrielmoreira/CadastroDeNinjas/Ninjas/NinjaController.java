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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/todos")
    public List<NinjaDTO> mostrarTodosOsNinjas(){
        return ninjaService.mostrarTodosOsNinjas();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/todos/{id}")
    public NinjaDTO mostrarTodosOsNinjasPorID(@PathVariable Long id){
        return ninjaService.mostrarTodosOsNinjasPorID(id);
    }

    // Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaModel){
        return ninjaService.alterarNinjaPorId(id, ninjaModel);
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID(@PathVariable Long id){
        ninjaService.deletarNinjaPorID(id);
    }

}
