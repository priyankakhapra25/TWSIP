package atm.demo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener {

	JTextField t1, t2;
	JButton b1, b2, b3;
	JLabel l1, l2, l3, l4;

	Withdrawl() {

		setTitle( "WITHDRAWL PAGE");
		
		 l4 = new JLabel("Welcome!");
	     l4.setFont(new Font("System", Font.BOLD, 40));
	     l4.setForeground(Color.red);
	       
		l1 = new JLabel("ENTER DETAILS TO WITHDRAW");
		l1.setFont(new Font("System", Font.BOLD, 35));
	    l1.setForeground(Color.red);

		l2 = new JLabel(" Enter Amount:");
		l2.setFont(new Font("System", Font.BOLD, 16));

		l3 = new JLabel("Enter PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        
		t1 = new JTextField();
		t1.setFont(new Font("Raleway", Font.BOLD, 16));

		t2 = new JTextField();
		t2.setFont(new Font("Raleway", Font.BOLD, 14));

		b1 = new JButton("WITHDRAW");
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
		
		l1.setBounds(150, 100, 800, 60);
		add(l1);
		

        l3.setBounds(210,220,150,30);
		add(l3);

		l2.setBounds(210,270,150,30);
		add(l2);
		
		l4.setBounds(290,30,800,60);
	    add(l4);	        


		t2.setBounds(350,220,150,40);
		add(t2);
		
		t1.setBounds(350, 270, 150, 40);
		add(t1);

		b1.setBounds(260, 380, 140, 50);
		add(b1);

		b2.setBounds(415, 380, 125, 50);
		add(b2);

		b3.setBounds(300, 450, 200, 50);
		add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);

		setSize(800, 800);
		setLocation(400, 20);
		setVisible(true);
	}

	public synchronized void actionPerformed(ActionEvent ae) {

		try {

			String a = t1.getText();
			String b = t2.getText();

			if (ae.getSource() == b1) {
				if (t1.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");

				} else {

					Conn c1 = new Conn();
					double balance = 0;

					ResultSet rs = c1.statement.executeQuery(" select * from deposit where pin = '" + b + "' ");

					if (rs.next()) {
						String pin = rs.getString("pin");

						balance = rs.getDouble("balance");

						JFrame f = new JFrame();

						double d = Double.parseDouble(a);
					
						if(balance > d) {
							
							balance -= d;
							String q1 = "insert into deposit values('" + pin + "','" + 0 + "','" + d + "','" + balance
									+ "')";

							c1.statement.executeUpdate(q1);
						}
						else {
							JOptionPane.showMessageDialog(f, "You don't have enough cash.", "Alert",
									JOptionPane.WARNING_MESSAGE);
							setVisible(false);
						}
					}

					JOptionPane.showMessageDialog(null, "Rs. " + a + " Withdrawn Successfully");

					new Transaction().setVisible(true);
					setVisible(false);

				}

			} else if (ae.getSource() == b2) {

				new Transaction().setVisible(true);
				setVisible(false);

			} else if (ae.getSource() == b3) {

				System.exit(0);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error: " + e);
		}

	}

	public static void main(String[] args) {
		new Withdrawl().setVisible(true);
	}

}
