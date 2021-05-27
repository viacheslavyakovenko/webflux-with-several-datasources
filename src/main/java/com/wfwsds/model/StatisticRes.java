package com.wfwsds.model;

public class StatisticRes implements ExternalDataRes {

  private Integer bookId;
  private Integer count;

  public StatisticRes() {
    super();
  }

  public StatisticRes(Integer bookId, Integer count) {
    this.bookId = bookId;
    this.count = count;
  }

  public Integer getBookId() {
    return bookId;
  }

  public Integer getCount() {
    return count;
  }

  @Override
  public String toString() {
    return "StatisticRes{" +
        "bookId=" + bookId +
        ", count=" + count +
        '}';
  }
}

