package br.com.credcleiton.credcleiton.Controller;

import br.com.credcleiton.credcleiton.model.Banco;
import br.com.credcleiton.credcleiton.model.DadosSimulacao;
import br.com.credcleiton.credcleiton.service.SimulacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimulacaoController {
    @Autowired
    private SimulacaoService simulacaoService;

    @GetMapping
    public String simulador(){
        return "simulador";
    }

    @PostMapping("/resposta")
    public String listarBancos(@ModelAttribute DadosSimulacao dadosSimulacao, Model model){
        Iterable<Banco> banco = simulacaoService.listarBancos(dadosSimulacao);
        model.addAttribute("bancos", banco);
        return "resposta";
    }
}
