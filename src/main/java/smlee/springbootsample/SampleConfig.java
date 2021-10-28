package smlee.springbootsample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import smlee.springbootsample.repository.SampleJpaRepository;
import smlee.springbootsample.repository.SampleMemoryRepository;
import smlee.springbootsample.repository.SampleRepository;
import smlee.springbootsample.repository.SampleSpringDataJpaRepository;

@RequiredArgsConstructor
@Configuration // Bean을 직접 등록하려면 @Configuration어노테이션 클래스 하위에 @Bean 어노테이션 메소드 하위에 객체를 생성하여 리턴한다.
public class SampleConfig {

    // 다양한 타입의 Repository는 @Repository를 이용해 미리 Bean으로 생성하고 여기서 주입받는다.
    // private final SampleMemoryRepository memoryRepository;
    // private final SampleJpaRepository jpaRepository;
    private final SampleSpringDataJpaRepository springDataRepository;

    // @Bean을 이용한 직접 생성.
    // 여러가지 타입의 Repository를 사용하기 위해 SampleRepository를 인터페이스로 정의하고 이를 다양한 타입으로 구현한다.
    // Bean 생성 과정에서 원하는 타입의 Repository를 리턴하면 다른 코드를 수정할 필요 없이 Repository 교체가 가능하다.
    @Bean
    public SampleRepository repository() {
        // return memoryRepository;
        // return jpaRepository;
        return springDataRepository;
    }
}
