package com.guimaraes.service;

import com.guimaraes.dao.ProdutoDAO;
import com.guimaraes.model.Produto;

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
}
