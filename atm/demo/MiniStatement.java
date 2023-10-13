package atm.demo;

	import java.awt.event.*;
	import javax.swing.*;
	import java.sql.*;

	public class MiniStatement extends JFrame implements ActionListener{
	 
	    JTable t1;
	    JButton b1;
	    String x[] = {"Deposited Amount","Withdrawl Amount","Balance"};
	    String y[][] = new String[20][5];
	    int i=0, j=0;
	    
	    MiniStatement(){
	        super("Mini Statement");
	        setSize(1200,650);
	        setLocation(200,100);
	     		 String pinn = JOptionPane.showInputDialog("Enter PIN");

	        
	        try{
	            Conn c1  = new Conn();
	            ResultSet rs = c1.statement.executeQuery("SELECT * FROM deposit where pin = '" + pinn + "'");
	           while(rs.next()){
	                y[i][j++]=rs.getString("deposit");
	                y[i][j++]=rs.getString("withdraw");
	                y[i][j++]=rs.getString("balance");
	                i++;
	                j=0;
	            }
	            t1 = new JTable(y,x);
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        
	        
	        b1 = new JButton("Print");
	        add(b1,"South");
	        JScrollPane sp = new JScrollPane(t1);
	        add(sp);
	        b1.addActionListener(this);
	    }
	    public void actionPerformed(ActionEvent ae){
	        try{
	            t1.print();
	        }catch(Exception e){}
	    }
	    
	    public static void main(String[] args){
	        new MiniStatement().setVisible(true);
	    }
	    
	}