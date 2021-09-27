package com.wfwsds.model;

public class BookRes implements ExternalDataRes {

  public static final BookRes BOOK_RES_ERROR
      = new BookRes(Errors.DEFAULT);

  private Integer bookId;
  private String authorName;
  private String title;
  private Errors errors;

  public BookRes() {
    super();
  }

  public BookRes(Integer bookId, String authorName, String title) {
    this.bookId = bookId;
    this.authorName = authorName;
    this.title = title;
    this.errors = null;
  }

  public BookRes(Errors error) {
    this.errors = error;
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

  public Errors getErrors() {
    return errors;
  }

  @Override
  public String toString() {

    if (this.errors != null && this.errors.isError()) {
      return "BookRes{"
          + this.errors + "}";
    }

    return "BookRes{" +
        "bookId=" + bookId +
        ", authorName='" + authorName + '\'' +
        ", title='" + title + '\'' +
        '}';
  }

}
