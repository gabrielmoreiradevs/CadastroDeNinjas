package dev.gabrielmoreira.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os Ninjas
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaRepository.findAll();
    }

    //Listar por ID
    public NinjaModel mostrarTodosOsNinjasPorID(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }
}
