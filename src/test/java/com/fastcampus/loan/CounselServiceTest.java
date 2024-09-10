package com.fastcampus.loan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.fastcampus.loan.domain.Counsel;
import com.fastcampus.loan.dto.CounselDTO;
import com.fastcampus.loan.dto.CounselDTO.Request;
import com.fastcampus.loan.dto.CounselDTO.Response;
import com.fastcampus.loan.exception.BaseException;
import com.fastcampus.loan.exception.ResultType;
import com.fastcampus.loan.repository.CounselRepository;
import com.fastcampus.loan.service.CounselService;
import com.fastcampus.loan.service.CounselServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
// Counsel 클래스 외의 영역에서는 모두 성공을 했다는 가정 하에 작성된 테스트
public class CounselServiceTest {

    @InjectMocks
    private CounselServiceImpl counselService;

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

    @Test
    void should_ReturnResponseOfExistCounselEntity_When_RequestExistCounselId(){
        Long findId = 1L;

        Counsel entity = Counsel.builder()
                .counselId(findId)
                .build();

        when(counselRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

        Response actual = counselService.get(1L);

        assertThat(actual.getCounselId()).isSameAs(findId);
    }

    @Test
    void should_ThrowException_When_RequestNotExistCounselId(){
        Long findId = 2L;

        when(counselRepository.findById(findId)).thenThrow(new BaseException(ResultType.SYSTEM_ERROR));

        Assertions.assertThrows(BaseException.class,()->counselService.get(findId));
    }

    @Test
    void Should_ReturnUpdatedResponseOfExistCounselEntity_When_RequestUpdateExistCounselInfo(){
        Long findId = 1L;

        Counsel entity = Counsel.builder()
                .counselId(1L)
                .name("Member Kim")
                .build();

        Request request = Request.builder()
                .name("Member Kang")
                .build();

        when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);
        when(counselRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

        Response actual = counselService.update(findId,request);

        assertThat(actual.getCounselId()).isEqualTo(findId);
        assertThat(actual.getName()).isSameAs(request.getName());
    }
}
