/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this lice* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empoy.management;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;//add click event

/**
 *
 * @author shiva
 */
public class main extends JFrame implements ActionListener {
JButton clickhere,click;
    main(){
       
//       
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
       Image i2= i1.getImage().getScaledInstance(700, 500,Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,120,200);
       add(image);
      
         clickhere= new JButton("ADMIN LOGIN");
        clickhere.setBounds(90,395,150,50);
        image.add(clickhere);
        clickhere.setBackground(Color.BLUE);
       clickhere.setForeground(Color.WHITE);
       
       
        //click event
        clickhere.addActionListener(this);
        
        
         click= new JButton("EMPLOYEE LOGIN");
        click.setBounds(390,395,150,50);
        click.setBackground(Color.BLUE);
       click.setForeground(Color.WHITE);
        image.add(click);
        //click event
        click.addActionListener(this);
        
        
          getContentPane().setBackground(Color.WHITE);
       setSize(700,500); 
       setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 50);
        }

    

    public static void main(String args[]){
            main s= new main();
            
    
        }
    public void actionPerformed(ActionEvent ae){//attach click event
        if(ae.getSource()==clickhere){
        setVisible(false);//current frame ko off karega
        new Login();  // object banaya to costructor call ho jaega jisme login ki frame hai
        }
        else{
            setVisible(false);
             new employeelogin();
        }
    }
}
