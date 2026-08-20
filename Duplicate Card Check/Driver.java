public class Driver {
    public static void main(String[] args) {
        Card[] cards = new Card[5];

        Card card1 = new Card("Ace" , "Spades");
        Card card2 = new Card("King" , "Hearts");
        Card card3 = new Card("Queen" , "Clubs");
        Card card4 = new Card("Ace" , "Spades");
        Card card5 = new Card("Jack" , "Diamonds");

        Card[] newCards = {card1, card2, card3, card4, card5};

        int count = 0;

        for(Card newCard : newCards)
        {
            boolean duplicate = false;

            for(int i=0 ; i<count ; i++)
            {
                if(newCard.equals(cards[i]))
                {
                    duplicate = true;
                    break;
                }
            }

            if(duplicate)
            {
                System.out.println("Duplicate found : " + newCard);
            }
            else
            {
                cards[count] = newCard;
                count++;
            }
        }
    }
}
