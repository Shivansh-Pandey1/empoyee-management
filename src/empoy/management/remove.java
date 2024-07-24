
package empoy.management;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class remove extends JFrame implements ActionListener{
   Choice empId;
   
   JButton back,delete;
    remove(){
        
        JLabel labelempId=new JLabel("EmpId");
        labelempId.setBounds(50,50,100,30);
        
        add( labelempId);
        
        empId =new Choice();
          empId.setBounds(200,50,150,30);
          add( empId);
          
          try{
              Conn c= new Conn();
              String query =" select * from emp";
              ResultSet rs=c.s.executeQuery(query);
              while(rs.next()){
                  empId.add(rs.getString("empId"));
              }
              
              
          }catch(Exception e){
              e.printStackTrace();
          }
          
//add yaha kr
            
        delete= new JButton("Delete");
        delete.setBounds(80,300,100,30);
        add(delete);
        delete.addActionListener(this);
        
         back= new JButton("Back");
        back.setBounds(250,300,100,30);
        add(back);
        back.addActionListener(this);
        
        
        
       
        
    
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(900,700);
        setLocation(300,60);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
        
    }
    public void actionPerformed(ActionEvent ae){//attach click event
        if(ae.getSource()==delete){
            try{
                Conn c= new Conn();
                String query="delete from emp where empId='"+empId.getSelectedItem()+"'";
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null,"Deleted Successfully ");
               
            }catch(Exception e){
                e.printStackTrace();
            }
            
    }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] agrs){
        new remove();
            
            
        
    }

//    @Override
//    public void itemStateChanged(ItemEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
}
