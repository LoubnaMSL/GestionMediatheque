package Projet;
import java.util.*;

public class CD{
private String nomAlbum;
private String interprete;
private String editeur;
public CD(String nomAlbum, String interprete, String editeur) {
	this.nomAlbum = nomAlbum;
	this.interprete = interprete;
	this.editeur = editeur;
}
public String getNomAlbum() {
	return nomAlbum;
}
public void setNomAlbum(String nomAlbum) {
	this.nomAlbum = nomAlbum;
}
public String getInterprete() {
	return interprete;
}
public void setInterprete(String interprete) {
	this.interprete = interprete;
}
public String getEditeur() {
	return editeur;
}
public void setEditeur(String editeur) {
	this.editeur = editeur;
}

}
