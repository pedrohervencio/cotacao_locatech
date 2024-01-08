package br.com.locacar.api.cotacao_locatech.controller;

import br.com.locacar.api.cotacao_locatech.dto.CotacaoDTO;
import br.com.locacar.api.cotacao_locatech.service.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/aquisicao/cotacao")
@RestController
public class CotacaoController {
    private final CotacaoService cotacaoService;

    @Autowired
    public CotacaoController(CotacaoService cotacaoService) {
        this.cotacaoService = cotacaoService;
    }

    @GetMapping
    public ResponseEntity<Page<CotacaoDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "numero")Pageable pageable) {
        Page<CotacaoDTO> cotacoesDTO = cotacaoService.findAll(pageable);
        return ResponseEntity.ok(cotacoesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CotacaoDTO> findById(@PathVariable Long id) {
        CotacaoDTO cotacaoDTO = cotacaoService.findById(id);
        return ResponseEntity.ok(cotacaoDTO);
    }


    /*
      Diretor solicita cotação de veiculo
     */
    @PostMapping
    public ResponseEntity<CotacaoDTO> save(@RequestBody CotacaoDTO cotacaoDTO) {
        CotacaoDTO savedCotacaoDTO = cotacaoService.save(cotacaoDTO);
        return new ResponseEntity<>(savedCotacaoDTO, HttpStatus.CREATED);
    }

    /*
      Administrativo elabora cotação com propostas e devolve ao Diretor
     */
    @PutMapping("/{id}")
    public ResponseEntity<CotacaoDTO> update(@PathVariable Long id, @RequestBody CotacaoDTO cotacaoDTO) {
        CotacaoDTO updatedCotacaoDTO = cotacaoService.update(id, cotacaoDTO);
        return ResponseEntity.ok(updatedCotacaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cotacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
