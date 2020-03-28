import java.util.*;

class Player {
    int points;
    ArrayList<Card> CardsInHand;
    Boolean Persian;

    Player()
    {
        this.points = 0;
        CardsInHand = new ArrayList<>();
        this.Persian = Boolean.FALSE;
    }
}
