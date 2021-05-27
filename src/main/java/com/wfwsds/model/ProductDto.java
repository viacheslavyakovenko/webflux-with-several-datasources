package com.wfwsds.model;

public class ProductDto {

  private final StringBuilder data = new StringBuilder();

  public void concat(String s) {
    data.append(s);
  }

  @Override
  public String toString() {

    return "ProductDto{" +
        "data=" + data.toString() +
        '}';
  }
}
