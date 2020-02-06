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

    public Iterable<Banco> listarBancos(DadosSimulacao dadosSimulacao) throws listsrBancosExeptions {
        Iterable<Banco> listaBancos = simulacaoRepository.findByTipoEmprestimo(dadosSimulacao.getTipoEmprestimo());
        List<Banco> listaVazia = new ArrayList<>();

        if (listaBancos == listaVazia){
            throw new listsrBancosExeptions("Erro. preencha as informações obrigatorias!");
        }

        for(Banco lista : listaBancos){
            lista.setJuros(lista.getTaxa()*dadosSimulacao.getValorEmprestimo());
            lista.setTotalEmprestimo(lista.getJuros()+dadosSimulacao.getValorEmprestimo());
            lista.setTotalParcela(lista.getTotalEmprestimo()/dadosSimulacao.getParcelas());
            listaVazia.add(lista);
        }
       return listaVazia;



    }
}
