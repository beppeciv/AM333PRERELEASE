package org.example.warehouse;


public class Depo {
    private MarketResource[][] depoState;
    public Depo(){
        // k levels number in depo
        // 3 levels number in depo
        depoState=new MarketResource[3][];

        for(int k=1;k<=3;k++) depoState[k-1]=new MarketResource[k];

    }

    public MarketResource[] getrowState(int row) throws Exception{
        if(row<1 || row >3 ) throw new Exception();

        MarketResource[] tmp = new MarketResource[row];
        for (int k=0;k<row;k++) tmp[k]=depoState[row-1][k];
        return tmp;
    }

    /**
     *
     * @param row1 slot to be swapped with row2
     * @param row2 slot to be swapped with row1
     * @return true if swap is can be apply iff the elements in row1 can be store in row1 and the elements in row 2 can be stored in row1 (that is there is enough space)
     */
    public boolean swap(int row1 , int row2){
        int countnotnullinrow1=0;
        int countnotnullinrow2=0;
        for(int k=0;k<row1;k++) if(depoState[row1-1][k]!=null) countnotnullinrow1++;
        for(int k=0;k<row2;k++) if(depoState[row2-1][k]!=null) countnotnullinrow2++;

        if(countnotnullinrow1<=row2 && countnotnullinrow2<=row1)
        {
            MarketResource[] copyOne=new MarketResource[countnotnullinrow1];
            MarketResource[] copyTwo=new MarketResource[countnotnullinrow2];
            for (int k=0;k<countnotnullinrow1;k++) copyOne[k]=depoState[row1-1][k];
            for (int k=0;k<countnotnullinrow2;k++) copyTwo[k]=depoState[row2-1][k];
            for (int k=0;k<row1;k++) depoState[row1-1][k]=null;
            for (int k=0;k<row2;k++) depoState[row2-1][k]=null;
            for (int k=0;k<countnotnullinrow1;k++) depoState[row2-1][k]=copyOne[k];
            for (int k=0;k<countnotnullinrow1;k++) depoState[row1-1][k]=copyTwo[k];
            return true;
        }

        return false;
    }

    /**
     *
     * @param marketResource resource type to be added
     * @param quantity resource quantity type to be added
     * @param row slot depo in wich are stored resources
     * @return -1 if it is not possible to add any resource 0 to quantity -1  the number or discard resources
     * internal state is modified iff is returned >=0
     */
    public int add(MarketResource marketResource,int quantity,int row) /*throws Exception*/{

        // two condition
        // I marketResource is in the other 2 return -1 doing nothing
        // II marketResource is not the same in row return -1 doing nothing
        // there is enough space in the current row
        int quantiyNotAdded=quantity;
        for (int k=0;k<3  ;k++){
            if( k!=row-1){
            for (int j=0;j<k;j++)
                if (depoState[k][j]==marketResource) return -1;}}

        // II marketResource is not the same in row return -1 doing nothing
        for (int k=0;k<row;k++) if(depoState[row-1][k]!=marketResource && depoState[row-1][k]!= null) return -1 ;

        for (int k=0;k<row && quantiyNotAdded>0;k++) if(depoState[row-1][k]==null) {depoState[row-1][k]=marketResource;quantiyNotAdded--;}
        /*
        if(quantity<-2 || quantity >3) throw new Exception();
        */
        return quantiyNotAdded;

    }

    /**
     *
     * @param marketResource resource type to be added
     * @param quantity resource quantity type to be added
     * @return -1 if it is not possible to remove any resource 0 to quantity -1  the quantity not removed
     */
    public int remove(MarketResource marketResource,int quantity){
        int numberofoccurreniesinrow=-1;
        int quantityavailable=0;
        for (int k=0;k<3;k++) {
            for (int j = 0; j <= k; j++)
                if (depoState[k][j] == marketResource) {
                    quantityavailable++;
                    numberofoccurreniesinrow = k;
                }
        }
        if (quantityavailable==0 || numberofoccurreniesinrow<0 )  return -1;

        // in this case exists at least one resource
        for (int k=0;k<=numberofoccurreniesinrow;k++) depoState[numberofoccurreniesinrow][k]=null;

        // There are enough resources
        if(quantityavailable>quantity) {
            for (int k = 0; k <= quantityavailable - quantity; k++) depoState[numberofoccurreniesinrow][k] = marketResource;
        return 0;
        }
        // there are resources but not enough
    return quantity-quantityavailable;
    }
}
