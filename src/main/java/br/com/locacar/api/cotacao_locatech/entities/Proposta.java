package br.com.locacar.api.cotacao_locatech.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_proposta")
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fornecedor;
    private Integer preco;
    public Proposta() {}

    public Proposta(Long id, String fornecedor, Integer preco) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposta proposta = (Proposta) o;
        return Objects.equals(id, proposta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "id=" + id +
                ", fornecedor='" + fornecedor + '\'' +
                ", preco=" + preco +
                '}';
    }
}


