import java.util.*;

class Contest {

    private Card[] Cards = new Card[52];
    Player[] Player;
    LinkedList<Card> Talia;

    Contest(int NoP)
    {
        Player = new Player[NoP];
        Talia = new LinkedList<>();

        CreateCards();
        CreatePlayers(NoP);
        Shuffling();
    }

    private void Shuffling()
    {
        Talia.addAll(Arrays.asList(Cards).subList(0, 52));
        Collections.shuffle(Talia);
    }

    private void CreatePlayers(int NoP)
    {
        for (int i=0;i<NoP;i++)
        {
            Player[i] =new Player();
        }
    }

    private void CreateCards()
    {
        for (int j=0;j<4;j++)
        {
            String colour;
            switch (j) {
                case 0: colour = "C";
                    break;
                case 1: colour = "D";
                    break;
                case 2: colour = "H";
                    break;
                case 3: colour = "S";
                    break;
                default: colour = "Err";
                    break;
            }

            for (int i = 0; i < 9; i++)
            {
                int ii=i+2;
                Cards[j*13+i] = new Card(ii, ii +" " + colour, "PNG/"+ ii+colour +".png");
            }

            Cards[j*13+12] = new Card(11, "As " + colour, "PNG/"+ "A" + colour +".png");

            for (int i = 9; i < 12; i++)
            {
                int ii=i-7;
                String nazwa;
                switch (i) {
                    case 9: nazwa = "J";
                        break;
                    case 10: nazwa = "Q";
                        break;
                    case 11: nazwa = "K";
                        break;
                    default: nazwa = "Err";
                        break;
                }
                Cards[j*13+i] = new Card(ii, nazwa + " " + colour, "PNG/"+ nazwa + colour +".png");
            }
        }
    }

}
