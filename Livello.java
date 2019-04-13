package garage;
//UUID --> identificare una classe
public class Livello {
	protected int n_livello; 
	protected PostoDimensioneNotevole postiBig[];
	protected PostoLusso postiLusso[];
	protected PostoNormale postiFree[];
	
	public Livello(int n_livello, int nPostiBig, int nPostiLusso, int nPostiFree) {
		this.n_livello = n_livello;
		this.postiBig = new PostoDimensioneNotevole[nPostiBig];
		this.postiLusso = new PostoLusso[nPostiLusso];
		this.postiFree = new PostoNormale[nPostiFree];
	}

	public void creaPosti() {
		String codice = ""; 
		for(int i = 0 ; i < postiBig.length; i++) {
			codice= this.n_livello+"-"+i;
			postiBig[i] = new PostoDimensioneNotevole(codice,7);
		}
		for(int i = 0 ; i < postiLusso.length; i++) {
			codice= this.n_livello+"-"+i;
			postiLusso[i] = new PostoLusso(codice,30000,9);
		}
		for(int i = 0 ; i < postiFree.length; i++) {
			codice= this.n_livello+"-"+i;
			postiFree[i] = new PostoNormale(codice,6.2);
		}
	}
	
	protected int getN_livello() {
		return n_livello;
	}

	protected void setN_livello(int n_livello) {
		this.n_livello = n_livello;
	}

	protected PostoDimensioneNotevole[] getpostiBig() {
		return postiBig;
	}

	protected void setpostiBig(PostoDimensioneNotevole[] postiBig) {
		this.postiBig = postiBig;
	}

	protected PostoLusso[] getpostiLusso() {
		return postiLusso;
	}

	protected void setpostiLusso(PostoLusso[] postiLusso) {
		this.postiLusso = postiLusso;
	}

	
	protected PostoNormale[] getpostiFree() {
		return postiFree;
	}

	protected void setpostiFree(PostoNormale[] postiFree) {
		this.postiFree = postiFree;
	}
	
	public int contaPostiFree() {
		int n = 0; 
		for(int i = 0; i < postiFree.length; i++) {
			if(postiFree[i].isStato() == false)
				n++;
		}
		return n; 
	}
	public int contaPostiBig() {
		int n = 0; 
		for(int i = 0; i < postiBig.length; i++) {
			if(postiBig[i].isStato() == false)
				n++;
		}
		return n; 
	}
	public int contaPostiLusso() {
		int n = 0; 
		for(int i = 0; i < postiLusso.length; i++) {
			if(postiLusso[i].isStato() == false)
				n++;
		}
		return n; 
	}
	public int contaPostiGPL() {
		int n = 0; 
		if(this.n_livello == 0) {
			for(int i = 0; i < postiFree.length; i++) {
				if(postiFree[i].isStato() == false)
					n++;
			}
		}else {
			n = 0;
		}
		return n; 
	}
	
	public void change(Posto a[], int n) {
		if(a[n].isStato() == false)
			a[n].setStato(true); 
		else
			a[n].setStato(false);
	}
	
	public void changeStato(Posto p) {
		//controllo del tempo
		p.setStato(!p.isStato());
	}
	public void changeStato(Posto p, boolean stato) {
		p.setStato(stato);
	}
	
	
}