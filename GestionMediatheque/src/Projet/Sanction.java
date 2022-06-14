package Projet;
import java.util.*;
public class Sanction {
private Date dateRetourne;
private Date dateprevu;
private float montant;
private Adherent adh;

public Sanction(Date dateRetourne, Date dateprevu, float montant, Adherent adh) {
	super();
	this.dateRetourne = dateRetourne;
	this.dateprevu = dateprevu;
	this.montant = montant;
	this.adh = adh;
}
public Date getDateRetourne() {
	return dateRetourne;
}
public void setDateRetourne(Date dateRetourne) {
	this.dateRetourne = dateRetourne;
}
public Date getDateprevu() {
	return dateprevu;
}
public void setDateprevu(Date dateprevu) {
	this.dateprevu = dateprevu;
}
public float getMontant() {
	return montant;
}
public void setMontant(float montant) {
	this.montant = montant;
}
public Adherent getAdh() {
	return adh;
}
public void setAdh(Adherent adh) {
	this.adh = adh;
}

}
