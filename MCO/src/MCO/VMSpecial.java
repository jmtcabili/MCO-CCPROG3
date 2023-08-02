package MCO;
/**
 * This class contains a subclass of VMReg
 * @author Johan Marlo T. Cabili
 * @author Joemar T. Lapasaran
 * @version 1.0
 */


import java.util.*;

public class VMSpecial extends VMReg {

    private ArrayList<Item> orderBag = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    String buffer;
    /** Blueprint of the class VMSpecial
     * @param name name of the item
     * @param slotcount calories of the item
     * @param slotItemLimit price of the item
     */
    public VMSpecial(String name, int slotCount, int slotItemLimit) {
        super(name, slotCount, slotItemLimit);
    }   
    
    public ArrayList<Item> getOrderBag(){
        return this.orderBag; 
    }
}