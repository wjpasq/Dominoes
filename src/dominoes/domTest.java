
package dominoes;

import java.util.ArrayList;

public class domTest {
    public static void main(String[] args) {
        
        //////////prints 0:0//////////////
        Domino double0 = new Domino("0:0");
        System.out.println(double0);
        
        /////////prints null:null//////////
        Player p = new Player();
        ArrayList<Domino> hand = new ArrayList();
        hand.add(double0);
        p.setHand(hand);
        System.out.println(p.highestRank());
        
        
        /////////prints 0:0////////////
        ArrayList<Domino> list = new ArrayList();
        list.add(new Domino("0:0"));
        System.out.println(list.get(0));
    }
    
}
