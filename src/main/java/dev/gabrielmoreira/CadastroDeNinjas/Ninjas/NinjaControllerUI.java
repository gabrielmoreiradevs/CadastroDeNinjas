package dev.gabrielmoreira.CadastroDeNinjas.Ninjas;


import dev.gabrielmoreira.CadastroDeNinjas.Missoes.MissoesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;
    private final MissoesRepository missoesRepository;

    // ATUALIZADO: Construtor para incluir o MissoesRepository
    public NinjaControllerUI(NinjaService ninjaService, MissoesRepository missoesRepository) {
        this.ninjaService = ninjaService;
        this.missoesRepository = missoesRepository;
    }

    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.mostrarTodosOsNinjas();
        model.addAttribute("ninjas", ninjas);
        return "ninjas/listarNinjas";
    }


    @GetMapping("/novo")
    public String mostrarFormularioParaNovoNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        model.addAttribute("todasAsMissoes", missoesRepository.findAll());
        return "ninjas/formularioNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute("ninja") NinjaDTO ninjaDTO) {
        if (ninjaDTO.getId() == null) {
            ninjaService.criarNinja(ninjaDTO);
        } else {
            ninjaService.alterarNinjaPorId(ninjaDTO.getId(), ninjaDTO);
        }
        return "redirect:/ninjas/ui/todos";
    }


    @GetMapping("/alterar/{id}")
    public String mostrarFormularioParaAlterarNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninjaExistente = ninjaService.mostrarTodosOsNinjasPorID(id);
        model.addAttribute("ninja", ninjaExistente);
        model.addAttribute("todasAsMissoes", missoesRepository.findAll());
        return "ninjas/formularioNinja";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarNinjaPorID(@PathVariable Long id) {
        ninjaService.deletarNinjaPorID(id);
        return "redirect:/ninjas/ui/todos";
    }

    @GetMapping("/listar/{id}")
    public String mostrarDetalhesDoNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.mostrarTodosOsNinjasPorID(id);

        model.addAttribute("ninja", ninja);

        return "ninjas/detalhesNinja";
    }
}