package com.guimaraes.dao;

import com.guimaraes.config.ConnectionFactory;
import com.guimaraes.enums.CategoriaProduto;
import com.guimaraes.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProdutoDAOImpl implements ProdutoDAO {

    public Produto buscarPorId(UUID ID) {

        String sql = String.format("""
                SELECT 
                    id, nome, preco, quantidade_em_estoque, categoria_produto, registrado_em
                FROM produto
                WHERE id = '%s'
                """, ID
        );

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            try (
                    ResultSet resultSet = statement.executeQuery();
            ) {
                Produto produtoBuscado = new Produto();
                if (resultSet.next()) {
                    produtoBuscado.setId(resultSet.getObject("id", UUID.class));
                    produtoBuscado.setNome(resultSet.getString("nome"));
                    produtoBuscado.setPreco(resultSet.getDouble("preco"));
                    produtoBuscado.setQuantidadeEstoque(resultSet.getInt("quantidade_em_estoque"));
                    produtoBuscado.setCategoriaProduto(
                            CategoriaProduto.stringParaCategoria(resultSet.getString("categoria_produto"))
                    );
                    produtoBuscado.setRegistradoEm(resultSet.getObject("registrado_em", LocalDateTime.class));
                }

                return produtoBuscado;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Produto buscarPorNome(String nome) {

        String sql = String.format("""
                SELECT 
                    id, nome, preco, quantidade_em_estoque, categoria_produto, registrado_em
                FROM produto 
                WHERE nome = '%s'
                """, nome
        );

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            try (
                    ResultSet resultSet = statement.executeQuery();
            ) {
                Produto produtoBuscado = new Produto();
                if (resultSet.next()) {
                    produtoBuscado.setId(resultSet.getObject("id", UUID.class));
                    produtoBuscado.setNome(resultSet.getString("nome"));
                    produtoBuscado.setPreco(resultSet.getDouble("preco"));
                    produtoBuscado.setQuantidadeEstoque(resultSet.getInt("quantidade_em_estoque"));
                    produtoBuscado.setCategoriaProduto(
                            CategoriaProduto.stringParaCategoria(resultSet.getString("categoria_produto"))
                    );
                    produtoBuscado.setRegistradoEm(resultSet.getObject("registrado_em", LocalDateTime.class));
                }

                return produtoBuscado;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> verEstoque() {

        String sql = String.format("""
                SELECT 
                    id, nome, preco, quantidade_em_estoque, categoria_produto, registrado_em
                FROM produto
                """
        );
        List<Produto> produtosCadastrados = new ArrayList<>();

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            try (
                   ResultSet resultSet = statement.executeQuery();
            ){
                while (resultSet.next()){
                    Produto produtoBuscado = new Produto();
                    produtoBuscado.setId(resultSet.getObject("id", UUID.class));
                    produtoBuscado.setNome(resultSet.getString("nome"));
                    produtoBuscado.setPreco(resultSet.getDouble("preco"));
                    produtoBuscado.setQuantidadeEstoque(resultSet.getInt("quantidade_em_estoque"));
                    produtoBuscado.setCategoriaProduto(
                            CategoriaProduto.stringParaCategoria(resultSet.getString("categoria_produto"))
                    );
                    produtoBuscado.setRegistradoEm(resultSet.getObject("registrado_em", LocalDateTime.class));
                    produtosCadastrados.add(produtoBuscado);
                }

                return produtosCadastrados;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}