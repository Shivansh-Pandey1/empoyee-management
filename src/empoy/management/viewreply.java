/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empoy.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author shiva
 */
public class viewreply extends JFrame implements ActionListener{
    
      JTable table;
    JButton back,search,reply;
    Choice employeeId;
    viewreply(){
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
            ResultSet rs=c.s.executeQuery("select * from reply");
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
        
        
//         reply=new JButton("Reply");
//        reply.setBounds(450,70,80,20);
//        reply.addActionListener(this);
//        reply.addActionListener(this);
//        add(reply);
        
        
        
        
         setSize(900, 600);
        setLocation(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    public static void main(String args[]){
        new viewreply();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== search){
        String  query="select * from Reply where empid  ='"+employeeId.getSelectedItem()+"'";
        try{
           Conn c=new Conn(); 
           ResultSet rs=c.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
          e.printStackTrace();  
        }
                
                
                
                
                
    }
     else{
            setVisible(false);
            new HHome();
                }
                   
    }
}
