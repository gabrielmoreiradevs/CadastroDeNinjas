package dev.gabrielmoreira.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel listarMissoesPorID(Long idMissoes){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(idMissoes);
        return missoesModel.orElse(null);
    }
}
