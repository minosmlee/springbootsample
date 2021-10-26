package smlee.springbootsample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import smlee.springbootsample.domain.SampleDomain;

// Spring Data JPA는 기본적으로 JpaRepository<> 를 extends 해야한다. 그리고 원하는 Repository interface를 추가호 extends한다.
public interface SampleJpaRepository extends JpaRepository<SampleDomain, Long>, SampleRepository {
    
    @Override
    Optional<SampleDomain> findByAttr(String attr);
}
