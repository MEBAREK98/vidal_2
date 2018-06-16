/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moul;

import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author amirak
 */
public class Asp4Vidal {

    private static int speed;
   
        static void Aspirer() throws Exception
        {
                String ur ="http://127.0.0.1:1025/vidal/vidal-Sommaires-Substances-"; //InputDialog.getUrl();
                if(ur == null) return;
                PrintWriter ecrire;
                ecrire = new PrintWriter("Fichier_sortie.txt","UTF-16LE");
                ecrire.write("\uFEFF");
                String pattern = "(http://.+/.+/vidal-Sommaires-Substances-).(.htm)";
                Pattern motif=Pattern.compile(".*<a href=.Substance/.+>(.+)</a>.*");
//              String medoc="<a href=.Substance/.+>(.+)</a>";
                PrintWriter w= new PrintWriter("Subst.dic");
                w.write("\uFEFF");
                BufferedReader lireBuffer;

                int barreCount=0;
                {
                        JFrame frame = new JFrame("aspiration... ");
                        JProgressBar barre = new JProgressBar();
                        JProgressBar barre2 = new JProgressBar();
                        JLabel UrlL = new JLabel();
                        JLabel UrlL1 = new JLabel();
                        JLabel UrlL2 = new JLabel();
                          barre.setStringPainted(true);
                        barre2.setStringPainted(true);
                        GridLayout gri = new GridLayout();
                        gri.setColumns(1);
                        gri.setRows(4);
                        FlowLayout disp = new FlowLayout();
                        FlowLayout disp2 = new FlowLayout();
                        FlowLayout disp3 = new FlowLayout();
                        JPanel panel3 = new JPanel();
                        JPanel panel1 = new JPanel();
                        JPanel panel2 = new JPanel();
                        panel1.setLayout(disp);
                        panel2.setLayout(disp2);
                        panel3.setLayout(disp3);
                        frame.setLayout(gri);
                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                int width = gd.getDisplayMode().getWidth();
                int height = gd.getDisplayMode().getHeight();
                        frame.setLocation(height/2,width/2);
                        panel3.add(UrlL);
                        frame.add(panel3);
                        panel1.add(UrlL1);
                        panel2.add(UrlL2);
                        panel1.add(barre);
 panel2.add(barre2);
                        frame.add(panel1);
                        frame.add(panel2);
                        Thread t = new Thread();


                        JSlider CustomSpeed = new JSlider(JSlider.HORIZONTAL,0, 10, 5);
                        CustomSpeed.addChangeListener(new ChangeListener()
                                {

                                        public void stateChanged(ChangeEvent e)
                                        {
                                                JSlider source = (JSlider)e.getSource();
                                                Asp4Vidal.speed = (int)source.getValue();
                                        }

                          

                                });

                        CustomSpeed.setMajorTickSpacing(10);
                        CustomSpeed.setMinorTickSpacing(1);
                        CustomSpeed.setPaintTicks(true);
                        CustomSpeed.setPaintLabels(true);
                        frame.add(CustomSpeed);
                        frame.setSize(350,200);
                        frame.setVisible(true);
                        frame.setLocation(width/2-frame.getWidth()/2,height/2-frame.getHeight()/2);
                        double ratio = (double)100/26;
                        float advance = 0;
                for(char a = 'A';a<='Z';a++)
                {

                        ur = ur.replaceAll(pattern, "$1"+a+"$2");
                        double ratio2=0;
                        ratio2 = ratio/100;
                        UrlL.setText("URL ==>" + a);
                        for(int i=1;i<=100;i++)
                        {
                        java.lang.Thread.sleep(speed);
                                barre2.setValue(i);
                                advance += ratio2;
                                barreCount = Math.round(advance);
                                barre.setValue(barreCount);
                                UrlL2.setText("progression ==>" + i);
                                UrlL1.setText("progression ==>" + barreCount);
                        }




                URL url = new URL(ur);
                //instancier un objet de la classe URL
                //System.out.println("URL à aspirer ==>"+ur);
 BufferedReader lire = new BufferedReader(new
                InputStreamReader(url.openStream()));
                do {
                String line = lire.readLine();
                if(line == null)
                break;
                ecrire.write(line);
                ecrire.write("\n");
                } while(true);

                }
                ecrire.close();
                File file = new File("Fichier_sortie.txt");


                lireBuffer = new BufferedReader(
                                new InputStreamReader(new FileInputStream(file),"UTF-8"));
                String s= new String();
                s=lireBuffer.readLine();
                while(s!=null)
                        {
                Matcher match = motif.matcher(s);

   if(match.find())
                {
                        w.write(match.group(1)+",.N\n");

                }
                s=lireBuffer.readLine();
                }
                lireBuffer.close();
                w.close();
            }
        }

         static void Asp(JMenuItem newMenuItem) throws Exception
         {
                // TODO Auto-generated method stub

       newMenuItem.addActionListener(new ActionListener()
       {
        public void actionPerformed(ActionEvent e)
        {

                try {
                        (new Thread((Runnable) new Asp4Vidal())).start();
                                } catch (Exception e1) {
                                        e1.printStackTrace();
                                }
        }

         
          
       });
        }
}