package atm.demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transaction extends JFrame implements ActionListener{

    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7;

    JPanel p1;

    Transaction(){
    
        setTitle("TRANSACTION");
        
        l2= new JLabel("WELCOME!");
        l2.setFont(new Font("System", Font.BOLD, 38));

        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setFont(new Font("System", Font.BOLD, 34));
    
       
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("CASH WITHDRAWL");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("FAST CASH");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("MINI STATEMENT");
        b4.setFont(new Font("System", Font.BOLD, 18));
        b4.setBackground(Color.BLUE);
        b4.setForeground(Color.WHITE);
        
       
        
        b6 = new JButton("BALANCE ENQUIRY");
        b6.setFont(new Font("System", Font.BOLD, 18));
        b6.setBackground(Color.BLUE);
        b6.setForeground(Color.WHITE);
        
        b7 = new JButton("EXIT");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.BLUE);
        b7.setForeground(Color.WHITE);
        
        
        setLayout(null);
        
        l2.setBounds(290,80,700,40);
        add(l2);

        l1.setBounds(150,150,700,40);
        add(l1);
        
        b1.setBounds(40,250,300,60);
        add(b1);
        
        b2.setBounds(440,250,300,60);
        add(b2);
        
        b3.setBounds(40,360,300,60);
        add(b3);
        
        b4.setBounds(440,360,300,60);
        add(b4);
        
        b6.setBounds(40,470,300,60);
        add(b6);
        
        b7.setBounds(440,470,300,60);
        add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
//        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(400,20);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){ 
            
            new Deposit().setVisible(true);
            setVisible(false);
            
        }
        else if(ae.getSource()==b2){ 
            
            new Withdrawl().setVisible(true);
            setVisible(false);
            
        }
        else if(ae.getSource()==b3){ 
            
            new FastCash().setVisible(true);
            setVisible(false);
            
        }else if(ae.getSource()==b4){ 
            
            new MiniStatement().setVisible(true);
            setVisible(false);
            
        }else if(ae.getSource()==b5){ 
            
//            new Pin().setVisible(true);
            setVisible(false);
            
        }else if(ae.getSource()==b6){ 
            
            String pinn = JOptionPane.showInputDialog("Enter PIN"); 
           Conn c1 = new Conn();
                    
            try {
                
                ResultSet rs = c1.statement.executeQuery(" SELECT balance FROM deposit ORDER BY pin  = '"+pinn+"' DESC LIMIT 1 ");
                
                if(rs.next()){
                
                String balance = rs.getString("balance");
                
                JOptionPane.showMessageDialog(null,"Your Account Balance is "+balance);
                
                }
            } catch (Exception e) {
             
                e.printStackTrace();
            
            }
        }
        else if(ae.getSource()==b7){ 
            
            System.exit(0);
            
        }
        
    }
    public static void main(String[] args){
        new Transaction().setVisible(true);

      
    }
}
    