package surveysystem;

import java.awt.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;


public class question extends JFrame{
	
	public JPanel contentPane;
	JLabel qno, one;
    JRadioButton op1, op2, op3, op4;
    ButtonGroup groupop;
    JButton next, submit;
    
    public static int count = 0;
    
	
	String questions[][] = new String[10][5];
	String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
	
	question(String name) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("Welcome to SURVEY "+ name);
		heading.setBounds(300, 30, 700, 45);
		heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
		add(heading);
		
		
		JLabel q = new JLabel("Questions");
		q.setBounds(8, 100, 120, 35);
		q.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		add(q);
		
		qno = new JLabel();
        qno.setBounds(20, 150, 100, 35);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 22));
        add(qno);
		
        one = new JLabel();
        one.setBounds(50, 150, 900, 35);
        one.setFont(new Font("Tahoma", Font.PLAIN, 22));
        add(one);
		
        questions[0][0] = "What is your age group?";
        questions[0][1] = "Below 18 years";
        questions[0][2] = "18-30 years";
        questions[0][3] = "31-40 years";
        questions[0][4] = "41+ years";

        questions[1][0] = "What is your profession?";
        questions[1][1] = "Student";
        questions[1][2] = "Business";
        questions[1][3] = "Job";
        questions[1][4] = "Others";

        questions[2][0] = "What is your annual income?";
        questions[2][1] = "< 2 Lakhs";
        questions[2][2] = "2 to 5 Lakhs";
        questions[2][3] = "5 to 10 lakhs";
        questions[2][4] = "> 10 Lakhs";

        questions[3][0] = "What is your Qualification level?";
        questions[3][1] = "Intermediate";
        questions[3][2] = "Bachelor's degree";
        questions[3][3] = "Master's degree";
        questions[3][4] = "Others";

        questions[4][0] = "Do you own a vehicle?";
        questions[4][1] = "Yes";
        questions[4][2] = "No";
        questions[4][3] = "No, but going to buy this year";
        questions[4][4] = "No, not going to buy";
        
        questions[5][0] = "What are your Hobbies?";
        questions[5][1] = "Physical fitness";
        questions[5][2] = "Music";
        questions[5][3] = "Reading";
        questions[5][4] = "Others";

        questions[6][0] = "Do you have any pets?";
        questions[6][1] = "0 pets";
        questions[6][2] = "1 pet";
        questions[6][3] = "2 pets";
        questions[6][4] = "More than 2 pets";

        questions[7][0] = "Are you married?";
        questions[7][1] = "Yes";
        questions[7][2] = "No";
        questions[7][3] = "Divorced";
        questions[7][4] = "Prefer not to say";

        questions[8][0] = "How many dependents do you have?";
        questions[8][1] = "None";
        questions[8][2] = "1-2";
        questions[8][3] = "More than 2";
        questions[8][4] = "Prefer not to say";
        
        questions[9][0] = "Last question, How would you rate this survey?";
        questions[9][1] = "Excellent";
        questions[9][2] = "Very Good";
        questions[9][3] = "Good";
        questions[9][4] = "Can be better";


		op1 = new JRadioButton("op 1");
		op1.setBounds(80, 190, 200, 35);
		op1.setBackground(Color.WHITE);
		op1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(op1);
		
		op2 = new JRadioButton("op 2");
		op2.setBounds(80, 220, 200, 35);
		op2.setBackground(Color.WHITE);
		op2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(op2);
		
		op3 = new JRadioButton("op 3");
		op3.setBounds(80, 250, 200, 35);
		op3.setBackground(Color.WHITE);
		op3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(op3);
		
		op4 = new JRadioButton("op 4");
		op4.setBounds(80, 280, 200, 35);
		op4.setBackground(Color.WHITE);
		op4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(op4);
		
		next = new JButton("Next");
        next.setBounds(400, 250, 150, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveResponse();
                repaint();
                op1.setEnabled(true);
                op2.setEnabled(true);
                op3.setEnabled(true);
                op4.setEnabled(true);
                
                
                if (count == 8) {
                    next.setEnabled(false);
                    submit.setEnabled(true);
                }
                
                count++;
                start(count);
            }

        
            });
        
        add(next);
        
		groupop = new ButtonGroup();
		groupop.add(op1);
		groupop.add(op2);
		groupop.add(op3);
		groupop.add(op4);
		
		submit = new JButton("Submit");
        submit.setBounds(400, 350, 150, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		saveResponse();
                    JOptionPane.showMessageDialog(null, "Survey completed. Thank you!");
                    dispose();
                }
        });
        submit.setEnabled(false);
        add(submit);

        start(count);
		
		setSize(800,500);
		setLocation(150,200);
		setVisible(true);
	}
	
	public void start(int count) {
	        qno.setText("" + (count + 1) + ". ");
	        one.setText(questions[count][0]);
	        op1.setText(questions[count][1]);
	        op1.setActionCommand(questions[count][1]);

	        op2.setText(questions[count][2]);
	        op2.setActionCommand(questions[count][2]);

	        op3.setText(questions[count][3]);
	        op3.setActionCommand(questions[count][3]);

	        op4.setText(questions[count][4]);
	        op4.setActionCommand(questions[count][4]);

	        groupop.clearSelection();
	        
	    }
	
	public static void main(String[] args) {
		new question("user");
	}
	
	private void saveResponse() {
		
        String selectedop = "";
        if (op1.isSelected()) {
            selectedop = "op 1: "+ questions[count][1];
        } else if (op2.isSelected()) {
            selectedop = "op 2: "+ questions[count][2];
        } else if (op3.isSelected()) {
            selectedop = "op 3: "+ questions[count][3];
        } else if (op4.isSelected()) {
        	selectedop = "op 4: "+ questions[count][3];
        } else {
        	selectedop = "null";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("survey_responses.txt", true))) {
            writer.write("Q"+count+": "+questions[count][0] + "\n");
            writer.write("Response: " + selectedop + "\n\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
