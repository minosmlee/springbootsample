package smlee.springbootsample.repository;

import static org.assertj.core.api.Assertions.assertThat; // assertThat을 static import 하여 바로 assertThat()을 사용가능

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import smlee.springbootsample.domain.SampleDomain;

@SpringBootTest
@Transactional // @Transactional은 기본으로 @Test에 대해서 Rollback을 수행한다.
class SampleJpaRepositoryTest {

    @Autowired
    SampleJpaRepository repository;

    @Test
    // @Commit // @Commit은 Rollback을 수행하지 않고 DB에 기록한다.
    public void save() {
        SampleDomain domain = new SampleDomain();
        domain.setAttr("test attr");
        repository.save(domain);

        // Optional 객체가 반환될때 .get()을 붙이면 null이 아닌경우 그값을 가져오고, null 인경우 예외를 반환한다.
        SampleDomain result = repository.findById(domain.getId()).get();
        assertThat(domain).isEqualTo(result);
    }

    @Test
    public void findByAttr() {
        SampleDomain domain1 = new SampleDomain();
        domain1.setAttr("test attr1");
        repository.save(domain1);

        SampleDomain domain2 = new SampleDomain();
        domain2.setAttr("test attr2");
        repository.save(domain2);

        // entity1의 attr로 찾은 객체가 entity2와 다른것을 점검
        SampleDomain result = repository.findByAttr(domain1.getAttr()).get();
        assertThat(domain2).isNotEqualTo(result);
    }
}
