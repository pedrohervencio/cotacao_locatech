package br.com.locacar.api.cotacao_locatech.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Veiculo {
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private Integer anoFabricacao;
    @Column
    private Integer anoModelo;
    @Column
    private String cor;

    public Veiculo() {}

    public Veiculo(String marca, String modelo, Integer anoFabricacao, Integer anoModelo, String cor) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(marca, veiculo.marca) && Objects.equals(modelo, veiculo.modelo) && Objects.equals(anoFabricacao, veiculo.anoFabricacao) && Objects.equals(anoModelo, veiculo.anoModelo) && Objects.equals(cor, veiculo.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, anoFabricacao, anoModelo, cor);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", anoModelo=" + anoModelo +
                ", cor='" + cor + '\'' +
                '}';
    }
}
