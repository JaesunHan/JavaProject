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
         timerLabel.setText(Integer.toString(n)); // ���̺� ī��Ʈ �� ���   
         n++;

         if(n==10)
         {
            n=0;
           
         }

         try{
            Thread.sleep(100); // 1�ʵ��� ���� �ܴ�.
         }
         catch(InterruptedException e)
         {
            return; // ���ܰ� �߻��ϸ� ������ ����
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
      
      timerLabel.setText(Integer.toString(n)); // ���̺� ī��Ʈ �� ���   
   }
}



public class ThreadTimer extends JFrame
{
   public ThreadTimer()
   {

      setTitle("Thread�� ��ӹ��� Ÿ�̸� ������ ����");
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
      
      th1.start(); // Ÿ�̸� �������� ������ �����ϰ� �Ѵ�.
      th2.start(); // Ÿ�̸� �������� ������ �����ϰ� �Ѵ�.
      th3.start(); // Ÿ�̸� �������� ������ �����ϰ� �Ѵ�.
   }
   
   public static void main(String[] args)
   {
      new ThreadTimer();
   }
}