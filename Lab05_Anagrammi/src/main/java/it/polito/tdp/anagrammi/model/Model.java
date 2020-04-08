package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	private List<String> soluzione ;
	private AnagrammaDAO anagrammaDao;
	
	public Model() {
		anagrammaDao=new AnagrammaDAO();
	}

	/**
	 * Genera tutti gli anagrammi della parola specificata in ingresso.
	 * @param parola parola da anagrammare
	 * @return elenco di tutti gli anagrammi della parola data
	 */
	public List<String> anagrammi(String parola) {
		this.soluzione = new ArrayList<>() ;
		
		parola=parola.toUpperCase() ;
		
		List<Character> disponibili = new ArrayList<>() ;
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i)) ;
		}
		
		// avvia la ricorsione
		cerca("", 0, disponibili) ; 
		
		return this.soluzione ;
	}
	
	/**
	 * Procedura ricorsiva per il calcolo dell'anagramma.
	 * 
	 * @param parziale parte iniziale dell'anagramma costruito finora
	 * @param livello livello della ricorsione, sempre uguale a parziale.length()
	 * @param disponibili insieme delle lettere non ancora utilizzate
	 */
	private void cerca( String parziale, int livello, List<Character> disponibili) {
		if(disponibili.size()==0) { // livello==parola.length()
			// caso terminale
			
			// if(parziale è nel dizionario)
			// if( parziale non è presente nella soluzione )
			this.soluzione.add(parziale) ;
		}
		
		// caso normale
		// provare ad aggiungere a 'parziale' tutti i caratteri presenti tra
		// i 'disponibili'
		for(Character ch: disponibili) {
			String tentativo = parziale + ch ;
			
//			if(nel dizionario esistono delle parole che iniziano con 'tentativo'?)
			
			List<Character> rimanenti = new ArrayList<>(disponibili) ;
			rimanenti.remove(ch) ;
			
			cerca( tentativo, livello+1, rimanenti) ;
		}
	}
	public boolean isCorrect(String anagramma) {
		return anagrammaDao.isCorrect(anagramma);
	}
}
