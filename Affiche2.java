package moul;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Affiche2 extends Affiche1{
	JMenuItem newMenuItem = new JMenuItem("Aspiration");
	JMenu menu = new JMenu("Dictionnaire");
	public Affiche2(){}
	public Affiche2(String nom,int larg,int haut){
		this.hauteur=haut;
		this.nom=nom;
		this.largeur=larg;
	}
	void F(Container menuBar) throws Exception{
		this.F();
		  menuBar.add(menu);
		  menu.add(newMenuItem);
		  f.setVisible(true);
		  Asp4Vidal.Asp(newMenuItem);
	}
}
