package org.example;


import org.example.warehouse.Depo;
import org.example.warehouse.MarketResource;
import org.junit.jupiter.api.Test;
/*
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
*/
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Depo X=new Depo();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void initialDepoNull() throws Exception {
       // null is empty

        assertNull(X.getrowState(1)[0]);
        assertNull(X.getrowState(2)[0]);
        assertNull(X.getrowState(3)[0]);

    }
    @Test
    public void addDepo() throws Exception {


        assertEquals(0, X.add(MarketResource.COIN, 2, 2));
        assertEquals(MarketResource.COIN, X.getrowState(2)[0]);
        assertEquals(MarketResource.COIN, X.getrowState(2)[1]);
        assertEquals(0,X.add(MarketResource.SHIELD, 1, 3));
        assertEquals(MarketResource.SHIELD, X.getrowState(3)[0]);
         assertNull(X.getrowState(3)[1]);
         assertNull(X.getrowState(3)[2]);
         assertEquals(0, X.add(MarketResource.SHIELD, 2, 3));
         assertEquals(MarketResource.SHIELD, X.getrowState(3)[1]);
         assertEquals(MarketResource.SHIELD, X.getrowState(3)[2]);
         assertEquals(-1, X.add(MarketResource.SHIELD, 1, 1));
    }


    }
