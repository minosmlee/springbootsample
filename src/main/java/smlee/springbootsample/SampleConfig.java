package smlee.springbootsample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import smlee.springbootsample.repository.SampleMemoryRepository;
import smlee.springbootsample.service.SampleService;

@Configuration // Bean을 직접 등록하려면 @Configuration어노테이션 클래스 하위에 @Bean 어노테이션 메소드 하위에 객체를 생성하여 리턴한다.
public class SampleConfig {

    // 아래의 코드들이 service, repository 객체를 직접 bean으로 등록하는 과정이다.
    // @Service, @Repository와 중복하지 않도록 조심한다.

    // @Bean
    // public SampleService service() {
    //      return new SampleService(repository());
    // }

    // @Bean
    // public SampleMemoryRepository repository() {
    //      return new SampleMemoryRepository();
    // }

}
