package br.com.locacar.api.cotacao_locatech.service;

import br.com.locacar.api.cotacao_locatech.controller.exception.ControllerNotFoundException;
import br.com.locacar.api.cotacao_locatech.dto.CotacaoDTO;
import br.com.locacar.api.cotacao_locatech.entities.Cotacao;
import br.com.locacar.api.cotacao_locatech.repository.CotacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CotacaoService {
    private final CotacaoRepository cotacaoRepository;

    @Autowired
    public CotacaoService(CotacaoRepository cotacaoRepository) {
        this.cotacaoRepository = cotacaoRepository;
    }

    public Page<CotacaoDTO> findAll(Pageable pageable) {
        Page<Cotacao> cotacoes = cotacaoRepository.findAll(pageable);
        return cotacoes.map(this::toDTO);
    }
    public CotacaoDTO findById(Long id) {
        Cotacao cotacao = cotacaoRepository.findById(id).
                orElseThrow(() -> new ControllerNotFoundException("Cotação não encontrada"));
        return toDTO(cotacao);
    }

    public CotacaoDTO save(CotacaoDTO cotacaoDTO) {
        Cotacao cotacao = toEntity(cotacaoDTO);
        cotacao = cotacaoRepository.save(cotacao);
        return toDTO(cotacao);
    }

    public CotacaoDTO update(Long id, CotacaoDTO cotacaoDTO) {
        try {
            Cotacao cotacao = cotacaoRepository.getReferenceById(id);
            cotacao.setNumero(cotacaoDTO.numero());
            cotacao.setDiretor(cotacaoDTO.diretor());
            cotacao.setAdministrativo(cotacaoDTO.administrativo());
            cotacao.setVeiculo(cotacaoDTO.veiculo());
            cotacao.setPropostas(cotacaoDTO.propostas());
            cotacaoRepository.save(cotacao);
            return toDTO(cotacao);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Cotação não encontrada");
        }
    }

    public void delete(Long id) {
        cotacaoRepository.deleteById(id);
        return;
    }

    private Cotacao toEntity(CotacaoDTO cotacaoDTO) {
        return new Cotacao(
                cotacaoDTO.numero(),
                cotacaoDTO.diretor(),
                cotacaoDTO.administrativo(),
                cotacaoDTO.veiculo(),
                cotacaoDTO.propostas()
        );
    }

    private CotacaoDTO toDTO(Cotacao cotacao) {
        return new CotacaoDTO(
                cotacao.getNumero(),
                cotacao.getDiretor(),
                cotacao.getAdministrativo(),
                cotacao.getVeiculo(),
                cotacao.getPropostas()
        );
    }
}
