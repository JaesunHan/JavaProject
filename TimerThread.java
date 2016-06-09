import java.awt.*;
import javax.swing.*;

class TimerThreadDeSec extends Thread{
	public int dsec=0;
	
	TimerThreadSec secT = new TimerThreadSec();
	TimerThreadMin minT = new TimerThreadMin();

	public void run(){
		System.out.println("DeSec Thread");
		
		
					
	}
}

class TimerThreadSec extends Thread{
	TimerThreadDeSec dsecT = new TimerThreadDeSec();
	TimerThreadMin minT = new TimerThreadMin();

	public int sec =0;
	public void run(){

	}


}

class TimerThreadMin extends Thread{
	public int min = 0;
	public void run(){
		
	}

}

public class TimerThread{
	public static void main(String[] args){
		TimerThreadDeSec dsecT = new TimerThreadDeSec();
		TimerThreadSec secT = new TimerThreadSec();
		TimerThreadMin minT = new TimerThreadMin();
		
		System.out.println("Main");

		//dsecT.start();
		
	}
}