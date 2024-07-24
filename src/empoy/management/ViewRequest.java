/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empoy.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class ViewRequest extends JFrame implements ActionListener{
     JTable table;
    JButton back,search,reply;
    Choice employeeId;
    ViewRequest(){
         getContentPane().setBackground(Color.white);
        setLayout(null);
        
       
        JLabel lblsearch=new JLabel("search by empid");
        lblsearch.setBounds(40,20,150,20);
        add(lblsearch);
        
        employeeId =new Choice();
        employeeId.setBounds(180,20,150,20);
        add(employeeId);
         try{
            Conn c= new Conn();
            ResultSet rs=c.s.executeQuery("select * from request");
          
            while(rs.next()){
                employeeId.add(rs.getString("empId"));
            }
            
        }
        catch (Exception e){
        e.printStackTrace();
    }
        table=new JTable();
        
        try{
            Conn c= new Conn();
            ResultSet rs=c.s.executeQuery("select * from request");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }
        catch (Exception e){
        e.printStackTrace();
    }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        back=new JButton("back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
        

        
        search=new JButton("search");
        search.setBounds(150,70,80,20);
        search.addActionListener(this);
        add(search);
        
        
         reply=new JButton("Reply");
        reply.setBounds(450,70,80,20);
        reply.addActionListener(this);
        reply.addActionListener(this);
        add(reply);
        
        
        
        
        setSize(900,700);
        setLocation(300,60);
       
        setVisible(true); 
   
}
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== search){
        String  query="select * from request where empId ='"+employeeId.getSelectedItem()+"'";
        try{
           Conn c=new Conn(); 
           ResultSet rs=c.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
          e.printStackTrace();  
        }
                
                
                
                
                
                
    }
        else if(ae.getSource()==reply){
        setVisible(false);
        new reply(employeeId.getSelectedItem());
        
    }
          else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
       new ViewRequest ();
    }
    
}
    


