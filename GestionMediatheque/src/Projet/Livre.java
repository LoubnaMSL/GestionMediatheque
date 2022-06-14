package Projet;
import java.util.*;

public class Livre{
	private String titre;
	private List<String> auteurs= new ArrayList();
	private String maisonEdit;
	private int nbrP;
	private float prix;
	public Livre(String titre, List<String> auteurs, String maisonEdit, int nbrP, float prix) {
	
		this.titre = titre;
		this.auteurs = auteurs;
		this.maisonEdit = maisonEdit;
		this.nbrP = nbrP;
		this.prix = prix;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public List<String> getAuteurs() {
		return auteurs;
	}
	public void setAuteurs(List<String> auteurs) {
		this.auteurs = auteurs;
	}
	public String getMaisonEdit() {
		return maisonEdit;
	}
	public void setMaisonEdit(String maisonEdit) {
		this.maisonEdit = maisonEdit;
	}
	public int getNbrP() {
		return nbrP;
	}
	public void setNbrP(int nbrP) {
		this.nbrP = nbrP;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
}
