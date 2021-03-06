package smlee.springbootsample.repository;

import static org.assertj.core.api.Assertions.assertThat; // assertThat을 static import 하여 바로 assertThat()을 사용가능

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import smlee.springbootsample.domain.SampleDomain;

@SpringBootTest
@Transactional
class SampleMemoryRepositoryTest {

    @Autowired
    SampleMemoryRepository repository;

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        String attr = "test attr";
        SampleDomain domain = SampleDomain.builder().attr(attr).build();
        repository.save(domain);

        SampleDomain result = repository.findById(domain.getId()).get(); // Optional 객체가 반환될때 .get()을 붙이면 null이 아닌경우 그
                                                                         // 값을 가져오고, null 인경우 예외를 반환한다.
        assertThat(domain).isEqualTo(result);
    }

    @Test
    public void findByAttr() {
        String attr1 = "test attr 1";
        SampleDomain domain1 = SampleDomain.builder().attr(attr1).build();
        repository.save(domain1);

        String attr2 = "test attr 2";
        SampleDomain domain2 = SampleDomain.builder().attr(attr2).build();
        repository.save(domain2);

        // domain1의 attr로 찾은 객체가 domain2와 다른것을 점검
        SampleDomain result = repository.findByAttr(domain1.getAttr()).get();
        assertThat(domain2).isNotEqualTo(result);
    }
}
