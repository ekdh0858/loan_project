package com.fastcampus.loan.service;

import com.fastcampus.loan.dto.CounselDTO.Request;
import com.fastcampus.loan.dto.CounselDTO.Response;

public interface CounselService {
    Response create(Request request);
    Response get(long counselId);
    Response update(long counselId, Request request);
    void delete(long counselId);
}
