
import java.awt.Taskbar.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.*;
public class atm4 extends JFrame implements ActionListener
{
   
    JFrame frame4;
    JButton btn;
   static JLabel label1;
  public  static int am;


    atm4()
    {
     label1=new JLabel();
     btn=new JButton();
      frame4=new JFrame();
      label1.setText("Check Your Bank Balance="+am);
      label1.setBounds(30,10,300,100);
      this.add(label1);

//     button 1
        btn.setText("check Balance");
        btn.setBounds(39,139,49,30);
        this.add(btn);
        btn.addActionListener(this);









      this.setLayout(null);
      this.setBounds(0,0,600,700);
      this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String str;
        if (e.getSource() == btn) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java", "root", ""
                );
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from mysql2 where id=1;");
               while(resultSet.next())
               {
                   label1.setText(Integer.toString(resultSet.getInt(1)));
               }

                connection.close();

            } catch (Exception es) {
                System.out.println(es);
            }
        }
    }
    public static void main(String[] a)
    {
        atm4 demo=new atm4();
    }
}

