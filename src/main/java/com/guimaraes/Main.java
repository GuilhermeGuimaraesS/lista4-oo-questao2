package com.guimaraes;

import com.guimaraes.config.ConnectionFactory;
import com.guimaraes.dao.ProdutoDAO;
import com.guimaraes.dao.ProdutoDAOImpl;
import com.guimaraes.model.Produto;

import javax.crypto.spec.PSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class Main {
    static void main() {

        ProdutoDAO produtoDAO = new ProdutoDAOImpl();

        Produto produtoBuscado02 = produtoDAO.buscarPorNome("Detergente");
        IO.println(produtoBuscado02.toString());

        Produto produtoBuscado01 = produtoDAO.buscarPorId(UUID.fromString("7362f970-043f-4046-982b-37117d18aaeb"));
        IO.println(produtoBuscado01.toString());

        IO.println("----------------------------------------------------------");
        List<Produto> produtosCadastrados = produtoDAO.verEstoque();
        for (Produto produto : produtosCadastrados){
            IO.println(produto.toString());
        }

    }
}
