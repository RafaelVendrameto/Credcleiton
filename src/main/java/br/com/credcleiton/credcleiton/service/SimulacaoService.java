package br.com.credcleiton.credcleiton.service;

import br.com.credcleiton.credcleiton.model.Banco;
import br.com.credcleiton.credcleiton.model.DadosSimulacao;
import br.com.credcleiton.credcleiton.repository.SimulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimulacaoService {
    @Autowired
    private SimulacaoRepository simulacaoRepository;

    public Iterable<Banco> listarBancos(DadosSimulacao dadosSimulacao) {

        Iterable<Banco> bancos = simulacaoRepository.findAll();

        return bancos;
    }
}
