import javax.swing.*;
import javax.swing.JFrame;
import  javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class atm7 extends JFrame implements ActionListener {
    JButton btn1,btn2,btn3;
    JTextField text,text1;
    JTextArea area;
    JLabel label1,label2;
    JFrame frame=new JFrame();
    atm7() {
        area=new JTextArea();
        area.setColumns(5);
        area.setBounds(2,34,43,44);
        this.add(area);

        this.setTitle("this is bill");
        this.setBounds(0,0,777,555);

        this.setLayout(null);
        this.setVisible(true);


    }


    public void actionPerformed(ActionEvent e)
    {

//        {
//            setLayout(new BorderLayout());
//
//            //file you want to play
//            URL mediaURL = Player mediaPlayer = Manager.createRealizedPlayer(mediaURL);
//            //get components for video and playback controls
//            Component video = mediaPlayer.getVisualComponent();
//            Component controls = mediaPlayer.getControlPanelComponent();
//            add(video,BorderLayout.CENTER);
//            add(controls,BorderLayout.SOUTH);
//        }

    }
    public static void main(String[] args)
    {
        atm7 demo=new atm7();
    }
}