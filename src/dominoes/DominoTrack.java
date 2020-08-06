
package dominoes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class DominoTrack implements Comparable, Serializable{
    private TreeMap<Domino, Domino[]> track;
    
    public DominoTrack() {
        track = new TreeMap();
    }
    
    public void add(Domino newDomino) {
        Domino[] connections;
        if (newDomino.getSideOneValue().equals(newDomino.getSideTwoValue()))
            connections = new Domino[4];
        else
            connections = new Domino[2];
//        System.out.println("putting " + newDomino + " into map");
//        
//        System.out.println("Checking Map before...");
//        Set keys = track.keySet();
//        Iterator iterator = keys.iterator();
//        while (iterator.hasNext()) {
//            Domino str = (Domino)iterator.next();
//            System.out.print(str.toString() + " -> ");
//            for (Domino s : track.get(str))
//                System.out.print(s + " ");
//            System.out.println("\n");
//        }
//        
        track.put(newDomino, connections);
//        
//        System.out.println("Checking Map after...");
//        keys = track.keySet();
//        iterator = keys.iterator();
//        while (iterator.hasNext()) {
//            Domino str = (Domino)iterator.next();
//            System.out.print(str.toString() + " -> ");
//            for (Domino s : track.get(str))
//                System.out.print(s + " ");
//            System.out.println("\n");
//        }
    }
    
    public void closeSide(String name, String side) {
        Set keySet = track.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Domino keyDom = (Domino) iterator.next();
            if (keyDom.toString().equals(name)) {
                keyDom.closeSide(side);
            }
            for (Domino d : track.get(keyDom)) {
                if (d != null && d.toString().equals(name)){
                    d.closeSide(side);
                }
            }
        }
    }
    
    public void setOpenSides(String name, String openSides) {
        Set keySet = track.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Domino keyDom = (Domino) iterator.next();
            if (keyDom.toString().equals(name)) {
                keyDom.setOpenSides(openSides);
            }
            for (Domino d : track.get(keyDom)) {
                if (d != null && d.toString().equals(name)){
                    d.setOpenSides(openSides);
                }
            }
        }
    }
    
    public void connect(Domino a, Domino b, int num) {
        int i = 0;
        while (i < track.get(a).length && track.get(a)[i] != null)
            i++;
        track.get(a)[i] = b;
        i = 0;
        if (track.containsKey(b)) {
            while (i < track.get(b).length && track.get(b)[i] != null)
                i++;
            track.get(b)[i] = a;
        } else {
            add(b);
            track.get(b)[0] = a;
        }
        if (a.getSideOneValue() == num)
            a.setSideOneOpen(false);
        else
            a.setSideTwoOpen(false);
        
        if (b.getSideOneValue() == num)
            b.setSideOneOpen(false);
        else
            b.setSideTwoOpen(false);
        
    }

    public TreeMap<Domino, Domino[]> getTrack() {
        return track;
    }
    
    public boolean isOpen(Domino d) {
        //System.out.println("\nTesting isOpen...");
        
        if (d != null) {
            if (track.containsKey(d)) {
                for (Domino domino : track.get(d)) {
                    if (domino == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public ArrayList<Domino> getOpenDominoes() {
        ArrayList<Domino> openD = new ArrayList();
        Set<Domino> keySet = track.keySet();
        Iterator iterator = keySet.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Domino domino = (Domino)iterator.next();
            if (isOpen(domino))
                openD.add(domino);
            //i++;
        }
        return openD;
    }
    
    public void clear() {
        track.clear();
    }

//    public TreeMap<String, ArrayList<String>> getOpenSideMap(Domino d) {
//        TreeMap<String, ArrayList<String>> result = new TreeMap();
//        
//        for (Domino domino : getOpenDominoes()) {
//            
//        }
//            
//    }
    
//    public ArrayList<Integer> getOpenVals() {
//        ArrayList<Integer> result = new ArrayList();
//    }
    
    public String toString() {
        String str = "";
        Set keySet = track.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext())
            str += it.next().toString();
        return str;
    }

    @Override
    public int compareTo(Object o) {
        return toString().compareTo(o.toString());
    }
}
