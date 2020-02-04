package br.com.credcleiton.credcleiton.repository;

import br.com.credcleiton.credcleiton.model.Banco;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SimulacaoRepository extends CrudRepository<Banco, String> {
    Iterable<Banco> findByTipoEmprestimo(String nome);
    Iterable<Banco> findByTaxa(double taxa);
}
