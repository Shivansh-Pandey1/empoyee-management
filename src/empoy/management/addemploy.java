
package empoy.management;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


public class addemploy extends JFrame implements ActionListener {
    
    Random ran=new Random();
    int number=ran.nextInt(999999);
    
    JTextField tfname,tfFname,tfaddress,tfaadhar,tfemail,tfsalary,tfdcdob,tfdesignation,tfphone,tfeducation;
    JLabel lblempId;
    JButton add,Back;
    
    
    addemploy(){
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
       Image i2= i1.getImage().getScaledInstance(1200, 700,Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,1120,630);
       add(image);
       
       
        JLabel heading=new JLabel("EMPLOYEE DETAILS");
        heading.setBounds(320,30,500,50);
        image.add(heading);
        heading.setFont(new Font("san_serif",Font.BOLD,25));
        
        
        JLabel labelempId=new JLabel("EmpId");
         labelempId.setBounds(50,100,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,25));
        image.add( labelempId);
        lblempId=new JLabel("" + number);
        lblempId.setBounds(200,100,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,25));
        image.add( lblempId);
        
        
        
        
        
        
        JLabel labelname=new JLabel("NAME");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,25));
        image.add(labelname);
        
         tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        image.add(tfname);
        
        
        JLabel labelFname=new JLabel("Father's Name");
        labelFname.setBounds(400,150,150,30);
        labelFname.setFont(new Font("serif",Font.PLAIN,25));
        image.add(labelFname);
        
         tfFname = new JTextField();
        tfFname.setBounds(600,150,150,30);
        image.add(tfFname);
        
        JLabel labeldob=new JLabel("D.O.B");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,25));
        image.add(labeldob);
        
        tfdcdob=new JTextField();
        tfdcdob.setBounds(200,200,150,30);
        image.add(tfdcdob);
        
         JLabel labelsalary=new JLabel(" Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,25));
        image.add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        image.add(tfsalary);
        
        
        JLabel labeladdress=new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,25));
        image.add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        image.add(tfaddress);
        
        
         JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,25));
        image.add(labelphone);
        
         tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        image.add(tfphone);
        
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,25));
        image.add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        image.add(tfemail);
        
        JLabel labeleducation=new JLabel("Education");
       labeleducation.setBounds(400,300,150,30);
       labeleducation.setFont(new Font("serif",Font.PLAIN,25));
        image.add( labeleducation);
      
        tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        image.add(tfeducation);
        
        
         JLabel labelaadhar=new JLabel("Aadhar");
       labelaadhar.setBounds(50,350,150,30);
      labelaadhar.setFont(new Font("serif",Font.PLAIN,25));
        image.add(labelaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,350,150,30);
        image.add(tfaadhar);
        
         JLabel labeldesignation=new JLabel("Designation");
         labeldesignation.setBounds(400,350,150,30);
         labeldesignation.setFont(new Font("serif",Font.PLAIN,25));
          image.add( labeldesignation);
      
       tfdesignation = new JTextField();
        tfdesignation.setBounds(600,350,150,30);
        image.add(tfdesignation);
        
        
         
      
        
        add=new JButton("ADD EMPLOY");
       add.setBounds(200,550,150,40);
       image.add(add);
       add.addActionListener(this);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.white);
       
        Back=new JButton("BACK");
       Back.setBounds(500,550,150,40);
       image.add(Back);
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
      String name,Fname,dob,salary,address,phone,email,education,aadhar,designation,empId;  
      
        if(ae.getSource()==add){
             name=tfname.getText();
             Fname=tfFname.getText();
             dob=tfdcdob.getText();
             salary=tfsalary.getText();
            address=tfaddress.getText();
             phone=tfphone.getText();
             email=tfemail.getText();
             education=tfeducation.getText();
             aadhar=tfaadhar.getText();
           designation=tfdesignation.getText();
           empId=lblempId.getText();
           
           
           
           
           try{
               if(name.isEmpty() || Fname.isEmpty() ||dob.isEmpty() || salary.isEmpty() || address.isEmpty()||phone.isEmpty() ||email.isEmpty()|| education.isEmpty()|| aadhar.isEmpty()|| designation.isEmpty()){
                  JOptionPane.showMessageDialog(null,"Give All Details ");  
               }else{
               Conn conn = new Conn();
              
              String query="insert into  emp values('"+name+"','"+Fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+aadhar+"','"+designation+"','"+empId+"')";
              conn.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Details added");
              setVisible(false);
              new Home();
               }
              
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
        new addemploy();
        
    }
    
}
