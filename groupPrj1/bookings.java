package groupPrj1;

class items{
    private String code;
    private String name;
    private int unit_price;

    public items()
    {
        code = "missing";
        name = "missing";
        unit_price = -1;
    }

    public items(String Code, String Name, int Unit_price)
    {
        code=Code;
        name=Name;
        unit_price=Unit_price;
    }

    public void set_code(String a){ code =a;}
    public void set_name(String a){ name =a;}
    public void set_unit_price(int a){ unit_price =a;}

    public String get_code(){ return code;}
    public String get_name(){ return name;}
    public int get_unit_price(){ return unit_price;}

}