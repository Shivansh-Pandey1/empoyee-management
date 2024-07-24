/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empoy.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author shiva
 */
public class reply extends JFrame implements ActionListener{
    JLabel labelempId,lblempId,lbl1;
    JTextArea txt1;
    JButton rply,back;
    String empid;
    reply(String empId){
        
        lbl1=new JLabel("REPLY FORM");
        lbl1.setBounds(150,   20,250,30);
       lbl1.setFont(new Font("serif",Font.PLAIN,30));
        lbl1.setForeground(Color.red);
        add(lbl1);
        
       
        
          labelempId=new JLabel("EmpId");
         labelempId.setBounds(50,   100,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,25));
        add( labelempId);
        
        
         lblempId=new JLabel();
        lblempId.setBounds(200, 100,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,25));
        add( lblempId);
        
        
        
        
        txt1=new JTextArea();
        txt1.setBounds(200,170,150,60);
        add(txt1);
        
        
        
        rply= new JButton("REPLY");
        rply.setBounds(200,250,150,30);
        add(rply);
        rply.addActionListener(this);
        
        back= new JButton("BACK");
        back.setBounds(400,250,150,30);
        add(back);
        back.addActionListener(this);
        
        
        
         try{
            Conn c= new Conn();
            String query=" select * from request where empid='"+empId+"'";
            ResultSet rs=c.s.executeQuery(query);
            
             while(rs.next()){
                
                  lblempId.setText(rs.getString("empId"));
            }
         }
         catch(Exception e){
            e.printStackTrace();
         }
        
       
        
        
         setLayout(null);
        setSize(600,400);
        setLocation(300,60);
       
        setVisible(true);  
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==rply){
        try{
           String rp=txt1.getText();
           empid=lblempId.getText();
            
            if(rp.isEmpty()){
            JOptionPane.showMessageDialog(null,"PLEASE REPLY ");
            
            }else{
            
          Conn c=new Conn();
          String query="insert into  reply values('"+rp+"','"+empid+"')";
            JOptionPane.showMessageDialog(null,"REPLIED SUCCESFULLY");
          
            c.s.executeUpdate(query);
           
            } 
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        }else{
           new Home(); 
        }
    }
    public static void main(String [] args){
        new reply("");
        
    }
}
