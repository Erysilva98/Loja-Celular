package view;

import javax.swing.*;

import dao.FileUserDao;
import model.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserForm extends JFrame {
    private JTextField nameField;
    private JButton addButton;
    private JButton remButton;

    private FileUserDao userDao;

    public UserForm(FileUserDao userDao) {
        this.userDao = userDao;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("App Loja");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new GridLayout(2, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                User user = new User(name);
                userDao.save(user);
                JOptionPane.showMessageDialog(null, "Registro Adicionado com Sucesso!");
                nameField.setText("");
            }
        });
        
        add(nameLabel);
        add(nameField);
        add(addButton);
        
        setVisible(true);
    }
}
