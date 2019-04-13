package garage;
public class PostoLusso extends Posto{

	private int valore;
	public PostoLusso(String id) {
		super(id);
		this.valore = 30000;
	}
	public PostoLusso(String codice, int valore) {
		super(codice);
		this.valore = valore;
	}
	public PostoLusso(String codice, int valore, double parkingCost ) {
		super(codice, parkingCost);
		this.valore = valore;
	}
	public int getValore() {
		return valore;
	}
	public void setValore(int valore) {
		this.valore = valore;
	}
	@Override
	public String toString() {
		return "PostoLusso [valore=" + valore + "]";
	}
}
