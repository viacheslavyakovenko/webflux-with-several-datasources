package com.wfwsds.model;

public class StatisticRes implements ExternalDataRes {

  public static final StatisticRes STATISTIC_RES_ERROR
      = new StatisticRes(Errors.DEFAULT);

  private Integer bookId;
  private Integer count;
  private Errors errors;

  public StatisticRes() {
    super();
  }

  public StatisticRes(Integer bookId, Integer count) {
    this.bookId = bookId;
    this.count = count;
  }

  public StatisticRes(Errors errors) {
    this.errors = errors;
  }

  public Integer getBookId() {
    return bookId;
  }

  public Integer getCount() {
    return count;
  }

  public Errors getErrors() {
    return errors;
  }

  @Override
  public String toString() {

    if (this.errors != null && this.errors.isError()) {
      return "StatisticRes{"
          + this.errors + "}";
    }

    return "StatisticRes{" +
        "bookId=" + bookId +
        ", count=" + count +
        '}';
  }
}

