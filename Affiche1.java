package moul;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Affiche1 {
	protected String nom=new String();
	protected int largeur,hauteur;
	
	final JFrame f = new JFrame(this.nom);
	public Affiche1(){}
	public Affiche1(String nom,int larg,int haut){
	this.nom=nom;
	this.hauteur=haut;
	this.largeur=larg;
}
void F() throws Exception{
	  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  f.setSize(500,500);
	  JMenuBar menuBar = new JMenuBar();
	  f.setJMenuBar(menuBar);
	  f.setVisible(true);
	  f.setSize(this.hauteur,this.largeur);
}
}
