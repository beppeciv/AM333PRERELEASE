package org.example.Market;

import org.example.MatrixRowColumn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceMarketTest {

    @Test
    void getInstance() {
        ResourceMarket X=ResourceMarket.getInstance();

        int[] T= new int[6];
        for(int k=1;k<=4;k++) {
            Marble[] t1=X.getcolumn(k);
            for (Marble m : t1) {
                if (m instanceof MarbleBlue) T[0]++;
                if (m instanceof MarbleGrey) T[1]++;
                if (m instanceof MarblePurple) T[2]++;
                if (m instanceof MarbleRed) T[3]++;
                if (m instanceof MarbleWhite) T[4]++;
                if (m instanceof MarbleYellow) T[5]++;
            }

        }
        Marble m=X.getfreeMarble();
        if (m instanceof MarbleBlue) T[0]++;  //2
        if (m instanceof MarbleGrey) T[1]++;  //2
        if (m instanceof MarblePurple) T[2]++;  // 2
        if (m instanceof MarbleRed) T[3]++;  //1
        if (m instanceof MarbleWhite) T[4]++;  // 4
        if (m instanceof MarbleYellow) T[5]++;  // 2

        assertEquals(2,T[0]);
        assertEquals(2,T[1]);
        assertEquals(2,T[2]);
        assertEquals(1,T[3]);
        assertEquals(4,T[4]);
        assertEquals(2,T[5]);


    }

    @Test
    void getArrayOfMarbles() {

    }

    @Test
    void getMatrixOfMarblesOfMarbles() {
    }

    @Test
    void pushRow() {
        ResourceMarket X=ResourceMarket.getInstance();
        Marble[] m =new Marble[MatrixRowColumn.NUM_OF_COLUMN.value];
                m=X.getRow(1);
        X.pushRow(1);
        assertEquals(X.getfreeMarble().getClass(),m[0].getClass());

    }

    @Test
    void pushColumn() {
    }

    @Test
    void extractMarble() {
    }
}