package org.example;

public enum NumberOfMarble {

    NUM_OF_WHITE(4),
    NUM_OF_BLUE(2),
    NUM_OF_GREY(2),
    NUM_OF_YELLOW(2),
    NUM_OF_PURPLE(2),
    NUM_OF_RED(1);
  public final int value;
    private NumberOfMarble( int value) {
      this.value = value;
    }
 }

