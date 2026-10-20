package com.guimaraes.dao;

import com.guimaraes.model.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoDAO {

    Produto buscarPorId(UUID ID);
    Produto buscarPorNome(String nome);
    List<Produto> verEstoque();
}
