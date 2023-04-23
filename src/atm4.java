
import java.awt.*;
import java.awt.Taskbar.State;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Statement;


import javax.swing.*;
public class atm4 extends JFrame implements ActionListener
{
   
    JFrame frame4;
    JButton btn,but1;
    JTextField text,text1;
   static JLabel label1,label3;
  public  static int am;


    atm4()
    {
        label3=new JLabel();
        label3.setText("Enter Your UserPin");
        label3.setBounds(200,50,500,100);
        label3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        this.add(label3);
        text1 =new JTextField();
        text1.setBounds(160,160,300,50);
        text1.setHorizontalAlignment(JTextField.CENTER);
        this.add(text1);
        Font f=new Font(Font.MONOSPACED,Font.BOLD,30);
     label1=new JLabel();
     btn=new JButton();
     but1=new JButton();
     this.setTitle(".                                                         BALANCE CHECKING PAGE ");
      frame4=new JFrame();
      label1.setText("Check Your Bank Balance="+am);
      label1.setBounds(50,260,500,100);
      label1.setFont(f);
      this.add(label1);

//     button 1
        btn.setText("check Balance");
        btn.setBounds(229,420,139,50);
        this.add(btn);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.white);
        btn.addActionListener(this);


// button 2

but1.setText("<= Back");
but1.setBounds(229,550,130,50);
this.add(but1);
but1.addActionListener(this);




      this.setLayout(null);
      this.setBounds(0,0,600,700);
      this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
int num=Integer.parseInt(text1.getText());
        if (e.getSource() == btn) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java", "root", ""
                );
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from mysql2 where id="+num+";");
               if(resultSet.next())
               {
                   label1.setText((Integer.toString(resultSet.getInt(1)))+"₹ Your Balance");
                   label1.setBounds(99,260,599,50);
                   JOptionPane.showConfirmDialog(frame4,"Your Balance is correct","Confromation",JOptionPane.YES_NO_CANCEL_OPTION);


               }
               else {
               JOptionPane.showMessageDialog(frame4,"Wrong Pin Please Check","Confromation",JOptionPane.INFORMATION_MESSAGE);
               }

                connection.close();

            } catch (Exception es) {
                System.out.println(es);
            }
        }
        if(e.getSource()==but1)
        {
            this.dispose();
            setVisible(false);
            new atm2().toFront();
//            new atm2().setState(java.awt.Frame.NORMAL);
            this.dispose();
        }
    }
    public static void main(String[] a)
    {
        atm4 demo=new atm4();
    }
}

