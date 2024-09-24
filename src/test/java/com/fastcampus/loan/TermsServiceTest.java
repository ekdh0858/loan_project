package com.fastcampus.loan;

import com.fastcampus.loan.domain.Terms;
import com.fastcampus.loan.dto.TermsDTO;
import com.fastcampus.loan.repository.TermsRepository;
import com.fastcampus.loan.service.TermsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TermsServiceTest {

    @InjectMocks
    TermsServiceImpl termsService;

    @Mock
    private TermsRepository termsRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void Should_ReturnResponseOfNewTermsEntity_When_RequestTerms(){
        Terms entity = Terms.builder()
                .name("대출 이용 약관")
                .termsDetailUrl("http://abc-storage.acc/djlksadjsladsa")
                .build();

        TermsDTO.Request request = TermsDTO.Request.builder()
                .name("대출 이용 약관")
                .termsDetailUrl("http://abc-storage.acc/djlksadjsladsa")
                .build();

        when(termsRepository.save(ArgumentMatchers.any(Terms.class))).thenReturn(entity);

        TermsDTO.Response actual = termsService.create(request);

        assertThat(actual.getName()).isSameAs(entity.getName());
        assertThat(actual.getTermsDetailUrl()).isSameAs(entity.getTermsDetailUrl());
    }

}
