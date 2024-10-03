package com.fastcampus.loan.service;

import com.fastcampus.loan.dto.BalanceDTO;
import org.springframework.stereotype.Service;

@Service
public interface BalanceService {
    BalanceDTO.Response create(Long applicationId, BalanceDTO.Request request);
    BalanceDTO.Response update(Long applicationId, BalanceDTO.UpdateRequest request);
}
