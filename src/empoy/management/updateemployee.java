
package empoy.management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class updateemployee extends JFrame implements ActionListener {
    
    
    
    JTextField tfname,tfFname,tfaddress,tfaadhar,tfemail,tfsalary,tfdcdob,tfdesignation,tfphone,tfeducation;
    JLabel lblempId;
    JButton add,Back;
    String empId;
    
    updateemployee(String empId){
        
        
        this.empId=empId;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel(" UPDATE EMPLOYEE DETAILS");
        heading.setBounds(320,30,500,50);
        add(heading);
        heading.setFont(new Font("san_serif",Font.BOLD,25));
        
        
        JLabel labelname=new JLabel("NAME");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,25));
        add(labelname);
        
         JLabel lblname = new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        
        JLabel labelFname=new JLabel("Father's Name");
        labelFname.setBounds(400,150,150,30);
        labelFname.setFont(new Font("serif",Font.PLAIN,25));
        add(labelFname);
        
         tfFname = new JTextField();
        tfFname.setBounds(600,150,150,30);
        add(tfFname);
        
        JLabel labeldob=new JLabel("D.O.B");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,25));
        add(labeldob);
        
        JLabel lbldob=new JLabel ();
       lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
         JLabel labelsalary=new JLabel(" Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,25));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        
        JLabel labeladdress=new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,25));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        
         JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,25));
        add(labelphone);
        
         tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,25));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel labeleducation=new JLabel("Education");
       labeleducation.setBounds(400,300,150,30);
       labeleducation.setFont(new Font("serif",Font.PLAIN,25));
        add( labeleducation);
      
        tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        
         JLabel labelaadhar=new JLabel("Aadhar");
       labelaadhar.setBounds(50,350,150,30);
      labelaadhar.setFont(new Font("serif",Font.PLAIN,25));
        add(labelaadhar);
        
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(200,350,150,30);
        add(lblaadhar);
        
         JLabel labeldesignation=new JLabel("Designation");
         labeldesignation.setBounds(400,350,150,30);
         labeldesignation.setFont(new Font("serif",Font.PLAIN,25));
          add( labeldesignation);
      
       tfdesignation = new JTextField();
        tfdesignation.setBounds(600,350,150,30);
        add(tfdesignation);
        
        
         JLabel labelempId=new JLabel("EmpId");
         labelempId.setBounds(50,   100,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,25));
        add( labelempId);
        lblempId=new JLabel();
        lblempId.setBounds(200, 100,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,25));
        add( lblempId);
        
        try{
            Conn c= new Conn();
            String query=" select * from emp where empId='"+empId+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tfFname.setText(rs.getString("Fname"));
                lbldob.setText(rs.getString("dob"));
                 tfsalary.setText(rs.getString("salary"));
                 tfaddress.setText(rs.getString("address"));
                 tfphone.setText(rs.getString("phone"));
                 tfemail.setText(rs.getString("email"));
                 tfeducation.setText(rs.getString("education"));
                 tfdesignation.setText(rs.getString("designation"));
                  lblaadhar.setText(rs.getString("aadhar"));
                  lblempId.setText(rs.getString("empId"));
            }
//            
        }catch(Exception e){
     
            e.printStackTrace();
        }
      
        
        add=new JButton("UPDATE EMPLOYEE");
       add.setBounds(200,550,180,40);
       add(add);
       add.addActionListener(this);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.white);
       
        Back=new JButton("BACK");
       Back.setBounds(500,550,150,40);
       add(Back);
       Back.addActionListener(this);
       Back.setBackground(Color.BLACK);
      Back.setForeground(Color.white);
         
      setLayout(null);
        setSize(900,700);
        setLocation(300,60);
       
        setVisible(true);  
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
           
            String Fname=tfFname.getText();
            
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
           String education=tfeducation.getText();
            
            String designation=tfdesignation.getText();
           
           
           try{
               Conn conn = new Conn();
              
              String query=" update   emp set fname='"+Fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empId='"+empId+"'";
              conn.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Details Successfully Updated");
              setVisible(false);
              new Home();
           }catch(Exception e){
               e.printStackTrace();
           }
        }
        else{
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String[] args){
        new updateemployee("");
        
    }
    
}
