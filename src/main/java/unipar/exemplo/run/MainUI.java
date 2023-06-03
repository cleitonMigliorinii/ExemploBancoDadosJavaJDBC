package unipar.exemplo.run;

import unipar.exemplo.ui.TelaCadastroProduto;

import javax.swing.*;

public class MainUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createUI();
            }
        });
    }

    private static void createUI() {

        TelaCadastroProduto formProduto = new TelaCadastroProduto();

        JFrame frame = new JFrame();
        frame.setContentPane(formProduto.panelMain);
        frame.setTitle("CADASTRO PRODUTO");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


}
