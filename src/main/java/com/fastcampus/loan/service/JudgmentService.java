package com.fastcampus.loan.service;


import com.fastcampus.loan.dto.ApplicationDTO;
import com.fastcampus.loan.dto.JudgmentDTO;

public interface JudgmentService {
    JudgmentDTO.Response create(JudgmentDTO.Request request );
    JudgmentDTO.Response get(Long judgmentId);
    JudgmentDTO.Response getJudgmentOfApplicationId(Long applicationId);
    JudgmentDTO.Response update(Long judgmentId, JudgmentDTO.Request request);
    JudgmentDTO.Response delete(Long judgmentId);
    ApplicationDTO.GrantAmount grant(Long judgmentId);
}
