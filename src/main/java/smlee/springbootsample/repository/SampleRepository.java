package smlee.springbootsample.repository;

import java.util.List;
import java.util.Optional;

import smlee.springbootsample.domain.SampleDomain;

public interface SampleRepository {
    public SampleDomain save(SampleDomain domain);

    public Optional<SampleDomain> findById(Long id);

    public Optional<SampleDomain> findByAttr(String attr);

    public List<SampleDomain> findAll();
}
