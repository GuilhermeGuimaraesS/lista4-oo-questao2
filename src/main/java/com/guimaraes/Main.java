package com.guimaraes;

import com.guimaraes.config.ConnectionFactory;

import javax.crypto.spec.PSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    static void main() {


        // Teste de conexão com o banco
        /*try (Connection connection = ConnectionFactory.getInstance().getConnection()){
            IO.println("Conexão realizada com sucesso!");
        } catch (SQLException e){
            IO.println("Erro ao conectar ao banco!");
            e.printStackTrace();
        }*/
    }
}
