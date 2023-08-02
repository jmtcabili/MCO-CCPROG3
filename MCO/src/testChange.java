public class testChange {
    public static void main(String args[]){
        Money compartment = new Money(); 
        Money payment = new Money();
        int price = 50; 

        compartment.setBill100(0);
        compartment.setBill50(1);
        compartment.setCoin5(3);
        compartment.setCoin1(1);
        //compartment.setCoin5(3);
        //compartment.setCoin1(5);
        payment.setBill100(2);
        payment.setBill50(2);
        
        System.out.println(produceChange(payment, compartment, price));


        
    }
    public static boolean produceChange(Money payment, Money compartment, int price){
        //total ob1 - price = change 
        boolean sufficientChange = false; 
        int i = 0; 
        int change = payment.getTotalMoney()-price; 
        Money temp = payment;


        
        if (change >= 100 && compartment.getBill100() >= change/100){
            change = change % 100;
            compartment.setBill100(change /= 100);
        }
        if (change >= 50 && compartment.getBill50() >= change/50){
            change = change % 50;
            compartment.setBill50(change /= 50);
        }
        if (change >= 20 && compartment.getBill20() >= change/20){
            change = change % 20;
            compartment.setBill20(change /= 20);
        }
        if (change >= 20 && compartment.getCoin20() >= change/20){
            change = change % 20;
            compartment.setCoin20(change/=20);
        }
        if (change >= 10 && compartment.getCoin10() >= change/10){
            change = change % 10;
            compartment.setCoin10(change /= 10);
        }
        if (change >= 5 && compartment.getCoin5() >= change/5){
            change = change % 5;
            compartment.setCoin5(change /= 5);
        }
        if (change >= 1 && compartment.getCoin1() >= change/1){
            change = change % 1;
            compartment.setCoin1(change/=1);
        }
        System.out.println(change);
        if (change == 0)
            sufficientChange = true; 

        return sufficientChange; 
    }

}
