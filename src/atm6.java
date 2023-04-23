import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class atm6 extends JFrame implements ActionListener
{
    static  int a,b;
    JFrame frame6=new JFrame();
    JButton btn1,btn2;
    JLabel label1,label2,label3,label4;
    JTextField text,text2,text3;
    Font f=new Font(Font.SANS_SERIF,Font.BOLD,39);
    atm6()
    {
//        label4=new JLabel();
//        label4.setText("Enter Your Name");
//        label4.setBounds(400,108,450,50);
//        label4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
//        this.add(label4);
//        text3 =new JTextField();
//        text3.setBounds(330,160,300,50);
//        text3.setHorizontalAlignment(JTextField.CENTER);
//        this.add(text3);

//     label1
        label1=new JLabel();
        label1.setText("PIN CHANGE");
        label1.setBounds(359, 29, 500, 59);
        label1.setFont(f);
        this.add(label1);
//        LABEL2
        label2=new JLabel();
        label2.setText("Enter Your Old Pin");
        label2.setFont(new Font(Font.MONOSPACED,Font.PLAIN,26));
        this.add(label2);
        label2.setBounds(340,240,500,50);
//        text field
        text=new JTextField();
        text.setBounds(359,300,260,50);
        text.setHorizontalAlignment(JTextField.CENTER);
        text.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
        this.add(text);
//        label3
        label3=new JLabel();
        label3.setText("Enter Your New Pin");
        label3.setFont(new Font(Font.MONOSPACED,Font.PLAIN,26));
        this.add(label3);
        label3.setBounds(340,360,500,50);
//        text filed
        text2=new JTextField();
        text2.setBounds(359,410,260,50);
        text2.setHorizontalAlignment(JTextField.CENTER);
        this.add(text2);
        text2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
//        button1
        btn1=new JButton();
        btn1.setText("Enter");
        btn1.setBounds(420,480,130,49);
        this.add(btn1);
        btn1.addActionListener(this);
//        button2 back
        btn2=new JButton();
        btn2.setText("<=Back");
        btn2.setBounds(390,560,190,50);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        this.add(btn2);
        btn2.addActionListener(this);
     this.setLayout(null);
     this.setBounds(0,0,999,699);
     this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
//        int num1=Integer.parseInt(text3.toString());
       if(btn1==e.getSource())
        {
            a=Integer.parseInt(text.getText());
            b=Integer.parseInt(text2.getText());
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java", "root", ""
                );
                Statement statement = connection.createStatement();

                int resultSet = statement.executeUpdate("update cred set pass = "+b+" where pass="+a+";");
                 {

                    JOptionPane.showMessageDialog(frame6, "Succsessfully updated", "crenditail page", JOptionPane.INFORMATION_MESSAGE);
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
        if(e.getSource()==btn2)
        {
            this.dispose();
            this.toBack();
            setVisible(false);
            new atm2().toFront();

        }
    }
    public static  void main(String[] a)
    {
        atm6 demo=new atm6();
    }
}