package com.murilonerdx.botoint.view;

import com.murilonerdx.botoint.model.Ponto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static com.murilonerdx.botoint.view.Util.writter;

public class PainelFrameInfo extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PainelFrameInfo frame = new PainelFrameInfo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public PainelFrameInfo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 340);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBackground(new Color(175, 238, 238));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Bater ponto");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel.setBackground(Color.ORANGE);
        lblNewLabel.setBounds(66, 16, 153, 40);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Categoria do ponto");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(10, 67, 300, 19);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(10, 85, 264, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Descrição do ponto");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 125, 300, 19);
        contentPane.add(lblNewLabel_2);

        textField2 = new JTextField();
        textField2.setBounds(10, 144, 264, 29);
        contentPane.add(textField2);

        JButton btnNewButton = new JButton("Bater Ponto");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(240, 248, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("Batendo ponto:");
                    boolean validated = baterPonto();
                    if(!validated){
                        JOptionPane.showMessageDialog(null,"Não foi possivel lançar o ponto, verifique seu login no arquivo system.config");
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null,"Ponto lançado com sucesso");
                        Thread.sleep(1600);
                        setVisible(false);
                    }

                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(36, 199, 200, 23);
        contentPane.add(btnNewButton);
        setVisible(false);
    }

    private boolean baterPonto() throws IOException {
        boolean isActive = MainPageTest.baterPonto();
        if(isActive){
            String categoriaDoPonto = textField.getText();
            String descricaoPonto = textField2.getText();
            Ponto ponto = new Ponto(categoriaDoPonto, Util.getTimeNow(), descricaoPonto);
            writter(ponto);
        }
        return isActive;
    }

}
