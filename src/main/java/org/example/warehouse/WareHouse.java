package org.example.warehouse;

//import jdk.internal.loader.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.example.warehouse.MarketResource.*;

public class WareHouse {
    /**
     * these three arrays respectively refer to each warehouse's
     * deposit (each depo has a fixed size)
     */
    /* I do not agree with choice to create three different variable instead of staggered array tha reduce nummer of  for cycles

     */
    private MarketResource[] firstDeposit;
    private MarketResource[] secondDeposit;
    private MarketResource[] thirdDeposit;

    /**
     * instantiate default to null all slots
     */
    public WareHouse() {
        firstDeposit = new MarketResource[1];
        secondDeposit = new MarketResource[2];
        thirdDeposit = new MarketResource[3];
    }

    /**
     * @param marketResource a copy to be made
     * @return copy of a single slot
     */
    private MarketResource copy(MarketResource marketResource) throws Exception {
        /* WARNING if you change MarkerResource you will break this method*/
        switch (marketResource) {
            case COIN:
                return COIN;
            case STONE:
                return STONE;
            case SERVANT:
                return SERVANT;
            case SHIELD:
                return SHIELD;
            default:
                return null;
        }
    }

    /**
     * @return a copy of all the resources in the warehouse
     */
    // method implementation to finish
    public List<MarketResource> getAllResources() {
        List<MarketResource> tmp = new ArrayList<>();
        MarketResource tmpResource;//=new MarketResource();
        for (int k = 0; k < firstDeposit.length; k++)
            if (firstDeposit[k] != null) {
                try {
                    tmp.add(copy(firstDeposit[k]));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        for (int k = 0; k < secondDeposit.length; k++)
            if (firstDeposit[k] != null) {
                try {
                    tmp.add(copy(secondDeposit[k]));
                } catch (Exception e) {
                    e.printStackTrace();
              }
            }
        for (int k = 0; k < thirdDeposit.length; k++)
            if (firstDeposit[k] != null) {
                try {
                    tmp.add(copy(secondDeposit[k]));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        return tmp;
    }

    /**
     * @return true if the resource's already in the warehouse
     */
    // method implementation to finish
    private boolean isResourceHere(MarketResource resource) {
        for (int k = 0; k < firstDeposit.length; k++)
            if (firstDeposit[k] != null && firstDeposit[k]==resource)
            return true;
        for (int k = 0; k < secondDeposit.length; k++)
            if (secondDeposit[k] != null && secondDeposit[k]==resource)
                return true;
        for (int k = 0; k < thirdDeposit.length; k++)
            if (thirdDeposit[k] != null && thirdDeposit[k]==resource)
                return true;

        return false;
    }

    /** @return true if a deposit's empty */
    // method implementation to finish
    private boolean isRowEmpty(int row) throws Exception {
        if (row>2 || row<0) throw new Exception();
        MarketResource[] tmp=null;
        switch (row) {
            case 0:
                tmp = firstDeposit;
                break;
            case 1:
                tmp = secondDeposit;
                break;
            case 2:
                tmp = thirdDeposit;
                break;
        }
        for (int k = 0; k < tmp.length; k++)
            if (tmp[k] != null) return false;
                return true;
    }
    /** @return true if a deposit's full */
    // method implementation to finish
    private boolean isRowFull(int row) throws Exception {
        if (row>2 || row<0) throw new Exception();
        MarketResource[] tmp=null;
        switch (row) {
            case 0:
                tmp = firstDeposit;
                break;
            case 1:
                tmp = secondDeposit;
                break;
            case 2:
                tmp = thirdDeposit;
                break;
        }
        for (int k = 0; k < tmp.length; k++)
            if (tmp[k] == null) return false;
        return true;
    }

    // method implementation to finish

    private boolean freeDeposit(int row) throws Exception {
        if (row > 2 || row < 0) throw new Exception();
        MarketResource[] tmp = null;
        switch (row) {
            case 0:
                tmp = firstDeposit;
                break;
            case 1:
                tmp = secondDeposit;
                break;
            case 2:
                tmp = thirdDeposit;
                break;
        }

        for (int k = 0; k < tmp.length; k++)
            tmp[k] = null;

                return true;
    }
    // method implementation to finish
    private int getResourceRow(MarketResource resource){

        for (int k = 0; k < firstDeposit.length; k++)
            if (firstDeposit[k] != null && firstDeposit[k]==resource)
                return 0;
        for (int k = 0; k < secondDeposit.length; k++)
            if (secondDeposit[k] != null && secondDeposit[k]==resource)
                return 1;
        for (int k = 0; k < thirdDeposit.length; k++)
            if (thirdDeposit[k] != null && thirdDeposit[k]==resource)
                return 2;

        return -1;
    }
    // method implementation to finish
    private boolean eliminateFromDeposit(int row){
        return true;
    }

    /** getResourcesFromDeposit is used to get a certain number of resources from one of the three deposits
     *
     * @param row refers to the row of the deposit to fetch
     * @param quantity refers to the number of resources to fetch
     * @return the list of fetched resources
     */
    // method implementation to finish
    public List<MarketResource> getResourcesFromDeposit(int row, int quantity){

        return null;
    }


    /** @return true if the resource can be added */
    // method implementation to finish
    private boolean resourceCanBeAdded(MarketResource resource){
        return false;
    }

    /** @return true if the resource's succesfully added to a deposit */
    // method implementation to finish
    public boolean addResource(int row, MarketResource resource){

        return false;
    }
}

