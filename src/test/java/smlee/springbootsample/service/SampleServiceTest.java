package smlee.springbootsample.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import smlee.springbootsample.domain.SampleDomain;
import smlee.springbootsample.repository.SampleRepository;

@SpringBootTest
@Transactional
class SampleServiceTest {

    @Autowired
    SampleRepository repository;

    @Autowired
    SampleService service;

    @AfterEach
    public void afterEach() {

    }

    @Test
    public void validateDuplicationOnSave() {
        SampleDomain domain = new SampleDomain();
        domain.setAttr("test attr");

        Long savedId = service.validateDuplicationOnSave(domain);

        SampleDomain foundDomain = service.findDomainById(savedId).get();
        assertThat(domain.getAttr()).isEqualTo(foundDomain.getAttr());
    }

    @Test
    public void findAllDomains() {

    }

    @Test
    public void findDomainById() {

    }
}
