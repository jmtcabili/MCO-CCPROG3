
/**
 * This class contains getters and setters of money
 * @author Johan Marlo T. Cabili
 * @author Joemar T. Lapasaran
 * @version 1.0
 */
public class Money {
    private int coin1 = 0;
    private int coin5 = 0;
    private int coin10 = 0;
    private int coin20 = 0;
    private int bill20 = 0;
    private int bill50 = 0;
    private int bill100 = 0;
    private int total = 0; 

    /** Gathers the one peso coin/s
     * @return the one peso coin/s
     */
    public int getCoin1 () { 
        return coin1;
    }

     /** Gathers the five peso coin/s
     * @return the five peso coin/s
     */
    public int getCoin5 () {
        return coin5;
    }

     /** Gathers the 10 peso coin/s
     * @return the 10 peso coin/s
     */
    public int getCoin10 () {
        return coin10;
    }

     /** Gathers the 20 peso coin/s
     * @return the 20 peso coin/s
     */
    public int getCoin20 () {
        return coin20;
    }

     /** Gathers the 20 peso bill/s
     * @return the 20 peso bill/s
     */
    public int getBill20 () {
        return bill20;
    }

     /** Gathers the 50 peso bill/s
     * @return the 50 peso bill/s
     */
    public int getBill50 () {
        return bill50;
    }

     /** Gathers the 100 peso bill/s
     * @return the 100 peso bill/s
     */
    public int getBill100 () {
        return bill100;
    }

     /** Gathers the 500 peso bill/s
     * @return the 500 peso bill/s
     */

     /** Sets the amount of the one peso coin/s
     * @param amount the amount to be added to the one peso coin/s
     */
    public void setCoin1 (int amount) {
        this.coin1 += amount;
    }

     /** Sets the amount of the five peso coin/s
     * @param amount the amount to be added to the five pesos coin/s
     */
    public void setCoin5 (int amount) {
        this.coin5 += amount;
    }

    /** Sets the amount of ten peso coin/s
     * @param amount the amount to be added to the ten peso coin/s
     */
    public void setCoin10 (int amount) {
        this.coin10 += amount;
    }

    /** Sets the amount of twenty peso coin/s
     * @param amount the amount to be added to the twenty peso coin/s
     */
    public void setCoin20 (int amount) {
        this.coin20 += amount;
    }

    /** Sets the amount of twenty peso bill/s
     * @param amount the amount to be added to the twenty peso bill/s
     */
    public void setBill20 (int amount) {
        this.bill20 += amount;
    }

     /** Sets the amount of fifty peso bill/s
     * @param amount the amount to be added to the fift peso bill/s
     */
    public void setBill50 (int amount) {
        this.bill50 += amount;
    }

    /** Sets the amount of one hundred peso bill/s
     * @param amount the amount to be added to the one hudred peso bill/s
     */
    public void setBill100 (int amount) {
        this.bill100 += amount;
    }

    /** Sets the amount of five hundred peso bill/s
     * @param amount the amount to be added to the five hundred peso bill/s
     */

    /** Computes for the sum of all the money denominations
     * @return the sum of all the money denominations
     */
    public int getTotalMoney () {
        total = coin1*1 + coin5*5 + coin10*10 + coin20*20 + bill20*20
                    + bill50*50 + bill100*100;

        return total;
    }
}
