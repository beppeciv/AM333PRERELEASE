package org.example;

public enum MatrixRowColumn {
  NUM_OF_ROW(3),
  NUM_OF_COLUMN(4);
  public final int value;
  private MatrixRowColumn( int value) {
    this.value = value;
  }
}
