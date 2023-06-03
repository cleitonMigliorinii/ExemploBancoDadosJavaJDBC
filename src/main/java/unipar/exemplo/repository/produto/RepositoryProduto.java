package unipar.exemplo.repository.produto;

import unipar.exemplo.connection.ConnectionGeneric;
import unipar.exemplo.entity.Produto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositoryProduto {

    public Integer inserirProduto(Produto produto){

        try {
            ConnectionGeneric connection = new ConnectionGeneric();
            connection.getConnection();

            String query = "INSERT INTO produtos (codigo, nome, ean, preco) " +
                    "VALUES ("
                    + produto.getCodigo() + ",'"
                    +produto.getNome()
                    +"','"+ produto.getEan()+ "',"
                    +  produto.getPreco() +")";
            System.out.println(query);

            Integer retorno = connection.statement.executeUpdate(query);

            connection.closeConnection();

            return retorno;


        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    public void alterarProduto(){}

    public void deletarProduto(){}

    public List<Produto> buscarProduto(){

        ConnectionGeneric connenction = new ConnectionGeneric();
        try {
            List<Produto> listaRetorno = new ArrayList<>();
            connenction.getConnection();
            String query = "SELECT * FROM produtos";

            ResultSet result = connenction.statement.executeQuery(query);

            while (result.next()){
                //Retorna dados do banco
                Integer codigo = result.getInt("codigo");
                String nome = result.getString("nome");
                String ean = result.getString("ean");
                Double preco = result.getDouble("preco");

                //Joga os dados em objeto produto
                Produto produtoBanco = new Produto();
                produtoBanco.setCodigo(codigo);
                produtoBanco.setNome(nome);
                produtoBanco.setEan(ean);
                produtoBanco.setPreco(preco);

                //Guarda o objeto na lista Retorno
                listaRetorno.add(produtoBanco);


                /*System.out.println("Cadastro produto");
                System.out.println("Código : " + codigo);
                System.out.println("Nome : " + nome);
                System.out.println("EAN :" + ean);
                System.out.println("Preço" + preco);*/
            }

            connenction.closeConnection();

            return  listaRetorno;

        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }



    }

}
