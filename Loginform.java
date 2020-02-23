package projectReg;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.net.PasswordAuthentication;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;

class Loginform {
    JLabel usenname = new JLabel("UserName");
    JLabel password=new JLabel("Password");
    JTextField Tuser = new JTextField();
    JPasswordField Tpass = new JPasswordField();
    JButton login = new JButton("Login");

    Loginform()
    {
        JFrame lf = new JFrame("login");
        lf.setBounds(120, 70, 600, 350);
        lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lf.setResizable(false);
        lf.setVisible(true);
        Container cl = lf.getContentPane();
        cl.setBackground(new Color(169,169,169));
        cl.setLayout(null);

        //adding label into a frame
        usenname.setBounds(30,40,100,40);
        cl.add(usenname);
        password.setBounds(30,100,100,40);
        cl.add(password);

        // adding a textfield in a frame
        Tuser.setBounds(100,46,100,25);
        cl.add(Tuser);
        Tpass.setBounds(100,107,100,25);
        cl.add(Tpass);

        // code for Button
        login.setBounds(30,150,70,20);
        cl.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == login)
                {
                    try
                    {
                        connect con =new connect();
                        PreparedStatement stmt = con.connection.prepareStatement("SELECT * FROM `student_info` WHERE `enroll`=? and `pass`=?");
                        stmt.setString(1,login.getText());
                        stmt.setString(2,password.getText());
                        ResultSet rs = stmt.executeQuery();
                        if(rs.next())
                        {
                            JOptionPane.showMessageDialog(null,"login");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"failed");
                        }
                    }
                    catch (Exception e2)
                    {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }


    public static class test
    {
        public static void main(String[] args)
        {
            new Loginform();
        }
    }
}