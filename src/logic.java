import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class logic extends JPanel implements ActionListener , KeyListener {
private int bit1y = 120 , bit2y = 120;
private int ballx = 280 , bally = 150;
private int ballsx = 3 , ballsy = 3;
private Timer time;
private  int player1 = 0, player2 = 0;

public logic()
{
    addKeyListener(this);
    time = new Timer(10 , this);
    setFocusable(true);

}

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,600,400);
        g.setColor(Color.white);
        g.fillRect(0,bit1y,10 , 100);
        g.setColor(Color.white);
        g.fillRect(572,bit2y,10 , 100);
        //ball
        g.setColor(Color.white);
        g.fillRect(ballx,bally,15,15);

        //score\
        Font f = new Font("Arial" , Font.BOLD, 25);
        g.drawString(String.valueOf(player1) , 250 , 30);
        g.drawString(String.valueOf(player2) , 315 , 30);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        
        ballx+=ballsx;
        bally+=ballsy;
        if(bally <= 0){
            ballsy = -ballsy;
        }
        if(bally > 350 ){
            ballsy = -ballsy;
        }
        if(bally-50 <=bit2y && ballx>= 300 && ballsx>0){
            bit2y-=5;
        }
        if(bally-50 >=bit2y && ballx>= 300 && ballsx>0){
            bit2y+=5;
        }
        if(new Rectangle(ballx , bally , 14 , 14).intersects(new Rectangle(572,bit2y,10 , 100))){
            ballsx=-ballsx;
        }
        if(new Rectangle(ballx , bally , 14 , 14).intersects(new Rectangle(0,bit1y,10 , 100))){
            ballsx=-ballsx;
        }
        if (ballx   < -20){
            player2+=1;
            ballx = 280;
            bally = 150;
            bit1y = 120;
            bit2y = 120;
            time.stop();


        }
        if (ballx > 620){
            player1+=1;
            ballx = 280;
            bally = 150;
            bit1y = 120;
            bit2y = 120;
            
            time.stop();

        }
        if(player1 == 11){
            System.out.println("You won");
        }
        if(player2 == 11){
            System.out.println("You Lose");
        }



    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            bit1y+=5;
            if(bit1y>=260){
                bit1y=260;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            bit1y-=5;
            if(bit1y<=0){
                bit1y=0;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            time.start();
            
        }
    }
}
