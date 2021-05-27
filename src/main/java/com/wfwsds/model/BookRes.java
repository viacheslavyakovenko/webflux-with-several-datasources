package com.wfwsds.model;

public class BookRes implements ExternalDataRes {

  private Integer bookId;
  private String authorName;
  private String title;

  public BookRes() {
    super();
  }

  public BookRes(Integer bookId, String authorName, String title) {
    this.bookId = bookId;
    this.authorName = authorName;
    this.title = title;
  }

  public Integer getBookId() {
    return bookId;
  }

  public String getAuthorName() {
    return authorName;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public String toString() {
    return "BookRes{" +
        "bookId=" + bookId +
        ", authorName='" + authorName + '\'' +
        ", title='" + title + '\'' +
        '}';
  }

}
