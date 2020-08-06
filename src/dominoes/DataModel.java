
package dominoes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JPanel;

public class DataModel implements Serializable {
    private ArrayList<Player> playerList;
    private Stack<Domino> boneyard;
    private boolean team;
    private int turnIndex;
    private DominoTrack track;
    private JPanel trackPanel;
    
    public DataModel(ArrayList<Player> playerList, Stack<Domino> boneyard, boolean team, int turnIndex, DominoTrack track, JPanel trackPanel) {
        this.playerList = playerList;
        this.boneyard = boneyard;
        this.team = team;
        this.turnIndex = turnIndex;
        this.track = track;
        this.trackPanel = trackPanel;
    }

    public JPanel getTrackPanel() {
        return trackPanel;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public Stack<Domino> getBoneyard() {
        return boneyard;
    }

    public boolean isTeam() {
        return team;
    }

    public int getTurnIndex() {
        return turnIndex;
    }

    public DominoTrack getTrack() {
        return track;
    }
}
