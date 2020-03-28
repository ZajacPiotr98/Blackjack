import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panele {

    BufferedImage image;
    JLabel imageLabel;

    JPanel panelStart;
    JLabel NaglowekStartu = new JLabel("Podaj liczbę graczy z zakresu 2-8:");
    JTextArea IluGraczy = new JTextArea();
    JButton buttonStart = new JButton("GRAJ");

    JPanel panelGry;
    JLabel NaglowekGracza = new JLabel("Gracz1 | Twoje Karty");
    JLayeredPane kartyGracza = new JLayeredPane();
    JLabel NaglowekDobierasz = new JLabel("Dobierasz?");
    JButton buttonT = new JButton("Tak");
    JButton buttonN = new JButton("Nie");

    JPanel panelWyniki;
    JLabel NaglowekZwyciescy = new JLabel("Wygrywa:");
    JLabel Zwyciesca = new JLabel("Gracz1");

    public Panele()
    {
        panelStart = new JPanel();
        panelGry = new JPanel();
        panelWyniki = new JPanel();

    }

    public JPanel startPanel() throws IOException {
        panelStart.setLayout(null);
        panelStart.setBackground(Color.red);

        NaglowekStartu.setFont(new Font("Arial Black", Font.BOLD, 16));
        NaglowekStartu.setForeground(Color.black);
        NaglowekStartu.setBounds(100, 170, 300, 30);
        panelStart.add(NaglowekStartu);

        IluGraczy.setFont(new Font("Arial Black", Font.PLAIN, 15));
        IluGraczy.setForeground(Color.black);
        IluGraczy.setBackground(Color.white);
        IluGraczy.setBounds(150, 200, 200, 30);
        panelStart.add(IluGraczy);

        buttonStart.setFont(new Font("Arial Black", Font.BOLD, 20));
        buttonStart.setBounds(200, 250, 100, 30);
        panelStart.add(buttonStart);

        image = ImageIO.read(new File("PNG/background.png"));
        imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(0,0,500, 500);
        panelStart.add(imageLabel);

        return panelStart;
    }

    public JPanel graPanel() throws IOException {
        panelGry.setLayout(null);
        panelGry.setBackground(Color.red);

        NaglowekGracza.setFont(new Font("Arial Black", Font.BOLD, 16));
        NaglowekGracza.setForeground(Color.black);
        NaglowekGracza.setBounds(100, 100, 300, 30);
        panelGry.add(NaglowekGracza);

        kartyGracza.setBounds(0,0, 500,500);
        panelGry.add(kartyGracza);

        NaglowekDobierasz.setFont(new Font("Arial Black", Font.BOLD, 16));
        NaglowekDobierasz.setForeground(Color.black);
        NaglowekDobierasz.setBounds(100, 300, 300, 30);
        panelGry.add(NaglowekDobierasz);


        buttonT.setFont(new Font("Arial Black", Font.BOLD, 20));
        buttonT.setBounds(100, 330, 150, 30);
        panelGry.add(buttonT);


        buttonN.setFont(new Font("Arial Black", Font.BOLD, 20));
        buttonN.setBounds(250, 330, 150, 30);
        panelGry.add(buttonN);

        image = ImageIO.read(new File("PNG/background.png"));
        imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(0,0,500, 500);
        panelGry.add(imageLabel);

        return panelGry;
    }

    public JPanel wynikiPanel() throws IOException {
        panelWyniki.setLayout(null);
        panelWyniki.setBackground(Color.red);

        NaglowekZwyciescy.setFont(new Font("Arial Black", Font.BOLD, 16));
        NaglowekZwyciescy.setForeground(Color.black);
        NaglowekZwyciescy.setBounds(100, 150, 300, 50);
        panelWyniki.add(NaglowekZwyciescy);

        Zwyciesca.setFont(new Font("Arial Black", Font.BOLD, 16));
        Zwyciesca.setForeground(Color.black);
        Zwyciesca.setBounds(100, 250, 300, 50);
        panelWyniki.add(Zwyciesca);

        image = ImageIO.read(new File("PNG/background.png"));
        imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(0,0,500, 500);
        panelWyniki.add(imageLabel);

        return panelWyniki;
    }

}
