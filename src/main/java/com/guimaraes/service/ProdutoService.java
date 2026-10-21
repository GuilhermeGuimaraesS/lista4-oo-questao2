package com.guimaraes.service;

import com.guimaraes.dao.ProdutoDAO;
import com.guimaraes.model.Produto;

import java.util.UUID;

public class ProdutoService {

    private final ProdutoDAO produtoDAO;

    public ProdutoService(ProdutoDAO produtoDAO){
        this.produtoDAO = produtoDAO;
    }

    public void cadastrarNoEstoque(Produto produto){
        Produto produto1 = produtoDAO.buscarPorNome(produto.getNome());

        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório!");
        }

        if (produto.getNome().equalsIgnoreCase(produto1.getNome())) {
            throw new IllegalArgumentException("Esse produto já está cadastrado no sistema!");
        }

        produtoDAO.registrar(produto);

    }

    public void editarInfosProduto(Produto produto){
        Produto produto1 = produtoDAO.buscarPorNome(produto.getNome());

        if (produto1.getNome() == null || produto1.getId() == null){
            throw new IllegalArgumentException("Este produto não está cadastrado!");
        }

        produtoDAO.atualizar(produto);
    }
}
