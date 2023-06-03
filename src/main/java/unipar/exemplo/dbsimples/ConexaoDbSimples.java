package unipar.exemplo.dbsimples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoDbSimples {

    public static void main(String[] args) {

        conectarBancoDeDados();

    }

    public static void conectarBancoDeDados(){

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "admin";

        try{
            //Iniciamos a criação da conexão com o banco
            Connection conn = DriverManager.getConnection(
                    url, username, password);

            //Cria a interface para conexão com o banco
            //Nela vamos executar o select, insert, update, delete
            Statement statement = conn.createStatement();

            Integer codigoWhere = 1;

            //Executar uma quety sql
            ResultSet result =
                    statement.executeQuery("SELECT * FROM produtos where codigo = " + codigoWhere);

            while (result.next()){
                Integer codigo = result.getInt("codigo");
                String nome = result.getString("nome");
                String ean = result.getString("ean");
                Double preco = result.getDouble("preco");

                System.out.println("Cadastro produto");
                System.out.println("Código : " + codigo);
                System.out.println("Nome : " + nome);
                System.out.println("EAN :" + ean);
                System.out.println("Preço" + preco);

            }

            conn.close();


        }catch (Exception e){
            //Vai exibir o log do exception
            e.printStackTrace();
            //System.out.println("DEU ERRO");
        }

    }



}
