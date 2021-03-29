package org.example;

import java.util.SplittableRandom;

public class Utility {


  public static void swap(Object[] x, int i1, int i2){
    Object tmp=x[i1];
    x[i1]=x[i2];
    x[i2]=tmp;

  }

  /**
   * Fisher-Yates shuffle modified by Knuth
   * @param objects
   */
  public static void shuffle(Object[]  objects){

    SplittableRandom random = new SplittableRandom();
    int temp;
    int num= objects.length;
    for(int k=0;k<num;k++) {
      temp = random.nextInt(k + 1);
      swap(objects, k, temp);
    }
  }
}
