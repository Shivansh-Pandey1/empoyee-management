
package empoy.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;



public class VViewEmployee extends JFrame implements ActionListener {
    JTable table;
    JButton back,update,search;
    Choice employeeId;
    VViewEmployee(){
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
            ResultSet rs=c.s.executeQuery("select * from emp");
          
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
            ResultSet rs=c.s.executeQuery("select * from emp");
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
        
        
//        update=new JButton("update");
//        update.setBounds(20,70,80,20);
//        update.addActionListener(this);
//        add(update);
        
        search=new JButton("search");
        search.setBounds(150,70,80,20);
        search.addActionListener(this);
        add(search);
        
        
        setSize(900,700);
        setLocation(300,60);
       
       
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== search){
        String  query="select * from emp where empId ='"+employeeId.getSelectedItem()+"'";
        try{
           Conn c=new Conn(); 
           ResultSet rs=c.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
//           System.out.println("hello");
        }catch(Exception e){
          e.printStackTrace();  
        }
                
                
                
                
                
        }          
//    }else if(ae.getSource()==update){
//            setVisible(false);
//        new updateemployee(employeeId.getSelectedItem());
//        
//    }
          else{
            setVisible(false);
            new HHome();
        }
    }
    public static void main(String[] args){
       new VViewEmployee ();
    }
    
}
