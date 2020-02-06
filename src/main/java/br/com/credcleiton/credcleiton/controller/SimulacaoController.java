package br.com.credcleiton.credcleiton.controller;

import br.com.credcleiton.credcleiton.model.Banco;
import br.com.credcleiton.credcleiton.model.DadosSimulacao;
import br.com.credcleiton.credcleiton.service.SimulacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimulacaoController {
    @Autowired
    private SimulacaoService simulacaoService;


    @Controller
    public class TesteController {
        @GetMapping
        public String mostrarHome() {
            return "index";
        }

        @GetMapping("/simulacao")
        public String simulador() {
            return "simulador";
        }

        @PostMapping("/resultado")
        public Object listarBancos(DadosSimulacao dadosSimulacao, Model model) {
            ModelAndView pagina = new ModelAndView("resultado");
            Iterable<Banco> banco = simulacaoService.listarBancos(dadosSimulacao);

            pagina.addObject("bancos", banco);

            return pagina;
        }
    }
}
