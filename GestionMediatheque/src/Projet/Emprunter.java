package Projet;

import java.util.Date;

public class Emprunter {
	private Date dateEmpr;
	private Date dateRtn;
	private int nbrEmprntLivre;
	private int nbrEmprCDVD;
	
	public Emprunter(Date dateEmpr, Date dateRtn, int nbrEmprntLivre, int nbrEmprCDVD) {
		super();
		this.dateEmpr = dateEmpr;
		this.dateRtn = dateRtn;
		this.nbrEmprntLivre = nbrEmprntLivre;
		this.nbrEmprCDVD = nbrEmprCDVD;
	}
	public Date getDateEmpr() {
		return dateEmpr;
	}
	public void setDateEmpr(Date dateEmpr) {
		this.dateEmpr = dateEmpr;
	}
	public Date getDateRtn() {
		return dateRtn;
	}
	public void setDateRtn(Date dateRtn) {
		this.dateRtn = dateRtn;
	}
	public int getNbrEmprntLivre() {
		return nbrEmprntLivre;
	}
	public void setNbrEmprntLivre(int nbrEmprntLivre) {
		this.nbrEmprntLivre = nbrEmprntLivre;
	}
	public int getNbrEmprCDVD() {
		return nbrEmprCDVD;
	}
	public void setNbrEmprCDVD(int nbrEmprCDVD) {
		this.nbrEmprCDVD = nbrEmprCDVD;
	}
	

}
