/* 
 * AUTHORS
 * Nathan Tanaboriboon 6681224
 * Veerapat Leepiboonsawat 6580969
*/


package Ex3_6681224;

import java.util.*;

class Customer
{
    private int ID;
    protected int totalPrice;
    public Customer(int id)         { ID = id;}
    public int getID()              { return ID;}
    public void printCustomer()     {/*override this in child class */}
    public void calculatePrice()   {/*override this in child class */}
}

class HumanCustomer extends Customer
{
    private boolean[] SpaOption={false, false, false, false};
    private static final String[] SpaOptionName={"Face", "Body", "Hand", "Foot"};
    private static final int SpaOptionPrice[] = {1200, 1200, 600, 800};

    public int get_price(){ return totalPrice;}

    public HumanCustomer(int id){ 
        super(id);
        randomSpaOption();
        calculatePrice();
        printCustomer();

    }

    public void calculatePrice(){
        for(int i=0; i<SpaOption.length; i++){
            if(SpaOption[i] == true){
                super.totalPrice+=SpaOptionPrice[i];
            }
        }
    }

    public void randomSpaOption(){
        int i=0;
        Random rand = new Random();
        
        boolean hasTrue=false;
        while(hasTrue == false){
            
            for(i=0; i<SpaOption.length; i++){
                SpaOption[i] = rand.nextBoolean();
            }

             for(i=0; i<4; i++){
                if(SpaOption[i] == true){
                    hasTrue = true;
                    break;
                }
                
            }
        }
    }

    public void printCustomer(){
        System.out.printf("Customer %-2d %-8s >> %26s    spa options = "
        , getID(), "(human)", "", "");

        for(int i=0; i<SpaOption.length; i++){
            if(SpaOption[i] == true){
                System.out.print(SpaOptionName[i]+" ");
            }
        }

        //temp
        //System.out.printf("\nprice = %d", totalPrice);

        System.out.println("");
    }

    
}

class CatCustomer extends Customer{

    private boolean LongHair;
    private String HairType;
    private double weight;

    public int get_price(){ return totalPrice;}

    public CatCustomer(int id)
    { 
        super(id);
        Random rand = new Random();
        
        LongHair=rand.nextBoolean();
        weight = rand.nextDouble(3, 20);
        
        if(LongHair == true){ HairType="Long";}
        else                { HairType="Short";}


        calculatePrice();
        printCustomer();

    }


    public void printCustomer(){
        System.out.printf("Customer %-2d %-8s >> weight = %4.1f, hair = %s"
        , getID(), "(cat)", weight, HairType);

        //temp
        //System.out.printf("\nprice = %d", totalPrice);

        System.out.println("");
    }

    public void calculatePrice(){

        if(weight>20) { System.out.println("WARNING weight exceeds");}
        //prevent unforseen error, just in case...

        if(LongHair == false)
        {
            if(weight < 5)              { totalPrice = 600;}
            else if(weight < 10)        { totalPrice = 700;}
            else                        { totalPrice = 800;}
        }
        else
        {
            if(weight < 5)              { totalPrice = 750;}
            else if(weight < 10)        { totalPrice = 850;}
            else                        { totalPrice = 1100;}
        }

    }


}

///////////////////////////////////////////////////////////////////////////////////////

class main2{
    public static void main(String[] args){

        Scanner kbscanner = new Scanner(System.in);
        int i=0;

        System.out.println("Enter #customers = ");
        int n=kbscanner.nextInt();

        Customer[] customer = new Customer[n];
        Random rand = new Random();

        System.out.println("=== All customers in reverse order ===");

        n=customer.length-1;
        for(i=n; i>=0; i--) //assign whether the customer is cat or human
        {
            boolean humancustomer = rand.nextBoolean();
            if(humancustomer)
            {
                customer[i] = new HumanCustomer(i);
            }
            else
            {
                customer[i] = new CatCustomer(i);
            }
        }

        
        System.out.println("\n=== Human customers ===");
        for(i=0; i<customer.length; i++)
        {
            if ( customer[i] instanceof HumanCustomer ) 
            {
                HumanCustomer human = (HumanCustomer) customer[i];
                printCustomer2(human.getID(), "(Human)", human.get_price());
            }
        }


        System.out.println("\n=== Cat customers ===");
        for(i=0; i<customer.length; i++)
        {
            if ( customer[i] instanceof CatCustomer ) 
            {
                CatCustomer cat = (CatCustomer) customer[i];
                printCustomer2(cat.getID(), "(Cat)", cat.get_price());
            }
        }

        kbscanner.close();
        

        
    }

    public static void printCustomer2(int id, String CustomerType, int totalprice)
    {
        System.out.printf("Customer %-2d %-8s >> total price = %-,4d\n"
        , id, CustomerType/*with bracket () */, totalprice);
    }
}

