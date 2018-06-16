/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moul;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;
import static java.awt.SystemColor.menu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import jdk.nashorn.internal.runtime.regexp.joni.Matcher;

/**
 *
 * @author amirak
 */
public class Vidal {

    /**
     * @param args the command line arguments
     */
    private static Pattern p;
    private static Matcher m;
    
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException, IOException, Exception {
        // TODO code application logic here
    	Affiche1 frame_principale=new Affiche2("Extraction d'information",500,500);
    	frame_principale.F();
    	
    }
    
}