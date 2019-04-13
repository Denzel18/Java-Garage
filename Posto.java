package garage;
import java.time.*;
public abstract class Posto {
	protected String codice;	
	protected boolean stato; 
	protected LocalTime ingresso ; 
	protected LocalTime uscita ;
	protected double parkingCost;
	protected boolean affitto;
	protected boolean isForGPL;

	public Posto(String codice) {
		this.codice = codice; 
		this.stato = false;
		this.parkingCost = 2.0;
	}
	public Posto(String codice, boolean stato) {
		this.codice = codice;
		this.stato = stato; 
		this.parkingCost = 2.0;
	}
	public Posto(String codice, double parkingCost) {
		this.codice = codice; 	
		this.parkingCost = parkingCost;
	}
	
	public Posto(String codice, boolean stato, double parkingCost) {
		this.codice = codice;
		this.stato = stato; 	
		this.parkingCost = parkingCost;
	}
	
	public String getCodice() {
		return this.codice;
	}
	public void setCodice(String codice) {
		this.codice = codice; 
	}
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	public LocalTime getIngresso2() {
		return this.ingresso;
	}
	public String getIngresso() {
		String Singresso ="";
		Singresso += this.ingresso.getHour()+":"+this.ingresso.getMinute();
		return Singresso;
	}
	public void setIngresso(LocalTime ingresso) {
		this.ingresso = ingresso;
	}
	public double getParkingCost() {
		return parkingCost;
	}
	public void setParkingCost(double parkingCost) {
		this.parkingCost = parkingCost;
	}
	public boolean isAffitto() {
		return affitto;
	}
	public void changeAffitto() {
		this.setAffitto(!this.isAffitto());
	}
	public void setAffitto(boolean affitto) {
		this.affitto = affitto;
	}
	public boolean isForGPL() {
		return isForGPL;
	}
	public void setForGPL(boolean isForGPL) {
		this.isForGPL = isForGPL;
	}
	public String getUscita() {
		String Suscita ="";
		Suscita += this.uscita.getHour()+":"+this.uscita.getMinute();
		return Suscita;
	}
	public void setUscita(LocalTime uscita) {
		this.uscita = uscita;
	}
	public void azzeraTime() {
		this.uscita = null; 
		this.ingresso = null;
	}
	@Override
	public String toString() {
		return "Posto [codice=" + codice + ", stato=" + stato + ", ingresso=" + ingresso + ", uscita=" + uscita + "]";
	}
}
