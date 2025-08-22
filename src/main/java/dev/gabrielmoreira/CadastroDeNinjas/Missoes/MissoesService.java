package dev.gabrielmoreira.CadastroDeNinjas.Missoes;

import dev.gabrielmoreira.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.gabrielmoreira.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissoesPorID(Long idMissoes){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(idMissoes);
        return missoesModel.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissoes(MissoesDTO missoesDTO){
        MissoesModel missoes = missoesMapper.map(missoesDTO);
        missoes =  missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    public MissoesDTO alterarMissoesPorId(Long idMissoes, MissoesDTO missoesDTO){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(idMissoes);

        if(missoesModel.isPresent()){
            MissoesModel missoes = missoesMapper.map(missoesDTO);
            missoes.setId(idMissoes);

            MissoesModel missoesSalva = missoesRepository.save(missoes);
            return missoesMapper.map(missoesSalva);
        }
        return null;
    }

    public void deletarMissoesPorId(Long idMissoes){ missoesRepository.deleteById(idMissoes); }
}
