
package dominoes;

import java.awt.Image;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.ImageIcon;

public class Domino implements Comparable, Serializable{
    private static TreeMap<String, File> horizontalMap = new TreeMap();
    private static TreeMap <String, File> verticalMap = new TreeMap();
    private int totalValue;
    private Integer sideOneValue;
    private Integer sideTwoValue;
    private boolean selected;
    private boolean sideOneOpen;
    private boolean sideTwoOpen;
    private boolean horizontal;
    private ArrayList<String> openSides;
    
    
    public Domino() {
        if (horizontalMap.isEmpty())
            loadMap();
        totalValue = 0;
        sideOneValue = null;
        sideTwoValue = null;
        selected = false;
        sideOneOpen = true;
        sideTwoOpen = true;
        openSides = new ArrayList();
        openSides.add("up");
        openSides.add("down");
        openSides.add("left");
        openSides.add("right");
        horizontal = false;
    }
    
    public Domino(String name) {
        Scanner chop = new Scanner(name);
        chop.useDelimiter(":");
        if (horizontalMap.isEmpty())
            loadMap();
        sideOneValue = Integer.parseInt(chop.next());
        sideTwoValue = Integer.parseInt(chop.next());
        totalValue = sideOneValue + sideTwoValue;
        selected = false;
        sideOneOpen = true;
        sideTwoOpen = true;
        horizontal = false;
        openSides = new ArrayList();
        if (sideOneValue == sideTwoValue) {
            openSides.add("up");
            openSides.add("down");
            openSides.add("left");
            openSides.add("right");
        }
    }
    
    public void closeSide(String str) {
        openSides.remove(str);
    }
    
    public ArrayList<String> getOpenSides() {
        return openSides;
    }
    
    public boolean isSideOneOpen() {
        return sideOneOpen;
    }

    public void setSideOneOpen(boolean sideOneOpen) {
        this.sideOneOpen = sideOneOpen;
    }

    public boolean isSideTwoOpen() {
        return sideTwoOpen;
    }

    public void setSideTwoOpen(boolean sideTwoOpen) {
        this.sideTwoOpen = sideTwoOpen;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public Integer getTotalValue() {
        return totalValue;
    }

    public Integer getSideOneValue() {
        return sideOneValue;
    }

    public Integer getSideTwoValue() {
        return sideTwoValue;
    }

    public void setSideOneValue(int sideOneValue) {
        this.sideOneValue = sideOneValue;
    }

    public void setSideTwoValue(int sideTwoValue) {
        this.sideTwoValue = sideTwoValue;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setOpenSides(String openSides) {
        Scanner chop = new Scanner(openSides);
        chop.useDelimiter(" ");
        this.openSides.clear();
        while (chop.hasNext()) {
            this.openSides.add(chop.next());
        }
    }
    
    public ImageIcon getImageIcon(String name, String orientation) {
        ImageIcon image = new ImageIcon();
        if (orientation.equals("horizontal")) {
            horizontal = true;
            image = new ImageIcon(horizontalMap.get(name).getAbsolutePath());
        } else
            image = new ImageIcon(verticalMap.get(name).getAbsolutePath());
        return image;
    }
    
    public ImageIcon getInverseImageIcon(Domino domino) {
        String name = domino.toString();
        
        ImageIcon icon = domino.getImageIcon(domino.toString(), "vertical"); 
        
        File folder = new File("Images\\inverseDominoes");
        
        File[] files = folder.listFiles();

        for (File file : files) {
            String fileName =  file.getName().substring(0, 1) + ":" + file.getName().substring(file.getName().indexOf(".") - 1, file.getName().indexOf("."));
            if (name.equals(fileName))
                icon = new ImageIcon(file.getAbsolutePath());  
        }
        return icon;
    }
    
    private void loadMap() {
        File folder = new File("Images\\horizontalImages");
        
        File[] files = folder.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                String name = file.getName().substring(0, 1) + ":" + file.getName().substring(file.getName().indexOf(".") - 1, file.getName().indexOf("."));
                horizontalMap.put(name, file);
            }
        }
        
        folder = new File("Images\\verticalImages");
        
        files = folder.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                String name = file.getName().substring(0, 1) + ":" + file.getName().substring(file.getName().indexOf(".") - 1, file.getName().indexOf("."));
                verticalMap.put(name, file);
            }
        }
    }
    
    public String toString() {
        return getSideOneValue() + ":" + getSideTwoValue();
    }

    @Override
    public int compareTo(Object o) {
        Domino domino = (Domino)o;
        String name = domino.toString();
        return toString().compareTo(name);
    }
}
