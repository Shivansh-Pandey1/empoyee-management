/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empoy.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JButton add,view,remove,update,back, viewRequest;
    Home(){
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.png"));
       Image i2= i1.getImage().getScaledInstance(1120, 630,Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,1120,630);
       add(image);

        
        add=new JButton("ADD EMPLOYEE");
       add.setBounds(130,150,170,40);
       image.add(add);
       add.addActionListener(this);
       
        view=new JButton("VIEW EMPLOYEE");
       view.setBounds(130,230,170,40);
       image.add(view);
       view.addActionListener(this);
       
       
       
       back=new JButton("Logout");
       back.setBounds(880,530,170,40);
       image.add(back);
       back.addActionListener(this);
       
       
       
       remove=new JButton("REMOVE EMPLOYEE");
       remove.setBounds(130,320,170,40);
       image.add(remove);
       remove.addActionListener(this);
       
       
         update=new JButton("UPDATE EMPLOYEE");
         update.setBounds(130,400,170,40);
         image.add(update);
         update.addActionListener(this);
         
         
         
          viewRequest=new JButton("VIEW REQUEST");
          viewRequest.setBounds(130,500,170,40);
         image.add( viewRequest);
          viewRequest.addActionListener(this);
         
         
         
         
         setLayout(null);
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new addemploy();
        }else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
        }else if(ae.getSource()==update){
          setVisible(false);
          new ViewEmployee();
            
        }else if(ae.getSource()==remove){
            setVisible(false);
            new remove();
        }
        else if(ae.getSource()== viewRequest){
            setVisible(false);
            new ViewRequest();
            
        }else{
           setVisible(false);
           new main();
        }
    }
    public static void main(String []args){
        new Home();
    }
}
