package atm.demo;

import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	
		    public class Deposit extends JFrame implements ActionListener{
		    
		    JTextField t1,t2;
		    JButton b1,b2,b3;
		    JLabel l1,l2,l3,l4;
		    
		    Deposit(){
		      
		        setTitle("DEPOSIT PAGE");
		       
		        l2 = new JLabel("Welcome!");
		        l2.setFont(new Font("System", Font.BOLD, 35));
		        l2.setForeground(Color.red);

		        l1 = new JLabel("Enter Details To Deposit");
		        l1.setFont(new Font("System", Font.BOLD, 30));
		        l1.setForeground(Color.red);

		        
		        l3 = new JLabel("Enter Pin:");
		        l3.setFont(new Font("System", Font.BOLD, 20));
		        
		        l4 = new JLabel("Enter Amount:");
		        l4.setFont(new Font("System", Font.BOLD, 20));

		        t2 = new JTextField();
		        t2.setFont(new Font("Raleway", Font.BOLD, 14));
		        
		        t1 = new JTextField();
		        t1.setFont(new Font("Raleway", Font.BOLD, 14));
		        
		        b1 = new JButton("DEPOSIT");
		        b1.setFont(new Font("System", Font.BOLD, 18));
		        b1.setBackground(Color.blue);
		        b1.setForeground(Color.WHITE);
		    
		        b2 = new JButton("BACK");
		        b2.setFont(new Font("System", Font.BOLD, 18));
		        b2.setBackground(Color.blue);
		        b2.setForeground(Color.WHITE);
		        
		        b3 = new JButton("EXIT");
		        b3.setFont(new Font("System", Font.BOLD, 18));
		        b3.setBackground(Color.blue);
		        b3.setForeground(Color.WHITE);
		       
		        setLayout(null);
		        
		        l3.setBounds(230,170,180,30);
		        add(l3);
		        
		        l4.setBounds(230,250,180,30);
		        add(l4);
		        
		        
		        l1.setBounds(210,80,800,60);
		        add(l1);
		        
		        l2.setBounds(290,10,800,60);
		        add(l2);

		        t2.setBounds(370,170,200,40);
		        
		        
		        
		        t1.setBounds(370,250,200,40);
		        add(t2);
		        add(t1);
		        
		        b1.setBounds(240,380,125,50);
		        add(b1);
		        
		        b2.setBounds(400,380,125,50);
		        add(b2);
		        
		        b3.setBounds(280,450,200,50);
		        add(b3);
		       
		        b1.addActionListener(this);
		        b2.addActionListener(this);
		        b3.addActionListener(this);
		        
		        getContentPane().setBackground(Color.WHITE);
		        
		        setSize(750,650);
		        setLocation(400,100);
		        setVisible(true);
		    }
		    
		    public void actionPerformed(ActionEvent ae){
		       
		        try{        
		           
		            String a = t1.getText();
		            int b =Integer.parseInt(t2.getText());
		            int x=1;
		            
		            if(ae.getSource()==b1){
		                if(t1.getText().equals(" ")){
		                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
		                
		                }else{
		                    Conn c1 = new Conn();
		                    String q1= "insert into deposit values('"+b+"','"+a+"','"+0+"','"+a+"')";
		                    c1.statement.executeUpdate(q1);
		                    JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited Successfully");
		                    
		                    new Transaction().setVisible(true);
		                    setVisible(false);
		                }
		            }
		                
		            else if(ae.getSource()==b2){
		                
		                new Transaction().setVisible(true);
		                setVisible(false);
		                
		            }
		            else if(ae.getSource()==b3){
		            	
		                System.exit(0);
		            }
		        }catch(Exception e){
		                e.printStackTrace();
		                System.out.println("error: "+e);
		        }
		    }
		    public static void main(String[] args){
		        new Deposit().setVisible(true);
		    }
		}
