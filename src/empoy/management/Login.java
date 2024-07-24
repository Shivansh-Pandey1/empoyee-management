package empoy.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername;
    JPasswordField tfpassword;
     JButton login,back;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/aw.png"));
       Image i2= i1.getImage().getScaledInstance(1200, 700,Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,1120,630);
       add(image);
       
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 200, 100, 30);
        image.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 200, 150, 30);
        image.add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 270, 100, 30);
        image.add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 270, 150, 30);
        image.add(tfpassword);
        
        login = new JButton("LOGIN");
        login.setBounds(100, 350, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        image.add(login);
        
        
         back= new JButton("back");
        back.setBounds(270,350,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);
        
        
        
      
       
        
        setSize(900, 600);
        setLocation(450, 200);
        setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==login){
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
             Conn c = new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
//                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }else{
          setVisible(false);
          new main();
          
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}