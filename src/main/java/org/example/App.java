package org.example;

import org.example.warehouse.Depo;
import org.example.warehouse.MarketResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
/*
        MarketResource t1=MarketResource.COIN;
        MarketResource t2=MarketResource.COIN;
        System.out.println(t1==t2);*/

        Depo X=new Depo();
        System.out.println(X.add(MarketResource.COIN,2,2));
        System.out.println(X.add(MarketResource.COIN,2,2));

        System.out.println(X.add(MarketResource.SHIELD, 1, 3));
        /*System.out.println(X.add(MarketResource.SHIELD,4,3));
        System.out.println(X.add(MarketResource.SHIELD,2,3));
*/
    }
}
