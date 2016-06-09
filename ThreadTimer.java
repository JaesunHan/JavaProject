import java.awt.*;
import javax.swing.*;

class TimerThreadDeSec extends Thread 
{
   JLabel timerLabel;
   TimerThreadSec T;
   
   public TimerThreadDeSec(JLabel timerLabel)
   {
      this.timerLabel = timerLabel;
   }
   
   public void run()
   {
      int n=0;

      while(true) 
      {
         timerLabel.setText(Integer.toString(n)); // 레이블에 카운트 값 출력   
         n++;

         if(n==10)
         {
            n=0;
           
         }

         try{
            Thread.sleep(100); // 1초동안 잠을 잔다.
         }
         catch(InterruptedException e)
         {
            return; // 예외가 발생하면 스레드 종료
         }
      }
   }
}

class TimerThreadSec extends Thread 
{
   JLabel timerLabel;
   TimerThreadMin T;
      
   public TimerThreadSec(JLabel timerLabel)
   {
      this.timerLabel = timerLabel;
   }
   
   public void run()
   {
      int n=0;
      timerLabel.setText(Integer.toString(n));

      n++;
      if(n==60)
      {
         n=0;
         
      }
   }
}

class TimerThreadMin extends Thread 
{
   JLabel timerLabel;
   
   public TimerThreadMin(JLabel timerLabel)
   {
      this.timerLabel = timerLabel;
   }
   
   public void run()
   {
      int n=0;
      
      timerLabel.setText(Integer.toString(n)); // 레이블에 카운트 값 출력   
   }
}



public class ThreadTimer extends JFrame
{
   public ThreadTimer()
   {

      setTitle("Thread를 상속받은 타이머 스레드 예제");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.setLayout(new FlowLayout());

      JLabel colon1 = new JLabel();
      JLabel colon2 = new JLabel();

      JLabel timerLabel1 = new JLabel();
      JLabel timerLabel2 = new JLabel();
      JLabel timerLabel3 = new JLabel();

      colon1.setFont(new Font("Gothic", Font.ITALIC, 80));
      colon1.setText(":");
      colon2.setFont(new Font("Gothic", Font.ITALIC, 80));
      colon2.setText(":");

      timerLabel1.setFont(new Font("Gothic", Font.ITALIC, 80));
      timerLabel2.setFont(new Font("Gothic", Font.ITALIC, 80));
      timerLabel3.setFont(new Font("Gothic", Font.ITALIC, 80));

      c.add(timerLabel1);
      c.add(colon1);
      c.add(timerLabel2);
      c.add(colon2);
      c.add(timerLabel3); 
   
      TimerThreadMin th1 = new TimerThreadMin(timerLabel1);
      TimerThreadSec th2 = new TimerThreadSec(timerLabel2);
      TimerThreadDeSec th3 = new TimerThreadDeSec(timerLabel3);
      
      setSize(250,150);
      setVisible(true);
      
      th1.start(); // 타이머 스레드의 실행을 시작하게 한다.
      th2.start(); // 타이머 스레드의 실행을 시작하게 한다.
      th3.start(); // 타이머 스레드의 실행을 시작하게 한다.
   }
   
   public static void main(String[] args)
   {
      new ThreadTimer();
   }
}