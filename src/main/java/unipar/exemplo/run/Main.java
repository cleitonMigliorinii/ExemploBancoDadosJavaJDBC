package unipar.exemplo.run;

import unipar.exemplo.entity.Produto;
import unipar.exemplo.repository.produto.RepositoryProduto;

public class Main {

    public static void main(String[] args) {

        RepositoryProduto repo = new RepositoryProduto();

        Produto energetico = new Produto();
        energetico.setCodigo(4);
        energetico.setNome("Energetico");
        energetico.setEan("78929292929");
        energetico.setPreco(5.78);

        repo.inserirProduto(energetico);

        repo.buscarProduto();

    }
}
