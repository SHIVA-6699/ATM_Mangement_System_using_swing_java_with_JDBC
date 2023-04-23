import java.awt.Container;
import java.awt.Cursor;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

class atm extends JFrame implements ActionListener
{
    JFrame fame;
    JButton btn;
    JTextField text,label4;
    JLabel label3,label5;
   
    atm()
    {
        JLabel label2 = new JLabel();
        label5=new JLabel();
        label3=new JLabel();
        label4=new JTextField();
        Font f1=new Font(Font.SERIF, Font.PLAIN,  30);
      fame=new JFrame();
      text=new JTextField();
        Label label=new Label();
        btn =new JButton();
         fame.setTitle("ATM");   
        this.setLayout(null);
        this.setBounds(0,0,600,800);
        this.getContentPane().setBackground(Color.gray);
     
       label.setText("CENTURION ATM");
       label.setForeground(Color.WHITE);
      
       label.setFont(f1);
       label.setBounds(170,29,399,90);
       
      this.add(label);

    Container c = this.getContentPane();
    //   image
    // ImageIcon icon=new ImageIcon("math2.jpg");
    label2.setIcon(new ImageIcon("bank2.jpg"));
    
    label2.setBounds(100, 130,399,300);
        c.add(label2);
    btn.setText("SUBMIT");
    btn.setBounds(240,650,100,50);
    btn.setBackground(Color.BLUE);
  
    btn.setForeground(Color.white);
    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
 this.add(btn);

btn.addActionListener(this);
text.setBounds(180,600,200,30);
text.setBackground(Color.green);
text.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));
text.setHorizontalAlignment(JTextField.CENTER);
this.add(text);
text.addActionListener(this);

// label 2
        label3.setText("PLEASE INSERT YOUR CARD 👇");
        label3.setBounds(80,450,490,30);
        this.add(label3);
        label3.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        label3.setForeground(Color.WHITE);
// label4

        label4.setBounds(100,500,400,6);
        this.add(label4);
        label4.setBackground(Color.green);
        label4.setForeground(Color.green);

//label5
        label5.setText("ENTER YOUR PIN 👇");
        label5.setBounds(150,550,490,30);
        this.add(label5);
        label5.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        label5.setForeground(Color.WHITE);
      this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(text.getText());
        int b = 0;
        if (e.getSource() == btn) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java", "root", ""
                );
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select pass from cred where pass=" + a + " ;");
                if(resultSet.next()) {

                    this.dispose();


                    this.toBack();

                    atm2 newframe = new atm2();

                    newframe.setVisible(true);
                    newframe.toFront();


                }
             else {
                    JOptionPane.showMessageDialog(fame, "INCORRECT PIN", "crenditail page", JOptionPane.INFORMATION_MESSAGE);
                }
//            if(a==b)
//            {
//                JOptionPane.showConfirmDialog(fame,"Your Balance is correct","Confromation",JOptionPane.YES_NO_CANCEL_OPTION);
//            }

                connection.close();

            } catch (Exception es) {
                System.out.println(es);
            }


        }
    }
    public static void main(String[] args) {
        atm demo =new atm();
    }
}