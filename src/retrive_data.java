import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;


public class retrive_data extends JFrame  implements  ActionListener
{
    JButton all=new JButton("All Records");
    JButton FYear=new JButton("First Year Recods");
    JButton Syear=new JButton("Second  Year Records");
    JButton Tyear=new JButton("Third Year Record");
    JButton closeButton=new JButton("EXIT");
    JButton homeButton=new JButton(" HOME ");
    Container container =getContentPane();
    Font font=new Font("Arial",Font.BOLD,23);

    First_year fy=new First_year();
    Second_year sy=new Second_year();
    Third_year ty=new Third_year();

    public retrive_data()
    {
        setLayout(null);
    
        setlay();
        setloc();
        addcomp();
        addaction();        
    }
    public void setlay()
    {
        container.setLayout(null);
    }
    public void setloc()
    {
        all.setBounds(200,113,300,50);
        FYear.setFont(font);

        FYear.setBounds(200,213,300,50);
        all.setFont(font);
        
        Syear.setBounds(200,313,300,50);
        Syear.setFont(font);

        Tyear.setBounds(200,413,300,50);
        Tyear.setFont(font);

        closeButton.setBounds(450,553,150,50);
        closeButton.setFont(font);    

        homeButton.setBounds(70,553,150,50);
        homeButton.setFont(font);
        
            

    }
    public void addcomp()
    {
        container.add(FYear);
        container.add(all);
        container.add(Syear);
        container.add(Tyear);
        container.add(closeButton);
        container.add(homeButton);
        
    }
    public void  addaction()
    {
        FYear.addActionListener(this);
        all.addActionListener(this);
        Tyear.addActionListener(this);
        Syear.addActionListener(this);
        closeButton.addActionListener(this);
        homeButton.addActionListener(this);
        
    }



    public void  actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==all)
        {
            All  a=new All();
            a.setBounds(890,200,500,400);
            a.setVisible(true);
            a.setTitle("All Student data");
            a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==FYear)
        {
           
            fy.setBounds(890,200,500,400);
            fy.setVisible(true);
            fy.setTitle("All Student data");
            fy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==Syear)
        {
            
            sy.setBounds(890,200,500,400);
            sy.setVisible(true);
            sy.setTitle("All Student data");
            sy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(ae.getSource()==Tyear)
        {
            
            ty.setBounds(890,200,500,400);
            ty.setVisible(true);
            ty.setTitle("All Student data");
            ty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        if(ae.getSource()==closeButton)
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
            ty.dispose();
            sy.dispose();
            fy.dispose();
            this.dispose();

        }
    }

    public static void main(String[] args) 
    {
        retrive_data rd=new  retrive_data();
        rd.setVisible(true);
        rd.setTitle("Retrive Data");
        rd.setResizable(false);
        rd.setBounds(200,200,700,700);
        rd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
    }
}

class All extends JFrame
{
    DefaultTableModel model=new DefaultTableModel();
    JTable table=new JTable(model);
    Container container=getContentPane();

    String roll,name,year,branch,acadmic_year,age,email;
    public All()
    {
        model.addColumn("ROll No.");
        model.addColumn("Name");
        model.addColumn("year");
        model.addColumn("Brance");
        model.addColumn("Acadmic year ");
        model.addColumn("Age");
        model.addColumn("E-Mail");


        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud_db","root","");
                Statement state=con.createStatement();
                String sql="select *from student ";
                ResultSet rs=state.executeQuery(sql);
                while(rs.next())
                {
                    roll=rs.getString(1);
                    name=rs.getString(2);
                    year=rs.getString(3);
                    branch=rs.getString(4);
                    acadmic_year=rs.getString(5);
                    age=rs.getString(6);
                    email=rs.getString(6);
                    model.addRow(new Object[]{roll,name,year,branch,acadmic_year,age,email});
                }
                JScrollPane jScrollPane=new JScrollPane(table);
                jScrollPane.setBounds(0,150,10,10);
                container.add(jScrollPane);
        }
        catch(Exception  e)
        {
            JOptionPane.showMessageDialog(this,e);            
        }

    }
}


class First_year extends JFrame
{
    DefaultTableModel model=new DefaultTableModel();
    JTable table=new JTable(model);
    Container container=getContentPane();

    String roll,name,year,branch,acadmic_year,age,email;
    public First_year()
    {
        model.addColumn("ROll No.");
        model.addColumn("Name");
        model.addColumn("year");
        model.addColumn("Brance");
        model.addColumn("Acadmic year ");
        model.addColumn("Age");
        model.addColumn("E-Mail");


        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud_db","root","");
                Statement state=con.createStatement();
                String searchString="3";
                String sql="select * from student  where  year="+searchString+";";
                ResultSet rs=state.executeQuery(sql);
                while(rs.next())
                {
                    roll=rs.getString(1);
                    name=rs.getString(2);
                    year=rs.getString(3);
                    branch=rs.getString(4);
                    acadmic_year=rs.getString(5);
                    age=rs.getString(6);
                    email=rs.getString(6);
                    model.addRow(new Object[]{roll,name,year,branch,acadmic_year,age,email});
                }
                JScrollPane jScrollPane=new JScrollPane(table);
                jScrollPane.setBounds(0,150,10,10);
                container.add(jScrollPane);
        }
        catch(Exception  e)
        {
            JOptionPane.showMessageDialog(this,e);            
        }

    }
}

class Second_year extends JFrame
{
    DefaultTableModel model=new DefaultTableModel();
    JTable table=new JTable(model);
    Container container=getContentPane();

    String roll,name,year,branch,acadmic_year,age,email;
    public Second_year()
    {
        model.addColumn("ROll No.");
        model.addColumn("Name");
        model.addColumn("year");
        model.addColumn("Brance");
        model.addColumn("Acadmic year ");
        model.addColumn("Age");
        model.addColumn("E-Mail");


        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud_db","root","");
                Statement state=con.createStatement();
                String searchString="2";
                String sql="select * from student  where  year="+searchString+";";
                ResultSet rs=state.executeQuery(sql);
                while(rs.next())
                {
                    roll=rs.getString(1);
                    name=rs.getString(2);
                    year=rs.getString(3);
                    branch=rs.getString(4);
                    acadmic_year=rs.getString(5);
                    age=rs.getString(6);
                    email=rs.getString(6);
                    model.addRow(new Object[]{roll,name,year,branch,acadmic_year,age,email});
                }
                JScrollPane jScrollPane=new JScrollPane(table);
                jScrollPane.setBounds(0,150,10,10);
                container.add(jScrollPane);
        }
        catch(Exception  e)
        {
            JOptionPane.showMessageDialog(this,e);            
        }

    }
}

class Third_year extends JFrame
{
    DefaultTableModel model=new DefaultTableModel();
    JTable table=new JTable(model);
    Container container=getContentPane();

    String roll,name,year,branch,acadmic_year,age,email;
    public Third_year()
    {
        model.addColumn("ROll No.");
        model.addColumn("Name");
        model.addColumn("year");
        model.addColumn("Brance");
        model.addColumn("Acadmic year ");
        model.addColumn("Age");
        model.addColumn("E-Mail");


        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stud_db","root","");
                Statement state=con.createStatement();
                String searchString="3";
                String sql="select * from student  where  year="+searchString+";";
                ResultSet rs=state.executeQuery(sql);
                while(rs.next())
                {
                    roll=rs.getString(1);
                    name=rs.getString(2);
                    year=rs.getString(3);
                    branch=rs.getString(4);
                    acadmic_year=rs.getString(5);
                    age=rs.getString(6);
                    email=rs.getString(6);
                    model.addRow(new Object[]{roll,name,year,branch,acadmic_year,age,email});
                }
                JScrollPane jScrollPane=new JScrollPane(table);
                jScrollPane.setBounds(0,150,10,10);
                container.add(jScrollPane);
        }
        catch(Exception  e)
        {
            JOptionPane.showMessageDialog(this,e);            
        }

    }
}



