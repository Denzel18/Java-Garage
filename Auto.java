package garage;

public class Auto {
	private int n_posti;
	private String marca;
	private String modello; 
	private int cilindrata; 
	private int lunghezza; 
	private int larghezza; 
	private int peso;  
	private boolean isGPL;
	private int prezzo;
	public Auto(int n_posti, String marca, String modello, int cilindrata, int lunghezza, int larghezza, int peso, boolean isGPL, int prezzo) {
		this.n_posti = n_posti;
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.peso = peso;
		this.isGPL = isGPL;
		this.prezzo = prezzo;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public boolean isGPL() {
		return isGPL;
	}
	public void setGPL(boolean isGPL) {
		this.isGPL = isGPL;
	}
	public int getN_posti() {
		return n_posti;
	}
	public void setN_posti(int n_posti) {
		this.n_posti = n_posti;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public int getCilindrata() {
		return cilindrata;
	}
	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
	public int getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}
	public int getLarghezza() {
		return larghezza;
	}
	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String toString() {
		return "Auto [getN_posti()=" + getN_posti() + ", getMarca()=" + getMarca() + ", getModello()=" + getModello()
				+ ", getCilindrata()=" + getCilindrata() + ", getLunghezza()=" + getLunghezza() + ", getLarghezza()="
				+ getLarghezza() + ", getPeso()=" + getPeso() + "]";
	}
}
