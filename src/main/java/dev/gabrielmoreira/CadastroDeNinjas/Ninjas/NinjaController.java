package dev.gabrielmoreira.CadastroDeNinjas.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaRepository ninjaRepository;
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, NinjaRepository ninjaRepository) {
        this.ninjaService = ninjaService;
        this.ninjaRepository = ninjaRepository;
    }

    // CRUD
    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criada com sucesso! | " + novoNinja.toString());
    }

    // Mostrar todos os Ninjas (READ)
    @GetMapping("/todos")
    public ResponseEntity< List<NinjaDTO> > mostrarTodosOsNinjas(){
        return ResponseEntity.ok(ninjaService.mostrarTodosOsNinjas());
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/todos/{id}")
    public ResponseEntity<NinjaDTO> mostrarTodosOsNinjasPorID(@PathVariable Long id){

        if( ninjaRepository.existsById(id) ){
            return ResponseEntity.ok().body(ninjaService.mostrarTodosOsNinjasPorID(id));
        }
        return ResponseEntity.notFound().build();

    }

    // Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaModel){
        NinjaDTO ninja = ninjaService.alterarNinjaPorId(id, ninjaModel);

        if( ninja != null ){
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O ninja de id "+id+" não existe!");
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id){

        if(ninjaService.mostrarTodosOsNinjasPorID(id) != null){
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja Deletado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja de id: "+id+" não existe!");
    }

}
