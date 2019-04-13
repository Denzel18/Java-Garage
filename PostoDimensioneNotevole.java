package garage;
public class PostoDimensioneNotevole extends Posto{
	private int larghezza; 
	private int lunghezza;
	
	public PostoDimensioneNotevole (String codice,double parkingCost) {
		super(codice,parkingCost);
		this.setLarghezza(2000);
		this.setLunghezza(5000);
	}
	public PostoDimensioneNotevole (String codice, boolean disponibile, int larghezza , int lunghezza) {
		super(codice,disponibile);
		this.larghezza = larghezza; 
		this.lunghezza = lunghezza;
	}
	public PostoDimensioneNotevole (String codice, boolean disponibile, int larghezza , int lunghezza, double parkingCost) {
		super(codice,parkingCost);
		this.larghezza = larghezza; 
		this.lunghezza = lunghezza;
	}
	protected void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}
	protected int getLunghezza() {
		return this.lunghezza;
	}
	protected void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}
	protected int getLarghezza () {
		return this.larghezza;
	}
	@Override
	public String toString() {
		return "PostoDimensioneNotevole [larghezza=" + larghezza + ", lunghezza=" + lunghezza + "]";
	}
}
