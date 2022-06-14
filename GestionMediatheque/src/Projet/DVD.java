package Projet;
import java.util.*;
public class DVD{
	private String nom;
	private String realisateur;
	private String producteur;
	private String editeur;
	private List <String> acteurs=new ArrayList<String>();
	public DVD(String nom, String realisateur, String producteur, String editeur, List<String> acteurs) {
		
		this.nom = nom;
		this.realisateur = realisateur;
		this.producteur = producteur;
		this.editeur = editeur;
		acteurs = acteurs;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public String getProducteur() {
		return producteur;
	}
	public void setProducteur(String producteur) {
		this.producteur = producteur;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public List<String> getActeurs() {
		return acteurs;
	}
	public void setActeurs(List<String> acteurs) {
		this.acteurs = acteurs;
	}
	
}
