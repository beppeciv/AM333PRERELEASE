package org.example.Market;


import org.example.*;
import org.example.Market.*;
/*
import org.example.MarbleBlue;
import org.example.MarbleGrey;
import org.example.MarblePurple;
import org.example.MarbleRed;
import org.example.MarbleWhite;
import org.example.MarbleYellow;
*/
import org.example.MatrixRowColumn;
import org.example.NumberOfMarble;

import java.util.ArrayList;
import java.util.List;

public class ResourceMarket {
    private static ResourceMarket resourceMarket;
    /* private  final int NUM_OF_WHITE=4;
     private final int NUM_OF_BLUE=4;
     private final int NUM_OF_GREY=4;
     private final int NUM_OF_YELLOW=4;
     private final int NUM_OF_PURPLE=4;
   private  final int NUM_OF_RED=4;*/
    private Marble[] arrayOfMarbles;
    private Marble freeMarble;
    private Marble[][] matrixOfMarbles;
    private Marble[][] matrixOfMarbles2;

    private ResourceMarket(){

        List<Marble> tmp=new ArrayList<>();

        for (int k = 0; k< NumberOfMarble.NUM_OF_BLUE.value; k++) tmp.add(new MarbleBlue());
        for (int k=0;k<NumberOfMarble.NUM_OF_WHITE.value;k++) tmp.add(new MarbleWhite());
        for (int k=0;k<NumberOfMarble.NUM_OF_GREY.value;k++) tmp.add(new MarbleGrey());
        for (int k=0;k<NumberOfMarble.NUM_OF_YELLOW.value;k++) tmp.add(new MarbleYellow());
        for (int k=0;k<NumberOfMarble.NUM_OF_PURPLE.value;k++) tmp.add(new MarblePurple());
        for (int k=0;k<NumberOfMarble.NUM_OF_RED.value;k++) tmp.add(new MarbleRed());


        int total=0;
        for(NumberOfMarble x: NumberOfMarble.values()) total+=x.value;

        arrayOfMarbles=new Marble[total];
        int added=0;
        for (int k=0;k<NumberOfMarble.NUM_OF_BLUE.value;k++) {arrayOfMarbles[k+added]=new MarbleBlue();}
        added+=NumberOfMarble.NUM_OF_BLUE.value;
        for (int k=0;k<NumberOfMarble.NUM_OF_WHITE.value;k++) {arrayOfMarbles[k+added]=new MarbleWhite();}
        added+=NumberOfMarble.NUM_OF_WHITE.value;
        for (int k=0;k<NumberOfMarble.NUM_OF_GREY.value;k++) {arrayOfMarbles[k+added]=new MarbleGrey();}
        added+=NumberOfMarble.NUM_OF_GREY.value;
        for (int k=0;k<NumberOfMarble.NUM_OF_YELLOW.value;k++) {arrayOfMarbles[k+added]=new MarbleYellow();}
        added+=NumberOfMarble.NUM_OF_YELLOW.value;
        for (int k=0;k<NumberOfMarble.NUM_OF_PURPLE.value;k++) {arrayOfMarbles[k+added]=new MarblePurple();}
        added+=NumberOfMarble.NUM_OF_PURPLE.value;
        for (int k=0;k<NumberOfMarble.NUM_OF_RED.value;k++) {arrayOfMarbles[k+added]=new MarbleRed();}

        Utility.shuffle(arrayOfMarbles);


        matrixOfMarbles = new Marble[MatrixRowColumn.NUM_OF_ROW.value][MatrixRowColumn.NUM_OF_COLUMN.value];
        for(int i=0;i<MatrixRowColumn.NUM_OF_ROW.value;i++)
            for(int j=0;j<MatrixRowColumn.NUM_OF_COLUMN.value;j++)
                matrixOfMarbles[i][j]=tmp.get(i* MatrixRowColumn.NUM_OF_COLUMN.value+j);

        matrixOfMarbles2 = new Marble[MatrixRowColumn.NUM_OF_ROW.value][MatrixRowColumn.NUM_OF_COLUMN.value];
        for (int k=0;k<arrayOfMarbles.length-1;k++) {
            // System.out.println(k / MatrixRowColumn.NUM_OF_COLUMN.value+"    "+ k % MatrixRowColumn.NUM_OF_COLUMN.value);


            matrixOfMarbles2[k / MatrixRowColumn.NUM_OF_COLUMN.value][k % MatrixRowColumn.NUM_OF_COLUMN.value] = arrayOfMarbles[k];
        }
        freeMarble=arrayOfMarbles[arrayOfMarbles.length-1];
    }

    /**
     *
     * @return a singleton instance of the unique Market
     */
    public static ResourceMarket getInstance(){
        if(resourceMarket==null)  resourceMarket=new ResourceMarket();
        return resourceMarket;
    }

    /**
     *
     * @return a deep copy of intial arrays of marbles
     */
    public Marble[] getArrayOfMarbles() {
        Marble[] tmp= new Marble[arrayOfMarbles.length];
        //requires a deep copy of arraysMarbles not arraysofMarble

        return tmp;
    }
    public Marble[][] getMatrixOfMarblesOfMarbles() {
        Marble[][] tmpMatrix=new Marble[matrixOfMarbles.length][matrixOfMarbles[0].length];
        for (int i=0;i<matrixOfMarbles.length;i++)
            for (int j=0;j<matrixOfMarbles[0].length;j++) tmpMatrix[i][j]=matrixOfMarbles[i][j].copy();
        return matrixOfMarbles;
    }

    /**
     *
     * @return a copy of the free marble
     */
    public Marble getfreeMarble(){
        return freeMarble.copy();

}

    /**
     *
     * @param row to inquiry the state of the market before push
     * @return row state of the market before push
     */
    Marble[] getRow(int row) {
        /*  extract row */
        Marble[] tmp=new Marble[MatrixRowColumn.NUM_OF_COLUMN.value];
        for (int k=0;k<MatrixRowColumn.NUM_OF_COLUMN.value;k++)
            tmp[k]=matrixOfMarbles2[row-1][k].copy();
        return tmp;


    }

    /**
     *
     * @param row row to be pushed
     */

     void pushRow(int row){

        Marble tmp=freeMarble;
        freeMarble=matrixOfMarbles2[row-1][0];
        for (int k=0;k<MatrixRowColumn.NUM_OF_COLUMN.value-1;k++) matrixOfMarbles2[row-1][k]=matrixOfMarbles2[row-1][k+1];
        matrixOfMarbles2[row-1][MatrixRowColumn.NUM_OF_COLUMN.value-1]=tmp;

    }

    /**
     *
     * @param column
     * @return
     */
    Marble[] getcolumn(int column){
/*
  extract column */
        Marble[] tmp=new Marble[MatrixRowColumn.NUM_OF_ROW.value];

        for (int k=0;k<MatrixRowColumn.NUM_OF_ROW.value;k++)
            tmp[k]=matrixOfMarbles2[k][column-1].copy();
        return tmp;
    }

    /**
     * 
     * @param column
     */
    void pushColumn(int column){


        Marble tmp=freeMarble;
        freeMarble=matrixOfMarbles2[0][column-1];
        for (int k=0;k<MatrixRowColumn.NUM_OF_ROW.value-1;k++) matrixOfMarbles2[k][column-1]=matrixOfMarbles2[k+1][column-1];
        matrixOfMarbles2[MatrixRowColumn.NUM_OF_ROW.value-1][column-1]=tmp;



    }
    Marble extractMarble(){return  new MarbleBlue() {
        @Override
        public void doAction() {

        }
    };}
    /*
    List<FaithResource> getRow(int row, List<Card> leaderCard){return new ArrayList<>();}
    List<FaithResource> getColumn(int column, List<Card> leaderCard){return new ArrayList<>();}
    private void applyBonus(){}
*/


}