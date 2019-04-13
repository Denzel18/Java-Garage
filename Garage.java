package garage;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.io.IOException;
import  java.time.*;
import java.util.Scanner;


public class Garage {
	
	private Livello livelli [];	
	public Garage (int numeroLivelli) {
		livelli = new Livello [numeroLivelli];
	}
	public Garage () {
		livelli = new Livello[7];
	}
	public void creaLivelli() {
		for(int i = 0 ; i < livelli.length; i++) {
			livelli[i] = new Livello(i, 20, 20, 20);
			livelli[i].creaPosti();
		}
	}
	public void creaLivelli(int numeroPostiFree, int numeroPostiBig, int numeroPostiLusso) {
		for(int i = 0 ; i < livelli.length; i++) {
			livelli[i] = new Livello(i, numeroPostiFree, numeroPostiBig, numeroPostiLusso);
			livelli[i].creaPosti();
		}
	}
	public void creaLivello(int livello, int numeroPostiFree, int numeroPostiBig, int numeroPostiLusso) {
			livelli[livello] = new Livello(livello, numeroPostiFree, numeroPostiBig, numeroPostiLusso);
			livelli[livello].creaPosti();
	}
	
	public String contaPosti() {
		String s = ""; 
		for (int i = 0 ; i < livelli.length ; i++) {
			s+="Al livello "+i+ " ci sono \n";
			if(i==0) {
				s+="POSTI GPL : "+livelli[i].contaPostiGPL()+"\n";
			}
			s+="POSTI BIG : "+livelli[i].contaPostiBig()+"\n";
			s+="POSTI LUSSO : "+livelli[i].contaPostiLusso()+"\n";
			s+="POSTI NORMAL : "+livelli[i].contaPostiFree()+"\n";
		}
		return s; 
	}
	public String contaPosti(int livello) {
		String s=""; 
		s+="Al livello "+livello+ " ci sono \n";
		if(livello == 0)
			s+="POSTI GPL : "+livelli[livello].contaPostiGPL()+"\n";
		
		s+="POSTI BIG : "+livelli[livello].contaPostiBig()+"\n";
		s+="POSTI LUSSO : "+livelli[livello].contaPostiLusso()+"\n";
		s+="POSTI NORMAL : "+livelli[livello].contaPostiFree()+"\n";
		return s; 
	}
	public void rilasciaAbbonamento(Posto p) throws IOException{
		Scanner tastiera = new Scanner(System.in);
		System.out.println("Inserisci il numero di mesi : ");
		int mesi = tastiera.nextInt(); 
		System.out.println(" Numero mesi : "+mesi);
		System.out.println("Inserisci il costo mensile : ");
		double costoMensile = tastiera.nextDouble(); 
		System.out.println(" Costo Mensile : "+mesi);
		System.out.println("Costo : "+costoMensile(mesi,costoMensile));
		p.setAffitto(false);
	}
	
	public double costoMensile(int mesi, double costoMensile ) {
		double costo = 0;
		costo = costoMensile*mesi;
		return costo;
	}
	public void richiediAbbonamento(Auto a) throws AbbonamentoException {
		Posto posto= null;
		int valoreLusso = livelli[0].postiLusso[0].getValore();
		int larghezzaBig = livelli[0].postiBig[0].getLarghezza();
		int lunghezzaBig = livelli[0].postiBig[0].getLunghezza();
		if(isPossibilePrenotare()) {
			if(a.isGPL()) {
				System.out.println("AUTO GPL\n");
				posto = getPostoLibero(a);
			}else if((a.getLarghezza() >= larghezzaBig)||(a.getLunghezza() >= lunghezzaBig)) {
				System.out.println("AUTO GRANDE\n");
				posto = getPostoLibero(a);
			}else if(a.getPrezzo() >= valoreLusso) {
				System.out.println("AUTO LUSSO\n");
				posto = getPostoLibero(a);			
			}else {
				System.out.println("AUTO CLASSICA\n");
				posto = getPostoLibero(a);
			}
		}else {
			System.out.println("NON E' POSSIBILE PRENOTARSI POSTI INSUFFICIENTI \n");
		}
		try {
			System.out.println("POSTO TROVATO : "+posto.getCodice()+"\n");
			posto.setAffitto(true);
		}catch(NullPointerException e) {
			System.out.println("POSTO NON TROVATO\n");
		}
	}

	//verificare il funzionamento 
	public boolean isPossibilePrenotare() {
		boolean check = true;
		int posti_liberi = 0;
		for (int i = 0 ; i < livelli.length ; i++) {
			posti_liberi +=livelli[i].contaPostiGPL();
			posti_liberi +=livelli[i].contaPostiBig();
			posti_liberi +=livelli[i].contaPostiLusso();
			posti_liberi +=livelli[i].contaPostiFree();
		}
		int posti_totali = 0;
		for (int i = 0 ; i < livelli.length ; i++) {
			posti_totali += livelli[i].contaPostiGPL();
			posti_totali += livelli[i].contaPostiBig();
			posti_totali += livelli[i].contaPostiLusso();
			posti_totali += livelli[i].contaPostiFree();
		}
		int percentuale_posti_totali = (posti_totali*50)/100;
		int percentuale_posti_liberi = (posti_liberi*50)/100;
		
		if(percentuale_posti_liberi > percentuale_posti_totali)
			check = true;
		else
			check = false;
		
		return check;
		
	}
	public double costo(double time, Posto p) {
		double costo = 0;
		double prezzoHour = p.getParkingCost();
		costo = (time*prezzoHour);
		return costo;
		
	}
	public double costoPenale(double time, Posto p, double penale) {
		double costo = 0;
		double prezzoHour = p.getParkingCost();
		costo = (time*prezzoHour)+penale;
		return costo;
	}
	
	public double calcolaTempo(LocalTime tout , LocalTime tin) {
		double min = tout.until(tin, MINUTES);	
		return min;
	}
	
	
	public void esci(Posto p) {
		double tempo = calcolaTempo(p.ingresso,p.uscita)/60;
		System.out.println("\n ------------------------------\n");
		System.out.println("Tempo : "+tempo);
		System.out.println("Prezzo orario : "+p.getParkingCost());
		double costo = 0.0;
		if(tempo > 480) //480 min = 8 ore 
			costo = costoPenale(tempo,p,8.0);
		else
			costo = costo(tempo,p);
		System.out.println("Costo : "+costo);
		System.out.println("\n ------------------------------\n");
		p.setStato(false);
		p.azzeraTime();
		
	}
	public Posto entra(Auto a) {
		Posto posto = null; 
		posto = this.getPostoLibero(a);
		return posto;
	}

	
	private Posto getPostoLibero(Auto a) {
		int i = 0;
		int n_posti = 0;
		int valoreLusso = livelli[0].postiLusso[0].getValore();
		int larghezzaBig = livelli[0].postiBig[0].getLarghezza();
		int lunghezzaBig = livelli[0].postiBig[0].getLunghezza();
		if(a.isGPL()) {
			n_posti = this.livelli[0].contaPostiGPL();
			if(n_posti > 0) {
				while((this.livelli[0].postiFree[i].isStato() != false) && (livelli[0].postiFree[i].isAffitto()!= false) && (i < this.livelli[0].postiFree.length)) {
					i++;
				}
				livelli[0].postiFree[i].setStato(true);
				livelli[0].postiFree[i].setIngresso(LocalTime.now());
				return livelli[0].postiFree[i];
			}
		}else if((a.getLarghezza() >=larghezzaBig)||(a.getLunghezza() >= lunghezzaBig)) {
			int l = 0;
			while(this.livelli[l].contaPostiBig() == 0) {
				l++;
			}
			while((this.livelli[l].postiBig[i].isStato() != false)  && (livelli[l].postiFree[i].isAffitto()!= false)) {
				i++;
			}
			livelli[l].postiBig[i].setStato(true);
			livelli[0].postiBig[i].setIngresso(LocalTime.now());
			return livelli[l].postiBig[i];
		}else if(a.getPrezzo()>= valoreLusso) {
			int l = 0;
			while(this.livelli[l].contaPostiLusso() == 0) {
				l++;
			}
			while((this.livelli[l].postiLusso[i].isStato() != false)  && (livelli[l].postiLusso[i].isAffitto()!= false)) {
				i++;
			}
			livelli[l].postiLusso[i].setStato(true);
			livelli[0].postiLusso[i].setIngresso(LocalTime.now());
			return livelli[l].postiLusso[i];
		}else {
			int l = 0;
			while(this.livelli[l].contaPostiFree() == 0) {
				l++;
			}
			while((this.livelli[l].postiFree[i].isStato() != false)  && (livelli[l].postiFree[i].isAffitto()!= false)) {
				i++;
			}
			livelli[l].postiFree[i].setStato(true);
			livelli[0].postiFree[i].setIngresso(LocalTime.now());
			return livelli[l].postiFree[i];
		}
		return null;
	}
	public Livello[] getLivelli() {
		return livelli;
	}
	public void setLivelli(Livello[] livelli) {
		this.livelli = livelli;
	}
}