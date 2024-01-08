package br.com.locacar.api.cotacao_locatech.entities;

import br.com.locacar.api.cotacao_locatech.valueobject.Veiculo;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_cotacao")
public class Cotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    @ManyToOne
    @JoinColumn(name = "diretor_numero")
    Diretor diretor;
    @ManyToOne
    @JoinColumn(name = "administrativo_numero")
    Administrativo administrativo;
    Veiculo veiculo;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cotacao_numero")
    List<Proposta> propostas;

    public Cotacao() {}

    public Cotacao(Long numero, Diretor diretor, Administrativo administrativo, Veiculo veiculo, List<Proposta> propostas) {
        this.numero = numero;
        this.diretor = diretor;
        this.administrativo = administrativo;
        this.veiculo = veiculo;
        this.propostas = propostas;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Administrativo getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(Administrativo administrativo) {
        this.administrativo = administrativo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(List<Proposta> propostas) {
        this.propostas = propostas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cotacao cotacao = (Cotacao) o;
        return Objects.equals(numero, cotacao.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Cotacao{" +
                "numero=" + numero +
                ", diretor=" + diretor +
                ", administrativo=" + administrativo +
                ", veiculo=" + veiculo +
                ", propostas=" + propostas +
                '}';
    }
}
