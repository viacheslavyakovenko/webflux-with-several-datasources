package com.wfwsds.adapter;

import com.wfwsds.model.BookRes;
import com.wfwsds.model.ExternalDataRes;
import org.springframework.stereotype.Service;

@Service("BookResAdapter")
public class BookResAdapter implements ExternalDataResAdapter {

  public ExternalDataRes postProcess(ExternalDataRes res) {

    BookRes in = (BookRes) res;
    if (in.getErrors() != null && in.getErrors().isError()){
      return in;
    }

    // TODO: any filtering, postprocessing
    return new BookRes(in.getBookId(), in.getAuthorName().toUpperCase(),
        in.getTitle().toUpperCase());
  }
}
