package com.fastcampus.loan.service;

import com.fastcampus.loan.dto.CounselDTO.Request;
import com.fastcampus.loan.dto.CounselDTO.Response;

public interface CounselService {
    Response create(Request request);
    // 상담을 등록할 메서드 어떠한 식으로 요청을 받을지, 응답을 줄지는 dto
}
