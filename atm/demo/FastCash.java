package atm.demo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{

    JLabel l1,l2, l3;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JTextField t1;
    
    FastCash(){
        
        setTitle("FAST CASH");

        l3 = new JLabel("Welcome!");
        l3.setFont(new Font("System", Font.BOLD, 40));
        l3.setForeground(Color.red);
        
        l1 = new JLabel("SELECT AMOUNT");
        l1.setFont(new Font("System", Font.BOLD, 35));
        l1.setForeground(Color.red);
        
        l2 = new JLabel("Enter PIN to Withdraw amount");
        l2.setFont(new Font("System", Font.BOLD, 14));
        
        t1 = new JTextField();
        t1.setFont(new Font("System", Font.BOLD, 13));    
       
        b1 = new JButton("Rs 100");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.blue);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("Rs 500");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.blue);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("Rs 1000");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.blue);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("Rs 2000");
        b4.setFont(new Font("System", Font.BOLD, 18));
        b4.setBackground(Color.blue);
        b4.setForeground(Color.WHITE);
        
        b5 = new JButton("Rs 5000");
        b5.setFont(new Font("System", Font.BOLD, 18));
        b5.setBackground(Color.blue);
        b5.setForeground(Color.WHITE);
        
        b6 = new JButton("Rs 10000");
        b6.setFont(new Font("System", Font.BOLD, 18));
        b6.setBackground(Color.blue);
        b6.setForeground(Color.WHITE);
        
        b7 = new JButton("BACK");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.blue);
        b7.setForeground(Color.WHITE);
        
        b7 = new JButton("EXIT");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.blue);
        b7.setForeground(Color.WHITE);
        
        
        setLayout(null);
        
        l2.setBounds(210,170,250,30);
        add(l2);
        
        l3.setBounds(290,10,800,60);
        add(l3);
        
        t1.setBounds(450,170,150,40);
        add(t1);
        
        l1.setBounds(240,100,700,40);
        add(l1);
        
        b1.setBounds(40,250,300,60);
        add(b1);
        
        b2.setBounds(440,250,300,60);
        add(b2);
        
        b3.setBounds(40,360,300,60);
        add(b3);
        
        b4.setBounds(440,360,300,60);
        add(b4);
        
        b5.setBounds(40,470,300,60);
        add(b5);
        
        b6.setBounds(440,470,300,60);
        add(b6);
        
        b7.setBounds(240,600,300,60);
        add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,800);
        setLocation(400,20);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
       
            try{        
           
            String a = t1.getText();
            double balance = 0;
            
            if(ae.getSource()==b1){
                
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.statement.executeQuery(" select * from deposit where pin = '"+a+"' ");
                    
                    
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        balance = rs.getDouble("balance");
                     
                        balance-=100;
                        String q1= "insert into deposit values('"+pin+"',null,100,'"+balance+"')";
                    
                        c1.statement.executeUpdate(q1);
                    }
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+100+" Debited Successfully");
                    
                    new Transaction().setVisible(true);
                    setVisible(false);
                    
                    
                    
            }
                
            
            else if(ae.getSource()==b2){
                
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.statement.executeQuery(" select * from deposit where pin = '"+a+"' ");
                    
                    
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        balance = rs.getDouble("balance");
                     
                        balance-=500;
                        String q1= "insert into deposit values('"+pin+"',null,500,'"+balance+"')";
                    
                        c1.statement.executeUpdate(q1);
                    }
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+500+" Debited Successfully");
                    
                    new Transaction().setVisible(true);
                    setVisible(false);
                    
                    
                    
                }
            else if(ae.getSource()==b3){
                
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.statement.executeQuery(" select * from deposit where pin = '"+a+"' ");
                    
                    
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        balance = rs.getDouble("balance");
                     
                        balance-=1000;
                        String q1= "insert into deposit values('"+pin+"',null,1000,'"+balance+"')";
                    
                        c1.statement.executeUpdate(q1);
                    }
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+1000+" Debited Successfully");
                    
                    new Transaction().setVisible(true);
                    setVisible(false);
                	}
            	  else if(ae.getSource()==b4){
                
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.statement.executeQuery(" select * from deposit where pin = '"+a+"' ");
                   if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        balance = rs.getDouble("balance");
                     
                        balance-=2000;
                        String q1= "insert into deposit values('"+pin+"',null,2000,'"+balance+"')";
                    
                        c1.statement.executeUpdate(q1);
                    }
                  JOptionPane.showMessageDialog(null, "Rs. "+2000+" Debited Successfully");
                    
                    new Transaction().setVisible(true);
                    setVisible(false);
                  
                }
            else if(ae.getSource()==b5){
                
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.statement.executeQuery(" select * from deposit where pin = '"+a+"' ");
                    
                    
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        balance = rs.getDouble("balance");
                     
                        balance-=5000;
                        String q1= "insert into deposit values('"+pin+"',null,5000,'"+balance+"')";
                    
                        c1.statement.executeUpdate(q1);
                    }
                  JOptionPane.showMessageDialog(null, "Rs. "+5000+" Debited Successfully");
                    
                    new Transaction().setVisible(true);
                    setVisible(false);
                  
                }
            else if(ae.getSource()==b6){
                
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.statement.executeQuery(" select * from deposit where pin = '"+a+"' ");
                    
                    
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        balance = rs.getDouble("balance");
                     
                        balance-=10000;
                        String q1= "insert into deposit values('"+pin+"',null,10000,'"+balance+"')";
                    
                        c1.statement.executeUpdate(q1);
                    }
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+10000+" Debited Successfully");
                    
                    new Transaction().setVisible(true);
                    setVisible(false);
                    
                }
                
            
            else if(ae.getSource()==b7){
                
                System.exit(0);
                
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    public static void main(String[] args){
        new FastCash().setVisible(true);
    }
}