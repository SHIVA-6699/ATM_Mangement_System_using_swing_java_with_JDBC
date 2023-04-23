import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.FileNameMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EventListener;
import javax.swing.border.TitledBorder;



class atm5 extends JFrame implements ActionListener
{
    JButton btn1,btn2,btn3;
    JLabel label1,label2,label3;
    JTextField text,text1;
    JFrame frame;
    String str;
    static  int Amount;
    Font f=new Font(Font.SANS_SERIF,Font.BOLD,39);
    atm5() {

        frame = new JFrame();
        label1 = new JLabel();
        label1.setText("Deposite Money");
        label1.setBounds(309, 29, 500, 59);
        label1.setFont(f);
//        label3
        label3=new JLabel();
        label3.setText("Enter Your UserPin");
        label3.setBounds(370,128,450,50);
        label3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        this.add(label3);
//label 2
    label2=new JLabel();
    label2.setText("Enter Your Amount");
    label2.setBounds(370,238,450,50);
    label2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
    this.add(label2);
        this.add(label1);


//        textfied
        text =new JTextField();
        text.setBounds(270,300,400,50);
        text.setFont(new Font(Font.MONOSPACED,Font.BOLD,22));
        text.setHorizontalAlignment(JTextField.CENTER);
        this.add(text);
//  textfied
        text1 =new JTextField();
        text1.setBounds(270,180,400,50);
        text1.setHorizontalAlignment(JTextField.CENTER);
        this.add(text1);
//        button1
        btn1=new JButton();
        btn1.setText("ENTER");
        btn1.setBounds(330,400,300,40);
        btn1.addActionListener(this);

//        button2
        btn2=new JButton();
        btn2.setText("Back=>");
        btn2.setBounds(400,500,130,50);
       this.add(btn2);
       btn2.setBackground(Color.black);
       btn2.setForeground(Color.white);
     btn2.addActionListener(this);

        this.add(btn1);
        this.setLayout(null);

        this.setBounds(0,0,999,699);
        this.setVisible(true);
    }




    public void actionPerformed(ActionEvent e)
    {
        int num,num1,num2;
        String str2;
    if(e.getSource()==btn1)
    {
    num2=Integer.parseInt(text1.getText());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java", "root", ""
            );

            Statement statement = connection.createStatement();




//            ResultSet resultSet = statement.executeQuery("select * from mysql");
//            while (resultSet.next()) {
//                java.lang.System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
//
//
//            }
            ResultSet resultSet = statement.executeQuery("select * from mysql2 where id=1");
            while(resultSet.next())
            {
                Amount=(resultSet.getInt(1));
            }

            str=text.getText();
            num=Integer.parseInt(str);
            num1=Amount+num;
            str2=Integer.toString(num1);
            statement.execute("update mysql2 set amount="+num1+" where id="+num2+";");

            connection.close();
        } catch (Exception es) {
            java.lang.System.out.println(es);
        }


//            database end

        JOptionPane.showMessageDialog(frame,"Money Deposited","Deposite",JOptionPane.INFORMATION_MESSAGE);
        text.setText("");
    }
    if(e.getSource()==btn2)
    {
        this.dispose();
        this.toBack();
        setVisible(false);
        new atm2().toFront();
    }
    }
    public static void main(String[] a)
    {
        atm5 demo=new atm5();

    }

}