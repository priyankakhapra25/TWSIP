package com.voting;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import atm.demo.Signup;


public class voting extends JFrame implements ActionListener{

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6;
    JRadioButton r1,r2,r3;
    
     voting() {
    	 setTitle("Online Voting System");
	       
	        l1 = new JLabel("Online Voting System");
	        l1.setFont(new Font("System", Font.BOLD, 50));
	        l1.setForeground(Color.red);
	        
	        l2 = new JLabel("Name:");
	        l2.setFont(new Font("System", Font.BOLD, 30));
	        
	        l3= new JLabel("Phone:");
	        l3.setFont(new Font("System", Font.BOLD, 30));
	        
	        l4= new JLabel("Cast Your vote here:");
	        l4.setFont(new Font("System", Font.BOLD, 30));
	        
	        t1 = new JTextField();
	        t1.setFont(new Font("Raleway", Font.BOLD, 22));
	      
	        t2 = new JTextField();
	        t2.setFont(new Font("Raleway", Font.BOLD, 22));
	           
	        r1 = new JRadioButton("Party A");
	        r1.setFont(new Font("Raleway", Font.BOLD, 20));
	        r1.setBackground(Color.WHITE);
	        
	        r2 = new JRadioButton("Party B");
	        r2.setFont(new Font("Raleway", Font.BOLD, 20));
	        r2.setBackground(Color.WHITE);
	        
	        r3 = new JRadioButton("Party C");
	        r3.setFont(new Font("Raleway", Font.BOLD, 20));
	        r3.setBackground(Color.WHITE);
	        
	        b1= new JButton("Submit Vote");
	        b1.setFont(new Font("Raleway", Font.BOLD, 16));
	        b1.setBounds(300,460,150,40);
	        add(b1);
	        
	        b2= new JButton("Check Result");
	        b2.setFont(new Font("Raleway", Font.BOLD, 16));
	        b2.setBounds(500,460,150,40);
	        add(b2);
	        
	        l1.setBounds(520,50,800,60);
	        l2.setBounds(300,200,150,60);
	        t1.setBounds(420,200,200,60);
	        
	        l3.setBounds(900,200,120,60);
	        t2.setBounds(1020,200,200,60);;
	        	        
	        l4.setBounds(300,300,350,60);
	        r1.setBounds(650,300,100,60);
	        r2.setBounds(780,300,100,60);
	        r3.setBounds(900,300,100,60);
	        
	        add(l1);
	        add(l2);
	        add(l3);
	        add(l4);
	        
	        add(t1);
	        add(t2);
	        
	        add(r1);
	        add(r2);
	        add(r3);
	        
	        b1.addActionListener(this); 
	        b2.addActionListener(this); 

	        getContentPane().setBackground(Color.WHITE);
	        
	        setLayout(null);
	        setSize(1550,830);
	        setVisible(true);
    }
 	public void actionPerformed(ActionEvent e) {
	    
		try{        
		    
			 String f="";
		        String a = t1.getText();
		        String b =t2.getText();
		     
		        if(r1.isSelected()){ 
		            f = "A";
		        }else if(r2.isSelected()){ 
		            f = "B";
		        }else if(r3.isSelected()){ 
		            f = "C";
		        }
		        
		    if(e.getSource()==b1){
		      if(t1.getText().equals("")||t2.getText().equals("")){
		    	        JOptionPane.showMessageDialog(null, "Fill all the required fields");
		            }
		      else if (b.length()!=10) {
	                JOptionPane.showMessageDialog(null, "Enter correct no.");
			}
		      else{
		    	  Conn c1 = new Conn();
	                System.out.println("DONE");
	                String q1= "insert into vote values('"+a+"','"+b+"','"+f+"')";
	                c1.statement.executeUpdate(q1);
	                
	                JOptionPane.showMessageDialog(null, "Congrats! Party "+f+" Voted Successfully");
		            	
		                setVisible(false);
	                    new voting().setVisible(true);

		            }
		    }
		}           
		        catch(Exception ex){
		             ex.printStackTrace();
		        }
		 if(e.getSource()==b2){ 
	            
			 try {
				 
				 int p1=0, p2=0,p3=0;
				 Conn c1 = new Conn();
		            String q  = "select party from vote ";
		            
		            ResultSet rs = c1.statement.executeQuery(q);
		            while (rs.next()) {
		            	String hString= rs.getString(1);
		            	if (hString.equals("A")) {
							p1++;
							}
		            	
		            	System.out.println(hString);
		            	if (hString.equals("B")) {
		            		p2++;
		            	}
		            	
		            	if (hString.equals("C")) {
		            		p3++;
		            	}
		            	
					}
		            System.out.println(p1+"  "+p2+"  "+p3);

	            	String max = (p1 > p2) ? (p1 > p3 ? "Party A  leads" : "Party C leads") : (p2 > p3 ? "Party B leads" : "Party C leads");
				
	            	JOptionPane.showMessageDialog(null, "Party A is:"+ p1 +"\n"+ "Party B is:"+ p2 +"\n"+ "Party C is:"+ p3 +"\n \n"+"Congrats!  "+max);
	            	
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 
	        }
		
	}
	public static void main(String[] args) {
        new voting().setVisible(true);
        System.out.println("new");
	}
}