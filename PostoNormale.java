package garage;

public class PostoNormale extends Posto{

	public PostoNormale (String codice) {
		super(codice);
	}
	public PostoNormale (String codice,double parkingCost ) {
		super(codice,parkingCost);
	}
	@Override
	public String toString() {
		return "PostoNormale [codice=" + codice + ", stato=" + stato + ", ingresso=" + ingresso + ", uscita=" + uscita
				+ ", parkingCost=" + parkingCost + ", affitto=" + affitto + ", isForGPL=" + isForGPL + "]";
	}
}
