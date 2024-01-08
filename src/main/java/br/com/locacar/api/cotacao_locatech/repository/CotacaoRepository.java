package br.com.locacar.api.cotacao_locatech.repository;

import br.com.locacar.api.cotacao_locatech.entities.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {
}
