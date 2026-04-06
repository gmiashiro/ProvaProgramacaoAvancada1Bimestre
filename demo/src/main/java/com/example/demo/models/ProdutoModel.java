package com.example.demo.models;

import com.example.demo.enums.StatusProduto;
import jakarta.persistence.*;

@Entity
@Table(name = "tbProduto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private StatusProduto status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public StatusProduto getStatus() {
        return status;
    }

    public void setStatus(StatusProduto statusProduto) {
        this.status = statusProduto;
    }
}
