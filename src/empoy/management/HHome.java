







package empoy.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HHome extends JFrame implements ActionListener {
    JButton add,view,remove,update,back,viewreply;
    JTextField request;
    HHome(){
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/asp.png"));
       Image i2= i1.getImage().getScaledInstance(1120, 630,Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,1120,630);
       add(image);

        add=new JButton("ADD EMPLOYEE");
       add.setBounds(140,230,150,40);
       add.setBackground(Color.BLUE);
       add.setForeground(Color.WHITE);
       image.add(add);
       add.addActionListener(this);
       
        view=new JButton("VIEW EMPLOYEE");
       view.setBounds(140,330,150,40);
      view.setBackground(Color.BLUE);
       view.setForeground(Color.WHITE);
       image.add(view);
       view.addActionListener(this);
       
       
       


        back=new JButton("Logout");
       back.setBounds(880,540,150,40);
       image.add(back);
        back.setBackground(Color.BLUE);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       
       
       
       
         viewreply=new JButton("VIEW REPLY");
         viewreply.setBounds(140,520,150,40);
        viewreply.setBackground(Color.BLUE);
      viewreply.setForeground(Color.WHITE);
         image.add(viewreply);
         viewreply.addActionListener(this);
         
         update=new JButton("REQUEST ADMIN");
         update.setBounds(140,420,150,40);
         update.setBackground(Color.BLUE);
       update.setForeground(Color.WHITE);
         image.add(update);
         update.addActionListener(this);
         
         
         setLayout(null);
        setSize(1120,670);
        setLocation(250,100);
        setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new Aaddemploy();
        
            
        }else if(ae.getSource()==view){
            setVisible(false);
      new VViewEmployee();
        }else if(ae.getSource()==update){
            setVisible(false);
            request ik=new request();
            
        }else if(ae.getSource()==viewreply){
            setVisible(false);
            new viewreply();
        
    }else{
           setVisible(false);
           new main();
        }
    }
    public static void main(String []args){
        new HHome();
    }
}
