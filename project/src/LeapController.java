import java.io.IOException;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Gesture.State;

class LeapListener extends Listener{
	
	public void onInit(Controller controller){
		System.out.println("Inicializou");
	}
	
	public void onConnect(Controller controller) {
	    System.out.println("Conectado");
	    controller.enableGesture(Gesture.Type.TYPE_SWIPE);
	    controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
	    controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
	    controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
	}
	
	public void onDisconnect(Controller controller){
		System.out.println("Desconectado");
	}
	
	public void onExit(Controller controller){
		System.out.println("Fechado");
	}
	
	public void onFrame(Controller controller) {
	    Frame frame = controller.frame();
	    
	    System.out.println("Frame Gesture:" + frame.gestures().count());
	}
		
}


public class LeapController {
	
	public static void main(String[] args) {

		LeapListener listener = new LeapListener();
		Controller controller = new Controller();	
		
		controller.addListener(listener);
		
		System.out.println("Pressione para Sair");		
		
		try{
			System.in.read();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}	
		
		controller.removeListener(listener);			
		
	}

}
