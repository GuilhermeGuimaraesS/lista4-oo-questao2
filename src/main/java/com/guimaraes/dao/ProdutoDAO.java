package com.guimaraes.dao;

import com.guimaraes.model.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoDAO {

    void registrar(Produto produto);
    Produto buscarPorId(UUID ID);
    Produto buscarPorNome(String nome);
    List<Produto> verEstoque();
    void atualizar(Produto produto);
}
