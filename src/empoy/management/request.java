/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empoy.management;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author shiva
 */
public class request extends JFrame implements ActionListener {
    JTextField empid;
   JTextArea rst;
   JScrollPane jsp;
   JButton rqt,back;
    
    request(){
         
        setLayout(null);
        
        
        JLabel heading=new JLabel("REQUEST FORM");
        heading.setBounds(150,30,500,50);
        add(heading);
        heading.setFont(new Font("san_serif",Font.BOLD,25));
        
          //label for empid 
        JLabel labelempId=new JLabel("EmpId");
         labelempId.setBounds(50,100,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,25));
        add( labelempId);
        
        
        
        //text field for empid 
         empid = new JTextField();
         empid.setBounds(150,100,150,30);
         add(empid);
         
         
         //label for request
         JLabel lblrq=new JLabel("Request");
          lblrq.setBounds(50,150,150,30);
         lblrq.setFont(new Font("serif",Font.PLAIN,25));
        add(  lblrq);
        
        
          //TextArea for request
         
         rst = new JTextArea();
         rst.setBounds(150,150,150,50);
         
         
         jsp = new JScrollPane(rst);
        jsp.setPreferredSize(new Dimension(5, 5));
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(jsp);
         add(rst);
         
         
          //adding JSCrollPAnee to TextArea for request
          
         
//        
        //button to send request 
         rqt=new JButton("Send Request");
       rqt.setBounds(150,260,150,40);
       add(rqt);
       rqt.addActionListener(this);
       
       
        //button to goback to employ home page
        
        back=new JButton("back");
       back.setBounds(350,260,150,40);
       add(back);
      back.addActionListener(this);
       
        
       
       //frame 
        setSize(600, 400);
        setLocation(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
         
          if(ae.getSource()==rqt){
              String Empid = empid.getText();
            String request = rst.getText();
            if(request.isEmpty() || Empid.isEmpty()){
                  JOptionPane.showMessageDialog(null,"FILL ALL FIELDS ");  
               }else{
         try {
            
            
            Conn c = new Conn();
            String query = "insert into  request values( '"+request+"','"+Empid+"')";
            c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Request Send Successfully ");
              setVisible(false);
              new HHome();
            
         }
         catch(Exception e){
               e.printStackTrace();
           }
        
         }
          }
          else{
                setVisible(false);   
                new HHome();
                 }
     }
     public static void main(String args[]){
          new request();
            
    
        }
}

