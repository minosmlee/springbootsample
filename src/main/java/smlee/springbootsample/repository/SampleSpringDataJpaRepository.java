package smlee.springbootsample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import smlee.springbootsample.domain.SampleDomain;

public interface SampleSpringDataJpaRepository extends JpaRepository<SampleDomain, Long>, SampleRepository {

    @Override
    Optional<SampleDomain> findByAttr(String attr);
}
