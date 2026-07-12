import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

 class  form extends JFrame implements ActionListener
 {
    Container cont= getContentPane();
    JLabel UserLabel=new JLabel("Username :");
    JLabel  PasswordLabel=new JLabel("Password :");
    JTextField userField=new JTextField();
    JPasswordField PasswordField=new JPasswordField();
    JButton LoginButton =new JButton("Login ");
    JButton CancelButton=new JButton("Cancel");
    JCheckBox  Show=new JCheckBox("Show password ");
    Font fon=new Font("Arial",Font.ITALIC,25);
    
    form()
    {
        setlayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }
    void setlayoutManager()
    {
        cont.setLayout(null);
    }
    void setLocationAndSize()
    {
        UserLabel.setBounds(180,100,150,70);
        userField.setBounds(400,120,150,40);

        PasswordLabel.setBounds(180,200,150,70);
        PasswordField.setBounds(400,220,150,40);

        LoginButton.setBounds(200,440,120,50);
        CancelButton.setBounds(400,440,120,50);

        Show.setBounds(300,330,180,40);
    }
    void addComponentsToContainer()
    {  
        cont.add(LoginButton);
        cont.add(CancelButton);
        cont.add(PasswordLabel);
        cont.add(PasswordField);
        cont.add(userField);
        cont.add(UserLabel);
        cont.add(Show);
        UserLabel.setFont(fon);
        //userField.setFont(fon);
        //PasswordField.setFont(fon);
        PasswordLabel.setFont(fon);
        LoginButton.setFont(fon);
        CancelButton.setFont(fon);
        Show.setFont(new Font("Arial",Font.PLAIN,18));
        LoginButton.setFont(new Font("Arial",Font.BOLD,23));
        CancelButton.setFont(new Font("Arial",Font.BOLD,23));
    }
    void addActionEvent()
    {
        LoginButton.addActionListener(this);
        CancelButton.addActionListener(this); 
        Show.addActionListener(this);
    }
    
    @Override   
    public void actionPerformed(ActionEvent f)
    {
        if(f.getSource()==LoginButton)
        {
            String password=PasswordField.getText();
            String username=userField.getText();
 try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbnew","root","");
	Statement stmt=con.createStatement();
	String sql="select * from login where id='" + username + "'";
	ResultSet rs=stmt.executeQuery(sql);
	int i=1;
	while(rs.next())
{
                 String userDB=rs.getString("id");
                    String passDB=rs.getString("pwd");
                    if (username.equals(userDB)  && password.equals(passDB))
                    {
                        i=10;
                    }
                }
                if(i!=1)
                {
                    Home h=new Home();
                    h.setTitle("HOMEPAGE");
                    h.setVisible(true);
                    h.setResizable(false);
                    h.setBounds(200,200,700,700);
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"Password or  Username Incorrect  ");
                    
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Can't connect with Database ");
                JOptionPane.showMessageDialog(null,e);
            }
        }
        if(f.getSource()==CancelButton)
        {
            
        }
        if(f.getSource()==Show)
        {
            if(Show.isSelected())
            {
                PasswordField.setEchoChar((char)0);
            }
            else
            {
                PasswordField.setEchoChar('*');
            }
        }
    }
 }

 public class login
 {
    public static void main(String []args)
    {
        
        form f=new form();
        f.setTitle("Java Form ");
        f.setVisible(true);
        f.setBounds(200,200,700,700);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
 }
 