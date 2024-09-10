package com.fastcampus.loan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.fastcampus.loan.domain.Counsel;
import com.fastcampus.loan.dto.CounselDTO;
import com.fastcampus.loan.dto.CounselDTO.Request;
import com.fastcampus.loan.dto.CounselDTO.Response;
import com.fastcampus.loan.repository.CounselRepository;
import com.fastcampus.loan.service.CounselService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
// Counsel 클래스 외의 영역에서는 모두 성공을 했다는 가정 하에 작성된 테스트
public class CounselServiceTest {

    @InjectMocks
    private CounselService counselService;

    @Mock
    private CounselRepository counselRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void Should_ReturnResponseOfNewCounselEntity_When_RequestCounsel(){
        Counsel entity =Counsel.builder()
                .name("Member Kim")
                .cellPhone("010-1111-2222")
                .email("kim@gmail.com")
                .memo("저는 대출을 받고 싶어요. 연락주세요")
                .zipCode("12345")
                .address("부산광역시 부산진구 어디동")
                .addressDetail("111동 111호")
                .build();

        Request request = Request.builder()
                .name("Member Kim")
                .cellPhone("010-1111-2222")
                .email("kim@gmail.com")
                .memo("저는 대출을 받고 싶어요. 연락주세요")
                .zipCode("12345")
                .address("부산광역시 부산진구 어디동")
                .build();

        when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);

        Response actual = counselService.create(request);

        assertThat(actual.getName()).isSameAs(entity.getName());
    }
}
