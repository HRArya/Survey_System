package surveysystem;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class login extends JFrame{
	
	private JPanel contentPane;
	
	JButton start;
	JTextField tfname;
	
	login(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("SURVEY");
		heading.setBounds(350, 30, 100, 45);
		heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		add(heading);
		
		JLabel name = new JLabel("Enter your name");
		name.setBounds(113, 144, 200, 46);
		name.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		add(name);
		
		tfname = new JTextField();
		tfname.setBounds(284, 161, 300, 20);
		contentPane.add(tfname);
		tfname.setColumns(10);
		
		start = new JButton("Start");
		start.setBounds(350, 250, 89, 23);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == start) {
					String name = tfname.getText();
					setVisible(false);

					try (BufferedWriter writer = new BufferedWriter(new FileWriter("survey_responses.txt", true))) {
						writer.write("User : --- "+name+"---\n\n");
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					new question(name);
				}
			}
		});
		contentPane.add(start);
		
		setSize(800,500);
		setLocation(150,200);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new login();
	}
	
}
