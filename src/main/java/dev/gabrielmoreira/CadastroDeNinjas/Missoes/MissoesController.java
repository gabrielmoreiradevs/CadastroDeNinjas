package dev.gabrielmoreira.CadastroDeNinjas.Missoes;

import dev.gabrielmoreira.CadastroDeNinjas.Ninjas.NinjaDTO;
import dev.gabrielmoreira.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Aqui definimos que aqui ira ir todas as rotas de nossa API
@RestController

//Aqui mapearemos todas as nossas api
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesRepository missoesRepository;
    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService, MissoesRepository missoesRepository) {
        this.missoesService = missoesService;
        this.missoesRepository = missoesRepository;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        return ResponseEntity.ok(missoesService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<MissoesDTO> listarMissoes(@PathVariable Long id){

        if( missoesRepository.existsById(id) ){
            return ResponseEntity.ok().body(missoesService.listarMissoesPorID(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissoes(@RequestBody MissoesDTO missoesModel){
        missoesService.criarMissoes(missoesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missão Criada com sucesso!");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<MissoesDTO> alterarMissaoID(@PathVariable Long idMissoes, @RequestBody MissoesDTO missoesModel){
        if( missoesRepository.existsById(idMissoes) ){
            return ResponseEntity.status(HttpStatus.OK).body(missoesService.alterarMissoesPorId(idMissoes,missoesModel));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoID(@PathVariable Long id){
        if( missoesRepository.existsById(id) ){
            missoesService.deletarMissoesPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Missão deletada com sucesso! "+id+" (ID)");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de id "+id+" não existe!");
    }

}
