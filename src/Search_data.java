import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Search_data extends JFrame implements ActionListener
{
    Container container =getContentPane();
    JButton exitButton=new JButton("EXIT");
    JButton homeButton=new JButton(" HOME ");
    JLabel searchLabel=new JLabel("Enter Roll NO. ");
    TextField searchField=new TextField();
    JButton searchButton=new JButton(" SEARCH ");
    JLabel rolLabel=new JLabel(" STUDENT ROLL NO : ");
    JLabel nameLabel=new JLabel(" STUDENT NAME : ");
    JLabel emailLabel= new JLabel(" STUDENT EMAIL ID : ");
    JLabel ageLabel= new JLabel(" STUDENT AGE : ");
    JLabel yearLabel=new JLabel(" CURRUNT YEAR ");
    JLabel acadmic_yearLabel=new JLabel(" CURRUNT  ACADMIC YEAR ");
    JLabel branchLabel=new JLabel("  BRANCH ");
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

    public Search_data()
    {
        container.setLayout(null);
        setlocandsize();
        addcomponents();
        actionperform();
    }
    public void setlocandsize()
    {
        rolLabel.setBounds(70,150,400,40);
        rolLabel.setFont(font);
        rollField.setBounds(380,150,150,40);
        nameLabel.setFont(font);;
        nameLabel.setBounds(70,200,270,40);
        nameField.setBounds(380,200,150,40);
        emailField.setBounds(380,250,150,40);
        emailLabel.setFont(font);
        emailLabel.setBounds(70,250,270,40);

        ageLabel.setBounds(70,300,270,40);
        ageLabel.setFont(font);
        ageField.setBounds(380,300,150,40);
        yearLabel.setBounds(70,350,359,40);
        yearBox.setBounds(380,350,150,40);
        
        yearLabel.setFont(font);
        branchLabel.setBounds(70,400,350,40);
        branchLabel.setFont(font);
        branchBox.setBounds(380,400,150,40);
        acadmic_yearLabel.setFont(new Font("Arial",Font.BOLD,15));
        acadmic_yearLabel.setBounds(70,450,350,40);
        acadmic_yearBox.setBounds(380,450,150,40);

        searchLabel.setBounds(70,70,150,40);
        searchLabel.setFont(font);
        searchField.setBounds(280,70,150,40);
        searchButton.setBounds(490,70,130,40);
        searchButton.setFont(font);
        homeButton.setBounds(100,555,150,50);
        homeButton.setFont(font);        
        exitButton.setBounds(400,555,150,50);
        exitButton.setFont(font);
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
        
        container.add(exitButton);
        container.add(homeButton);
        container.add(searchField);
        container.add(searchButton);
        container.add(yearBox);
        container.add(branchBox);
        container.add(acadmic_yearBox);
        container.add(searchLabel);
    }
    public void actionperform()
    {
        homeButton.addActionListener(this);
        exitButton.addActionListener(this);
        searchButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae)
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
        if(ae.getSource()==searchButton)
        {
            String searchString=searchField.getText();
            try 
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud_db","root","");
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from student  where  roll="+searchString+";");
                int not_found=1;
                while(rs.next())
                {
                    rollField.setText(rs.getString(1));
                    
                    nameField.setText(rs.getString(2));  

                    String year=rs.getString(3);
                    yearBox.setSelectedItem(year);

                    String branch=rs.getString(4);
                    branchBox.setSelectedItem(branch);

                    String acadmic_year=rs.getString(5);
                    acadmic_yearBox.setSelectedItem(acadmic_year);

                    ageField.setText(rs.getString(6));

                    emailField.setText(rs.getString(7));
                    
                    

                    not_found++;
                }
                if(not_found==1)
                {
                    JOptionPane.showMessageDialog(this,"Record not Found ");
                }
            } catch (Exception ex1) 
            {
                JOptionPane.showConfirmDialog(this,ex1);
            }

        }
    }
    public static void main(String[] args) 
    {
        Search_data sd=new Search_data();
        sd.setVisible(true);
        sd.setTitle("Search Data");
        sd.setResizable(false);
        sd.setBounds(200,200,700,700);
        sd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
