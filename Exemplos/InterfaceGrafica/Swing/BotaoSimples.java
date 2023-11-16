//Exemplo de botão simples utilizando Swing

// Instruções para utilizar o Swing no IntelliJ:
// 1. não me lembro -_- (não precisa de configs)
package Exemplos.InterfaceGrafica.Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotaoSimples {
    public static void main(String[] args) {
        // Cria um novo JFrame
        JFrame frame = new JFrame("Exemplo");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cria um novo JButton
        JButton button = new JButton("Clique em mim");

        // Adiciona um ActionListener ao botão
            button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Este código será executado quando o botão for clicado
                System.out.println("Botão clicado!");
            }
        });

        // Adiciona o botão ao JFrame
            frame.getContentPane().add(button);

        // Torna o JFrame visível
            frame.setVisible(true);
    }
}
