import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Home extends JFrame implements ActionListener
{
    Font font=new Font("Arial",Font.BOLD,23);
    JButton insertButton=new JButton("INSERT DATA");
    JButton deleteButton=new JButton("DELETE DATA");
    JButton updateButton=new JButton("UPDATE DATA");
    JButton searchButton=new JButton("SEARCH DATA");
    JButton retriveButton=new JButton("RETRIVE DATA ");
    JButton exitButton=new JButton("EXIT");
    Container container =getContentPane();

    public Home()
    {
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
        insertButton.setBounds(200,60,300,50);
        insertButton.setFont(font);

        updateButton.setBounds(200,160,300,50);
        updateButton.setFont(font);
        
        searchButton.setBounds(200,260,300,50);
        searchButton.setFont(font);

        deleteButton.setBounds(200,360,300,50);
        deleteButton.setFont(font);

        retriveButton.setBounds(200,460,300,50);
        retriveButton.setFont(font);
        
        exitButton.setBounds(200,560,300,50);
        exitButton.setFont(font);
        

    }
    public void addcomp()
    {
        container.add(insertButton);
        container.add(updateButton);
        container.add(deleteButton);
        container.add(searchButton);
        container.add(retriveButton);
        container.add(exitButton);
    }
    public void  addaction()
    {
        insertButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);
        updateButton.addActionListener(this);
        retriveButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==insertButton)
        {

            Insert_data id=new Insert_data();
            id.setVisible(true);
            id.setTitle("Insert Data");
            id.setResizable(false);
            id.setBounds(200,200,700,700);
            id.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();

        }   
        if(ae.getSource()==updateButton)
        {
            Update_data ud=new Update_data();
            ud.setVisible(true);
            ud.setTitle("Update Data");
            ud.setResizable(false);
            ud.setBounds(200,200,700,700);
            ud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();

        }
        if(ae.getSource()==deleteButton)
        {
            Delete_data dd=new Delete_data();
            dd.setVisible(true);
            dd.setTitle("Delete Data");
            dd.setResizable(false);
            dd.setBounds(200,200,700,700);
            dd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        if(ae.getSource()==searchButton)
        {
            Search_data sd=new Search_data();
            sd.setVisible(true);
            sd.setTitle("Search Data");
            sd.setResizable(false);
            sd.setBounds(200,200,700,700);
            sd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        if(ae.getSource()==retriveButton)
        {
            retrive_data rd=new  retrive_data();
            rd.setVisible(true);
            rd.setTitle("Retrive Data");
            rd.setResizable(false);
            rd.setBounds(200,200,700,700);
            rd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        if(ae.getSource()==exitButton)
        {
            System.exit(1);
        }
        
        
    }
    public static void main(String[] args) {
        Home h=new Home();
        h.setTitle("HOMEPAGE");
        h.setVisible(true);
        h.setResizable(false);
        h.setBounds(200,200,700,700);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}