package com.wfwsds.adapter;

import com.wfwsds.model.ExternalDataRes;
import com.wfwsds.model.UserRes;
import org.springframework.stereotype.Service;

@Service("UserResAdapter")
public class UserResAdapter implements ExternalDataResAdapter {

  public ExternalDataRes postProcess(ExternalDataRes res) {

    UserRes in = (UserRes) res;
    if (in.getErrors() != null && in.getErrors().isError()) {
      return in;
    }

    // TODO: any filtering, postprocessing
    return new UserRes(in.getUserId(), in.getFirstName().toUpperCase(),
        in.getLastName().toUpperCase());
  }
}
