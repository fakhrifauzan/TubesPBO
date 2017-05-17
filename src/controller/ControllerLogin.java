/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Aplikasi;
import view.*;

/**
 *
 * @author Fakhri Fauzan
 */
public class ControllerLogin implements ActionListener{

    Aplikasi model;
    LoginAdmin login;
    ViewDashboard dashboard;

    public ControllerLogin(Aplikasi model) throws SQLException{
        this.model = model;
        login = new LoginAdmin();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        login.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(login.getBtnLogin())){
            try {
                String username = login.getTxtUsername().getText();
                String password = login.getTxtPassword().getText();
                if (username.equals("admin") && password.equals("admin")) {
                    new Controller(model);
                    login.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username / Password Salah!");
                }
            } catch (SQLException ex) {
                login.showMessage(null, "Login Gagal!");
            }         
        }
        
        if (source.equals(login.getBtnReset())) {
            login.setTxtUsername("");
            login.setTxtPassword("");
        }
    }
    
}
