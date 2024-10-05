package com.fastcampus.loan.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BalanceDTO implements Serializable {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class Request{
        private Long applicationID;
        private BigDecimal entryAmount;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class UpdateRequest{
        private Long applicationID;
        private BigDecimal beforeEntryAmount;
        private BigDecimal afterEntryAmount;
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    public static class RepaymentRequest{

        public enum RepaymentType{
            ADD,
            REMOVE
        }
        private RepaymentType type;

        private BigDecimal repaymentAmount;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class Response{
        private Long balanceId;
        private Long applicationId;
        private BigDecimal balance;
//        private LocalDateTime createdAt;
//        private java.time.LocalDateTime updatedAt;
    }
}
