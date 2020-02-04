package br.com.credcleiton.credcleiton.repository;

import br.com.credcleiton.credcleiton.model.Banco;
import org.springframework.data.repository.CrudRepository;

public interface SimulacaoRepository extends CrudRepository<Banco, String> {
}
