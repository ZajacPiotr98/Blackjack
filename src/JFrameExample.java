/*
import java.awt.*;
import javax.swing.*;


class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;

        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}

public class JFrameExample {
    public static void main(String s[]) {
        JFrame frame = new JFrame("JFrame Example");
        JLabel label = new JLabel("Gracz1 | Twoje Karty");
        label.setBounds(50,50, 500,30);
        JLabel Dobierasz = new JLabel("Dobierasz?");
        Dobierasz.setBounds(50,270, 500,30);
        JButton buttonT = new JButton();
        buttonT.setText("Tak");
        buttonT.setBounds(50,300, 200,30);
        JButton buttonN = new JButton();
        buttonN.setText("Nie");
        buttonN.setBounds(250,300, 200,30);

        ImagePanel panel = new ImagePanel(
                new ImageIcon("PNG/2C.png").getImage().getScaledInstance(100,152,20));
        panel.setBounds(50, 100,100,152);
        ImagePanel panel2 = new ImagePanel(
                new ImageIcon("PNG/2D.png").getImage().getScaledInstance(100,152,20));
        panel2.setBounds(70, 100,100,152);
        frame.getContentPane().add(panel);
        frame.getContentPane().add(panel2);
        frame.add(label);
        frame.add(Dobierasz);
        frame.add(buttonT);
        frame.add(buttonN);
        //frame.add(panel);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        //frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}*/


import javafx.scene.layout.Pane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;

        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}

public class JFrameExample implements ActionListener {

    JFrame frame2 = new JFrame();
    Panele jPanel = new Panele();
    String NoP = new String();
    BufferedImage image;
    JLabel imageLabel;
    ArrayList<JLayeredPane> layeredPanes = new ArrayList<>();
    JLayeredPane[] lpane;
    Contest R1;
    int n = 0;

    private static void CheckPersian(Contest R, int n)
    {
        if (R.Player[n].CardsInHand.size() == 2 && R.Player[n].CardsInHand.get(0).value == 11 && R.Player[n].CardsInHand.get(1).value == 11 )
        {
            R.Player[n].Persian = Boolean.TRUE;
        }
    }

    private static void Dealing(Contest R, int n)
    {

        for (int j=0;j<n;j++)
        {
            for (int i=0;i<2;i++)
            {
                R.Player[j].CardsInHand.add(R.Talia.getFirst());
                R.Player[j].points += R.Talia.getFirst().value;
                R.Talia.removeFirst();
            }
            CheckPersian(R,j);
        }
    }

    private void NowyGracz(Contest R, int NoP, Panele jPanel, JFrame frame2)
    {

        if (!jPanel.buttonT.isVisible())
        {
            jPanel.buttonT.setVisible(true);
        }

        if (n<NoP)
        {
            System.out.println(n);
            n += 1;

            jPanel.NaglowekGracza.setText("Gracz" + n + " | Twoje karty");

            jPanel.kartyGracza.removeAll();
            jPanel.kartyGracza.revalidate();
            jPanel.kartyGracza.repaint();
            try {
                karty(R,n-1);
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }
        else
        {
            try {
                frame2.setContentPane(jPanel.wynikiPanel());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            frame2.invalidate();
            frame2.validate();


            jPanel.Zwyciesca.setText("Gracz" + (Results(R, NoP)+1));
            System.out.println(Results(R, NoP)+1);

        }
    }

    public static void main(String s[]) throws Exception {
    /*    JFrame frame = new JFrame("JFrame Example");
        BufferedImage image;
        JLabel imageLabel;
        JLayeredPane lpane = new JLayeredPane();
        lpane.setBounds(0,0, 500,590);
        JLabel label = new JLabel("Gracz1 | Twoje Karty");
        label.setBounds(50,50, 500,30);
        JLabel Dobierasz = new JLabel("Dobierasz?");
        Dobierasz.setBounds(50,270, 500,30);
        JButton buttonT = new JButton();
        buttonT.setText("Tak");
        buttonT.setBounds(50,300, 200,30);
        JButton buttonN = new JButton();
        buttonN.setText("Nie");
        buttonN.setBounds(250,300, 200,30);

        ImagePanel panel = new ImagePanel(
                new ImageIcon("PNG/2C.png").getImage().getScaledInstance(100,152,Image.SCALE_SMOOTH));
        panel.setBounds(50, 90,100,152);
        ImagePanel panel2 = new ImagePanel(
                new ImageIcon("PNG/3C.png").getImage().getScaledInstance(100,152,Image.SCALE_SMOOTH));
        panel2.setBounds(70, 90,100,152);
        ImagePanel panel3 = new ImagePanel(
                new ImageIcon("PNG/4D.png").getImage().getScaledInstance(100,152, Image.SCALE_SMOOTH));
        panel3.setBounds(90, 90,100,152);
        frame.add(lpane);
        lpane.add(panel, new Integer(0), 0);
        lpane.add(panel2, new Integer(1), 0);
        lpane.add(panel3, new Integer(2), 0);
        lpane.add(label);
        lpane.add(Dobierasz);
        lpane.add(buttonT);
        lpane.add(buttonN);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        //frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        image = ImageIO.read(new File("PNG/background.png"));
        imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(0,0,500, 500);
        lpane.add(imageLabel);

*/

    JFrameExample j = new JFrameExample();

    }

    JFrameExample() throws IOException {
        jPanel.buttonStart.addActionListener(this);
        frame2.setSize(500, 500);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame2.add(jPanel.startPanel());
        frame2.setContentPane(jPanel.startPanel());
        frame2.invalidate();
        frame2.validate();
        frame2.setVisible(true);


    }

    void karty (Contest R, int n) throws IOException
    {
//        layeredPanes.get(n).setBounds(0,0, 500,500);
//        lpane[n].setBounds(0,0, 500,500);

//        jPanel.panelGry.add(layeredPanes.get(n));


        for (int i = 0; i < R.Player[n].CardsInHand.size(); i++) {

            image = ImageIO.read(new File(R.Player[n].CardsInHand.get(i).source));
            imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(100, 152, Image.SCALE_SMOOTH)));
            imageLabel.setBounds(100+(i+1)*20,140,100, 152);
//            layeredPanes.get(n).add(imageLabel, new Integer(i), 0);
//            lpane[n].add(imageLabel, new Integer(i), 0);
            jPanel.kartyGracza.add(imageLabel, new Integer(i), 0);

            System.out.println(R.Player[n].CardsInHand.get(i).name);
        }
//        jPanel.panelGry.add(lpane[n]);

    }


    private static int Results(Contest R, int n)
    {

        Player playerWinner = R.Player[0];
        int winnersId=0;
        if (R.Player[0].points > 21 && R.Player[0].Persian == Boolean.FALSE)
        {
            int i=1;
            while(playerWinner == R.Player[0])
            {
                if (!(R.Player[i].points > 21 && R.Player[i].Persian == Boolean.FALSE))
                {
                    playerWinner =R.Player[i];
                    winnersId=i;

                }
                i=i+1;
            }
        }

        for (int i = 1; i < n; i++)
        {

            if ((R.Player[i].points <= 21 || R.Player[i].Persian == Boolean.TRUE) && R.Player[i].points > playerWinner.points )
            {
                playerWinner =R.Player[i];
                winnersId=i;
            }
        }

        System.out.println("\n" + "Wygrywa Gracz" + winnersId);


        System.out.println("Wyniki:");

        for (int i = 0; i < n; i++)
        {
            System.out.println("Gracz" + i + ": " + R.Player[i].points);
        }

        return winnersId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == jPanel.buttonStart) {

            NoP = jPanel.IluGraczy.getText();
//            n = Integer.parseInt(NoP);

            if (!NoP.equals("2") && !NoP.equals("3") && !NoP.equals("4") && !NoP.equals("5") && !NoP.equals("6") && !NoP.equals("7") && !NoP.equals("8"))
            {
                System.out.println("Zle");
                System.out.println(NoP);

            }
            else
            {

                R1 = new Contest(Integer.parseInt(NoP));
                Dealing(R1, Integer.parseInt(NoP));
                lpane = new JLayeredPane[Integer.parseInt(NoP)];
                for(int i=0; i<Integer.parseInt(NoP); i++)
                {
                    lpane[i] = new JLayeredPane();
                    layeredPanes.add(lpane[i]);
                }

                System.out.println("aa"+R1.Talia.getFirst().source);
                System.out.println("aa"+R1.Talia.getFirst().source);
                System.out.println(R1.Player[n].CardsInHand.get(0).name);
                try {
                    karty(R1,n);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


                System.out.println(NoP);
                System.out.println(n);

                try {
                    frame2.setContentPane(jPanel.graPanel());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                frame2.invalidate();
                frame2.validate();
                jPanel.buttonN.addActionListener(this);
                jPanel.buttonT.addActionListener(this);
                n += 1;

                jPanel.NaglowekGracza.setText("Gracz" + n + " | Twoje karty");

            }
        }

       else if(source == jPanel.buttonN)
        {
//            lpane[0].removeAll();
//            Container parent = lpane[n-1].getParent();
//            parent.remove(lpane[n-1]);
//            parent.validate();
//            parent.repaint();

            NowyGracz(R1, Integer.parseInt(NoP), jPanel, frame2);
//            if (n<Integer.parseInt(NoP))
//            {
//                if (!jPanel.buttonT.isVisible())
//                {
//                    jPanel.buttonT.setVisible(true);
//                }
//                System.out.println(n);
//                n += 1;
//
//                jPanel.NaglowekGracza.setText("Gracz" + n + " | Twoje karty");
//
//                jPanel.kartyGracza.removeAll();
//                jPanel.kartyGracza.revalidate();
//                jPanel.kartyGracza.repaint();
//                try {
//                    karty(R1,n-1);
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//
//
//            }
//            else
//            {
//                try {
//                    frame2.setContentPane(jPanel.wynikiPanel());
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//                frame2.invalidate();
//                frame2.validate();
//                jPanel.Zwyciesca.setText("Gracz" + (Results(R1, Integer.parseInt(NoP))+1));
//                System.out.println(Results(R1, Integer.parseInt(NoP))+1);
//
//            }
        }

        else if(source == jPanel.buttonT) {
//            lpane[0].removeAll();
//            Container parent = lpane[n-1].getParent();
//            parent.remove(lpane[n-1]);
//            parent.validate();
//            parent.repaint();



            if (R1.Player[n-1].points > 21 && R1.Player[n-1].Persian == Boolean.FALSE)
            {

                NowyGracz(R1, Integer.parseInt(NoP), jPanel, frame2);
//                if (n<Integer.parseInt(NoP))
//                {
//                    if (!jPanel.buttonT.isVisible())
//                    {
//                        jPanel.buttonT.setVisible(true);
//                    }
//                    System.out.println(n);
//                    n += 1;
//
//                    jPanel.NaglowekGracza.setText("Gracz" + n + " | Twoje karty");
//
//                    jPanel.kartyGracza.removeAll();
//                    jPanel.kartyGracza.revalidate();
//                    jPanel.kartyGracza.repaint();
//                    try {
//                        karty(R1,n-1);
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//
//
//                }
//                else
//                {
//                    try {
//                        frame2.setContentPane(jPanel.wynikiPanel());
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    frame2.invalidate();
//                    frame2.validate();
//
//
//                    jPanel.Zwyciesca.setText("Gracz" + (Results(R1, Integer.parseInt(NoP))+1));
//                    System.out.println(Results(R1, Integer.parseInt(NoP))+1);
//
//                }
            }
            else {

                R1.Player[n - 1].CardsInHand.add(R1.Talia.getFirst());
                R1.Player[n - 1].points += R1.Talia.getFirst().value;
                R1.Talia.removeFirst();

                jPanel.kartyGracza.removeAll();
                try {
                    karty(R1, n - 1);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                if (R1.Player[n-1].points > 21 && R1.Player[n-1].Persian == Boolean.FALSE)
                {
                    jPanel.buttonT.setVisible(false);

                }
            }

        }
    }
}



//        image = ImageIO.read(new File("PNG/2C.png"));
//                imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(100, 152, Image.SCALE_SMOOTH)));
//                imageLabel.setBounds(0,0,500, 500);
//                panelGry.add(imageLabel);