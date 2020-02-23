package projectReg;

import javax.swing.*;
import javax.swing.JPasswordField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.sql.*;

class RegistrationForm extends Component implements ActionListener
{
    JFrame fm;
    String[] Gender = {"Select","Male","Female"};
    String[] branch = {"Select Your Brance","COMPUTER","CIVIL","EC","MECHANICAL","ELECTRICAL"};
    String[] sem = {"Select Semester","1","2","3","4","5","6","7","8"};

    JLabel lenroll = new JLabel("Enrollment No.");
    JLabel lname = new JLabel("Full Name");
    JLabel lbranch = new JLabel("Branch");
    JLabel lsem = new JLabel("Semester");
    JLabel lgender = new JLabel("Gender");
    JLabel ldob = new JLabel ("Date of Birth");
    JLabel lcontact = new JLabel("Contect");
    JLabel laadhar = new JLabel("Aadhar number");
    JLabel lemail = new JLabel("Email ");
    JLabel lcity = new JLabel("City");
    JLabel lpass = new JLabel("Password");

    JTextField Tenroll = new JTextField();
    JTextField Tname = new JTextField();
    JComboBox Tbranch = new JComboBox(branch);
    JComboBox Tsem = new JComboBox(sem);
    JComboBox genderComboBox=new JComboBox(Gender);
    JTextField Tdob = new JTextField();
    JTextField Tcontact = new JTextField();
    JTextField Taadhar = new JTextField();
    JTextField Temail = new JTextField();
    JTextField Tcity = new JTextField();
    JPasswordField pass = new JPasswordField();

    JButton bregister = new JButton("REGISTER");
    JButton breset = new JButton("RESET");

    RegistrationForm()

    {
        creatWindow();
    }

    public void creatWindow()
    {
        fm = new JFrame("Registration Form");
        fm.setBounds(100,50,1000,800);
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm.setResizable(false);
        fm.setVisible(true);
        Container c =fm.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);


       // adding label into a frame
        lenroll.setBounds(20,20,100,40);
        c.add(lenroll);

        lname.setBounds(20,60,100,40);
        c.add(lname);

        lbranch.setBounds(20,100,100,40);
        c.add(lbranch);

        lsem.setBounds(20,140,100,40);
        c.add(lsem);

        lgender.setBounds(20,180,100,40);
        c.add(lgender);

        ldob.setBounds(20,220,100,40);
        c.add(ldob);

        lcontact.setBounds(20,260,100,40);
        c.add(lcontact);

        laadhar.setBounds(20,300,100,40);
        c.add(laadhar);

        lemail.setBounds(20,340,100,40);
        c.add(lemail);

        lcity.setBounds(20,380,100,40);
        c.add(lcity);

        lpass.setBounds(20,420,100,40);
        c.add(lpass);

       //adding textfields into a frame
        Tenroll.setBounds(180,20,220,25);
        c.add(Tenroll);

        Tname.setBounds(180,60,220,25);
        c.add(Tname);

        Tbranch.setBounds(180,100,220,25);
        c.add(Tbranch);

        Tsem.setBounds(180,140,220,25);
        c.add(Tsem);

       genderComboBox.setBounds(180,180,220,25);
       c.add(genderComboBox);

       Tdob.setBounds(180,220,220,25);
       c.add(Tdob);

       Tcontact.setBounds(180,260,220,25);
       c.add(Tcontact);

       Taadhar.setBounds(180,300,220,25);
       c.add(Taadhar);

       Temail.setBounds(180,340,220,25);
       c.add(Temail);

       Tcity.setBounds(180,380,220,25);
       c.add(Tcity);

       pass.setBounds(180,420,220,25);
       c.add(pass);

       //adding a Button
        bregister.setBounds(90,480,100,25);
        c.add(bregister);
        breset.setBounds(220,480,100,25);
        c.add(breset);

        bregister.addActionListener(this);
        breset.addActionListener(this);
    }
    /*
    public void actionEvent()
    {
        bregister.addActionListener(this);
        breset.addActionListener(this);
    } */
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == bregister)
        {
            try
            {

               /* Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:"+"mysql://localhost:3308/javaacc","root","root");*/
                connect con = new connect();
                PreparedStatement stmt = con.connection.prepareStatement("INSERT INTO `student_info` (`enroll`, `name`, `branch`, `sem`, `gender`, `dob`, `contect`, `aadhar`, `email`, `city`, `pass`) VALUES  (?,?,?,?,?,?,?,?,?,?,?)");
                stmt.setString(1,Tenroll.getText());
                stmt.setString(2,Tname.getText());
                stmt.setString(3,Tbranch.getSelectedItem().toString());
                stmt.setString(4,Tsem.getSelectedItem().toString());
                stmt.setString(5,genderComboBox.getSelectedItem().toString());
                stmt.setString(6,Tdob.getText());
                stmt.setString(7,Tcontact.getText());
                stmt.setString(8,Taadhar.getText());
                stmt.setString(9,Temail.getText());
                stmt.setString(10,Tcity.getText());
                stmt.setString(11,pass.getText());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(fm,"DATA INSERTED SUCESSFULLY...");
            }

            catch (Exception ex)
            {
                ex.printStackTrace();
            }


        }
    }
}

public class formtest
{
    public static void main(String []Args)

    {
        new RegistrationForm();
    }
}

