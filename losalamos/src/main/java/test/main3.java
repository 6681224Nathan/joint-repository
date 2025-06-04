package test;

import java.util.*;

class main3
{
    public static void main(String[] args)
    {
        Humanoid human = new Humanoid();
        human.showNum();
    }
}

interface greeting
{
    default int three()
    {
        return 3;
    }

    public int four();

}

class Humanoid implements greeting
{
    public Humanoid()
    {

    }

    public int four()
    {
        return 4;
    }

    public void showNum()
    {
        System.out.println(three());
    }

}