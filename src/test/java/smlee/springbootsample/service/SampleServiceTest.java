package smlee.springbootsample.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import smlee.springbootsample.domain.SampleDomain;

class SampleServiceTest {

    SampleService service = new SampleService();

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
