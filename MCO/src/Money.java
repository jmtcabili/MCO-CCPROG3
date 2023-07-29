package MCO1;
public class Money {
    private int coin1;
    private int coin5;
    private int coin10;
    private int coin20;
    private int bill20;
    private int bill50;
    private int bill100;
    private int bill200;
    private int bill500;
    private int bill1000;
    private int total; 

    public int getCoin1 () { 
        return coin1;
    }

    public int getCoin5 () {
        return coin5;
    }

    public int getCoin10 () {
        return coin10;
    }

    public int getCoin20 () {
        return coin20;
    }

    public int getBill20 () {
        return bill20;
    }

    public int getBill50 () {
        return bill50;
    }

    public int getBill100 () {
        return bill100;
    }

    public int getBill200 () {
        return bill200;
    }

    public int getBill500 () {
        return bill500;
    }

    public int getBill1000 () {
        return bill1000;
    }

    public void setCoin1 (int amount) {
        this.coin1 += amount;
    }

    public void setCoin5 (int amount) {
        this.coin5 += amount;
    }

    public void setCoin10 (int amount) {
        this.coin10 += amount;
    }

    public void setCoin20 (int amount) {
        this.coin20 += amount;
    }

    public void setBill20 (int amount) {
        this.bill20 += amount;
    }

    public void setBill50 (int amount) {
        this.bill50 += amount;
    }

    public void setBill100 (int amount) {
        this.bill100 += amount;
    }

    public void setBill500 (int amount) {
        this.bill500 += amount;
    }

    public int getTotalMoney () {
        total = coin1*1 + coin5*5 + coin10*10 + coin20*20 + bill20*20
                    + bill50*50 + bill100*100 + bill200*200 + bill500*500 
                    + bill1000*1000;

        return total;
    }
}
