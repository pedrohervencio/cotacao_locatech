package br.com.locacar.api.cotacao_locatech.dto;

import br.com.locacar.api.cotacao_locatech.entities.Diretor;
import br.com.locacar.api.cotacao_locatech.entities.Administrativo;
import br.com.locacar.api.cotacao_locatech.entities.Proposta;
import br.com.locacar.api.cotacao_locatech.valueobject.Veiculo;

import java.util.List;


public record CotacaoDTO(
        Long numero,
        Diretor diretor,
        Administrativo administrativo,
        Veiculo veiculo,
        List<Proposta> propostas
) {
}
