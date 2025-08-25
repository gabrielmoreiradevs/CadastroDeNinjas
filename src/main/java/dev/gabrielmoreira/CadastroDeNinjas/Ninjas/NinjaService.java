package dev.gabrielmoreira.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os Ninjas
    public List<NinjaDTO> mostrarTodosOsNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar por ID
    public NinjaDTO mostrarTodosOsNinjasPorID(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //Criar novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar por ID
    public void deletarNinjaPorID(Long id){
        ninjaRepository.deleteById(id);
    }

    //Alterar por Id
    public NinjaDTO alterarNinjaPorId(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> optionalNinja  = ninjaRepository.findById(id);

        if(optionalNinja.isPresent()){
            NinjaModel ninjaExistente = optionalNinja.get();
            // 3. Verifica cada campo do DTO. Se não for nulo, atualiza o campo no objeto existente.
            if (ninjaDTO.getNome() != null) {
                ninjaExistente.setNome(ninjaDTO.getNome());
            }
            if (ninjaDTO.getEmail() != null) {
                ninjaExistente.setEmail(ninjaDTO.getEmail());
            }
            if (ninjaDTO.getImgUrl() != null) {
                ninjaExistente.setImgUrl(ninjaDTO.getImgUrl());
            }

            // Para o tipo primitivo 'int', a verificação de nulidade não funciona diretamente.
            // Uma abordagem comum é usar o wrapper Integer no DTO ou verificar por um valor padrão (como 0).
            // Assumindo que a idade 0 não é válida, podemos fazer:
            if (ninjaDTO.getIdade() > 0) { // Ou a verificação que fizer sentido para sua regra de negócio
                ninjaExistente.setIdade(ninjaDTO.getIdade());
            }
            if (ninjaDTO.getRank() != null) {
                ninjaExistente.setRank(ninjaDTO.getRank());
            }
            if (ninjaDTO.getMissoes() != null) {
                ninjaExistente.setMissoes(ninjaDTO.getMissoes());
            }

            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaExistente);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

}
