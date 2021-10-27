package smlee.springbootsample;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import smlee.springbootsample.repository.SampleJpaRepository;
import smlee.springbootsample.repository.SampleMemoryRepository;
//import smlee.springbootsample.repository.SampleMemoryRepository;
//import smlee.springbootsample.repository.SampleRepository;
//import smlee.springbootsample.service.SampleService;
import smlee.springbootsample.repository.SampleRepository;

@RequiredArgsConstructor
@Configuration // Bean을 직접 등록하려면 @Configuration어노테이션 클래스 하위에 @Bean 어노테이션 메소드 하위에 객체를 생성하여 리턴한다.
public class SampleConfig {

    // 아래의 코드들이 service, repository 객체를 직접 bean으로 등록하는 과정이다.
    // @Service, @Repository와 중복하지 않도록 조심한다.

    private final SampleMemoryRepository memoryRepository;
    private final SampleJpaRepository jpaRepository;

    @Bean
    public SampleRepository repository() {
        SampleRepository repository;

        // repository = memoryRepository;
        repository = jpaRepository;

        return repository;
    }
}
