package smlee.springbootsample.repository;

import java.util.List;
import java.util.Optional;

import smlee.springbootsample.domain.SampleDomain;

public interface SampleRepository {
    SampleDomain save(SampleDomain domain);

    Optional<SampleDomain> findById(Long id);

    Optional<SampleDomain> findByAttr(String attr);

    List<SampleDomain> findAll();
}
