package Books.gui;

import javax.swing.*;

import Books.agents.BookBuyerAgent;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BookBuyerGui extends JFrame {
    private BookBuyerAgent bookBuyerAgent;
    private JTextField titulo;
    private JTextArea resultado;

    public BookBuyerGui(BookBuyerAgent a) {
        super(a.getLocalName());
        bookBuyerAgent = a;
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel("Titulo del libro:"));
        titulo = new JTextField(15);
        p.add(titulo);
        p.add(new JLabel("Resultado:"));
        resultado = new JTextArea(6,45);
        p.add(resultado);
        getContentPane().add(p, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                bookBuyerAgent.doDelete();
            }
        });

        setResizable(false);
    }
    public void showGui() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int)screenSize.getWidth() / 2;
        int centerY = (int)screenSize.getHeight() / 2;

        setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
        super.setVisible(true);
    }
    public void setTitulo(String titulo){
        this.titulo.setText(titulo);
    }
    public void setResult(String texto){
        this.resultado.append(texto);
    }
}
