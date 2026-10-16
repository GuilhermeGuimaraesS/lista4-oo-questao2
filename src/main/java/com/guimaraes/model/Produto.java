package com.guimaraes.model;

import com.guimaraes.enums.CategoriaProduto;

import java.time.LocalDateTime;
import java.util.UUID;

public class Produto {
    private static UUID ID;
    private String nome;
    private Double preco;
    private Integer quantidadeEstoque;
    private CategoriaProduto categoriaProduto;
    private LocalDateTime registradoEm;

    public Produto(String nome, Double preco, Integer quantidadeEstoque,
                   String categoria
    ){
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoriaProduto = CategoriaProduto.stringParaCategoria(categoria);
    }

    public UUID getId() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    private void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    private void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    private void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public LocalDateTime getRegistradoEm() {
        return registradoEm;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "ID='" + ID + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", categoriaProduto=" + categoriaProduto +
                '}';
    }
}
