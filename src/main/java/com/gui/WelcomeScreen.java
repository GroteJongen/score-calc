package com.gui;


import com.counter.CountingService;
import com.display.DisplayService;
import com.input.FormatterService;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen extends JFrame implements ActionListener {
  private JPanel jPanel = new JPanel();
  private JFrame jFrame = new JFrame();
  private JButton jButton = new JButton("Pa tera");
  private JLabel label = new JLabel();
  JTextField nameTextField = new JTextField();
  CountingService countingService = new CountingService();
  DisplayService displayService = new DisplayService(countingService);
  FormatterService formatterService = new FormatterService();

  public WelcomeScreen() {

    jButton.setBounds(15, 10, 10, 10);
    jButton.addActionListener(this);
    label.setText("My first ever gui!");
    Font font = new Font("Courier", Font.BOLD, 30);
    label.setFont(font);
    label.setBounds(40, 20, 100, 30);
    add(label);

    nameTextField.setBounds(80, 20, 100, 30);
    add(nameTextField);

    jFrame.setSize(500, 400);
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setTitle("My first ever gui");

    jPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    jPanel.setLayout(new GridLayout(0, 1));
    jPanel.add(label);
    jPanel.add(nameTextField);
    jPanel.add(jButton);
    jFrame.add(jPanel, BorderLayout.CENTER);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String name = nameTextField.getText();
    label.setText(displayService.printAllParametersOfText(formatterService.formatText(name)));
  }
}
