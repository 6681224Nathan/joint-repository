package losalamos;


class Parentclass 
{
    private int x=10;

    public Parentclass(){};

    public int getX()   {return x;}
    public void setX(int d) { x=d;}
}

class Childclass extends Parentclass 
{

    public Childclass()
    { 
        super();
        super.setX(5);
        System.out.println(super.getX());

    }


}

class main2
{
    public static void main(String[] args){
        Parentclass parentclass = new Parentclass();
        Childclass childclass = new Childclass();
    }
}