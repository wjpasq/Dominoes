package dominoes;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Comparable, Serializable{
    private ArrayList<Domino> hand;
    private int score;
    private Integer team;
    private boolean computer;
    public boolean out;
    
    public Player() {
        hand = new ArrayList();
        score = 0;
        team = 0;
        computer = false;
        out = false;
    }

    public boolean isOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public boolean isComputer() {
        return computer;
    }

    public void setHand(ArrayList<Domino> hand) {
        this.hand = hand;
    }

    public void setComputer(boolean computer) {
        this.computer = computer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }
    
    public void clearHand() {
        hand.clear();
    }
    
    public ArrayList getHand() {
        return hand;
    }
    
    public void add(Domino domino) {
        hand.add(domino);
    }
    
    public void remove(Domino domino) {
        hand.remove(domino);
    }
    
    public int getHandTotal() {
        int total = 0;
        for (Domino domino : hand)
            total += domino.getTotalValue();
        return total;
    }
    
    public boolean containsDouble() {
        for (Domino domino : hand) {
            if (domino.getSideOneValue().equals(domino.getSideTwoValue()))
                return true;
        }
        return false;
    }
    
    public Domino highestRank() {
        Domino highestTotal = new Domino();
        
        if (containsDouble()) {
            Domino highestDouble = new Domino();
            for (Domino domino : hand) {
                if (domino.getSideOneValue().equals(domino.getSideTwoValue())) {
                    if (domino.getTotalValue() >= highestDouble.getTotalValue())
                        highestDouble = domino;
                }
            }
            return highestDouble;
        } else {
            for (Domino domino : hand) {
                if (domino.getTotalValue() > highestTotal.getTotalValue())
                    highestTotal = domino;
            }
        }
        return highestTotal;
    }

    @Override
    public int compareTo(Object o) {
        String str = "" + getScore();
        return str.compareTo(o.toString());
    }
}
