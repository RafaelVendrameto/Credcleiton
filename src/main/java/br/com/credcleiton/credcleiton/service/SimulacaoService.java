package br.com.credcleiton.credcleiton.service;

import br.com.credcleiton.credcleiton.model.Banco;
import br.com.credcleiton.credcleiton.model.DadosSimulacao;
import br.com.credcleiton.credcleiton.repository.SimulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class SimulacaoService {
    @Autowired
    private SimulacaoRepository simulacaoRepository;

    public Iterable<Banco> listarBancos(DadosSimulacao dadosSimulacao) {
        Iterable<Banco> listaBancos = simulacaoRepository.findByTipoEmprestimo(dadosSimulacao.getTipoEmprestimo());
        List<Banco> listaVazia = new ArrayList<>();

        for(Banco lista : listaBancos){
            DecimalFormat format = new DecimalFormat();
            lista.setJuros(lista.getTaxa()*dadosSimulacao.getValorEmprestimo());
            lista.setTotalEmprestimo(lista.getJuros()+dadosSimulacao.getValorEmprestimo());
            lista.setTotalParcela(lista.getTotalEmprestimo()/dadosSimulacao.getParcelas());
            listaVazia.add(lista);
        }
       return listaVazia;
    }



}
