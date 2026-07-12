import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Insert_data extends JFrame implements ActionListener
{
    Container container =getContentPane();
    JButton insertButton =new JButton(" INSERT ");
    JButton homeButton=new JButton(" HOME ");

    JButton exitButton =new JButton("EXIT");

    JLabel rolLabel=new JLabel("ENTER STUDENT ROLL NO : ");
    JLabel nameLabel=new JLabel("ENTER STUDENT NAME : ");
    JLabel emailLabel= new JLabel("ENTER STUDENT EMAIL ID : ");
    JLabel ageLabel= new JLabel("ENTER STUDENT AGE : ");
    JLabel yearLabel=new JLabel("SELECT CURRUNT YEAR ");
    JLabel acadmic_yearLabel=new JLabel("SELECT CURRUNT  ACADMIC YEAR ");
    JLabel branchLabel=new JLabel(" SELECT BRANCH ");
    Font font=new Font("Arial",Font.BOLD,19);
    JTextField ageField=new JTextField();
    String yb[]={"1st Year","2nd Year","3rd Year"};
    String bb[]={"CSE","ME","EE","CE","E And TC"};
    String ayb[]={"2022-23","2023-24",};
    JComboBox yearBox=new JComboBox<>(yb);
    JComboBox branchBox=new JComboBox<>(bb);
    JComboBox acadmic_yearBox=new JComboBox<>(ayb);
    JTextField rollField=new JTextField();
    JTextField nameField=new JTextField();
    JTextField emailField=new JTextField();

    public Insert_data()
    {
        container.setLayout(null);
        setlocandsize();
        addcomponents();
        actionperform();
    }
    public void setlocandsize()
    {
        rolLabel.setBounds(70,100,400,40);
        rolLabel.setFont(font);
        rollField.setBounds(380,100,150,40);
        nameLabel.setFont(font);;
        nameLabel.setBounds(70,150,270,40);
        nameField.setBounds(380,150,150,40);
        emailField.setBounds(380,200,150,40);
        emailLabel.setFont(font);
        emailLabel.setBounds(70,200,270,40);

        ageLabel.setBounds(70,250,270,40);
        ageLabel.setFont(font);
        ageField.setBounds(380,250,150,40);
        yearLabel.setBounds(70,300,359,40);
        yearBox.setBounds(380,300,150,40);
        
        yearLabel.setFont(font);
        branchLabel.setBounds(70,350,350,40);
        branchLabel.setFont(font);
        branchBox.setBounds(380,350,150,40);
        acadmic_yearLabel.setFont(new Font("Arial",Font.BOLD,15));
        acadmic_yearLabel.setBounds(70,400,350,40);
        acadmic_yearBox.setBounds(380,400,150,40);
        
        insertButton.setBounds(80,530,150,50);
        insertButton.setFont(font);
        exitButton.setBounds(450,530,150,50);
        exitButton.setFont(font);

        homeButton.setBounds(265,530,150,50);
        homeButton.setFont(font);       

    }
    public void addcomponents()
    {
        container.add(rollField);
        container.add(rolLabel);
        container.add(nameField);
        container.add(nameLabel);
        container.add(emailField);
        container.add(emailLabel);
        container.add(branchLabel);
        container.add(acadmic_yearLabel);
        container.add(ageLabel);
        container.add(yearLabel);
        container.add(ageField);
        container.add(insertButton);

        container.add(homeButton);
        container.add(yearBox);
        container.add(branchBox);
        container.add(acadmic_yearBox);
        container.add(exitButton);
    }
    public void actionperform()
    {
        homeButton.addActionListener(this);
        insertButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void  actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exitButton)
        {
            System.exit(1);
        }

        if(ae.getSource()==homeButton)
        {
            Home h=new Home();
            h.setTitle("HOMEPAGE");
            h.setVisible(true);
            h.setResizable(false);
            h.setBounds(200,200,700,700);
            this.dispose();
        }
        if(ae.getSource()==insertButton)
        {
            String r=rollField.getText();
            int roll=Integer.parseInt(r);
            System.out.println(roll);
            String n=nameField.getText();
            String e=emailField.getText();
            String a=ageField.getText();
            String y=yearBox.getSelectedItem().toString();
            String b=branchBox.getSelectedItem().toString();
            String ac=acadmic_yearBox.getSelectedItem().toString();

            
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud_db","root","");
                Statement stmt=con.createStatement();
                stmt.executeUpdate("insert into student values('"+r+"','"+n+"','"+y+"','"+b+"','"+ac+"','"+a+"','"+e+"');");
                JOptionPane.showMessageDialog(this,"Deatail Inserted  ");
                
                                
            }
             catch (Exception e1) 
            {
                JOptionPane.showMessageDialog(null,e1);
            }
        }
        
    }
    
    
    public static void main(String[] args) 
    {
        Insert_data id=new Insert_data();
        id.setVisible(true);
        id.setTitle("Insert Data");
        id.setResizable(false);
        id.setBounds(200,200,700,700);
        id.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
