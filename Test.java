package garage;
import java.time.LocalTime;


public class Test {

	public static void main(String[] args) {
		Garage archi = new Garage ();
		archi.creaLivelli(); 
		Auto a1 = new Auto(5, "FIAT","PANDA", 1000, 3800, 1500, 1600, false, 50000);
		System.out.println(a1.toString());
		//System.out.println(PostoLusso.toString());

		
		Posto p1 = archi.entra(a1);
		if(p1 != null) {
			System.out.println(p1.toString());
			System.out.println(p1.getIngresso());
		}
		p1.setIngresso(LocalTime.now());
		p1.setUscita(LocalTime.now().plusHours(1));
		
		System.out.println(archi.contaPosti());
		
		archi.esci(p1);
		System.out.println(archi.contaPosti());
		
		
	}

}