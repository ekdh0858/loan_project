package com.fastcampus.loan.controller;

import com.fastcampus.loan.dto.ResponseDTO;
import com.fastcampus.loan.dto.ResultObject;

public abstract class AbstractController {
  // 요청에 대한 응답값을 통일화 하기 위해서 만들어 놓은 클래스

  protected <T> ResponseDTO<T> ok() {
    return ok(null, ResultObject.getSuccess());
  }

  protected <T> ResponseDTO<T> ok(T data) {
    return ok(data, ResultObject.getSuccess());
  }

  protected <T> ResponseDTO<T> ok(T data, ResultObject result) {
    ResponseDTO<T> obj = new ResponseDTO<>();
    obj.setResult(result);
    obj.setData(data);

    return obj;
  }
}
