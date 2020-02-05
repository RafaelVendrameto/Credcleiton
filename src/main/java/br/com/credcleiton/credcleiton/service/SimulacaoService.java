package br.com.credcleiton.credcleiton.service;

import br.com.credcleiton.credcleiton.model.Banco;
import br.com.credcleiton.credcleiton.model.DadosSimulacao;
import br.com.credcleiton.credcleiton.repository.SimulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SimulacaoService {
    @Autowired
    private SimulacaoRepository simulacaoRepository;

    public Iterable<Banco> listarBancos(DadosSimulacao dadosSimulacao) {
        Iterable<Banco> listaBancos = simulacaoRepository.findByTipoEmprestimo(dadosSimulacao.getTipoEmprestimo());
        //lista vazia tipo Banco
        List<Banco> listaVazia = new ArrayList<Banco>();
        for(Banco lista : listaBancos){
            //lista.setJuros(lista.getTaxa() * dadosSimulacao.getValorEmprestimo());
            lista.setJuros(lista.getTaxa()*dadosSimulacao.getValorEmprestimo());
            //lista.setCadaParcela();
            lista.setTotalEmprestimo(lista.getJuros()+dadosSimulacao.getValorEmprestimo());
            //lista.setTotalEmprestimo();
            lista.setTotalParcela(lista.getTotalEmprestimo()-dadosSimulacao.getParcelas());
            //listavazia.add(r)
            listaVazia.add(lista);
        }
       return listaVazia;
    }



}
