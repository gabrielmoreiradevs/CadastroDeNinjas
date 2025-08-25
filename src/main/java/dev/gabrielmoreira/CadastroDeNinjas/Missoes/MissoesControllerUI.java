package dev.gabrielmoreira.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUI {

    private final MissoesService missoesService;

    public MissoesControllerUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/todos")
    public String mostrarTodasAsMissoes(Model model) {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "missoes/listarMissoes";
    }

    @GetMapping("/novo")
    public String mostrarFormularioParaNovaMissao(Model model) {
        model.addAttribute("missao", new MissoesDTO());
        return "missoes/formularioMissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute("missao") MissoesDTO missoesDTO) {
        if (missoesDTO.getId() == null) {
            missoesService.criarMissoes(missoesDTO);
        } else {
            missoesService.alterarMissoesPorId(missoesDTO.getId(), missoesDTO);
        }
        return "redirect:/missoes/ui/todos";
    }

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioParaAlterarMissao(@PathVariable Long id, Model model) {
        MissoesDTO missaoExistente = missoesService.listarMissoesPorID(id);
        model.addAttribute("missao", missaoExistente);
        return "missoes/formularioMissao";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarMissaoPorID(@PathVariable Long id) {
        missoesService.deletarMissoesPorId(id);
        return "redirect:/missoes/ui/todos";
    }
}