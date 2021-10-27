package smlee.springbootsample.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import smlee.springbootsample.domain.SampleDomain;

@RequiredArgsConstructor
@Repository
public class SampleJpaRepository implements SampleRepository {

    // spring-boot-starter-data-jpa를 dependency 추가하면
    // EntityManager를 자동으로 Bean으로 추가한다. 이를 주입받는다.
    private final EntityManager em;

    @Override
    public SampleDomain save(SampleDomain domain) {
        em.persist(domain);
        return domain;
    }

    @Override
    public Optional<SampleDomain> findById(Long id) {
        SampleDomain domain = em.find(SampleDomain.class, id);
        return Optional.ofNullable(domain);
    }

    @Override
    public Optional<SampleDomain> findByAttr(String attr) {
        return em.createQuery("select d from SampleDomain as d where d.attr = :attr", SampleDomain.class)
                .setParameter("attr", attr).getResultList().stream().findAny();
    }

    @Override
    public List<SampleDomain> findAll() {
        return em.createQuery("select d from SampleDomain d", SampleDomain.class).getResultList();
    }

    public void clearEm() {
        em.clear();
    }
}
