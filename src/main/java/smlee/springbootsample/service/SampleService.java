package smlee.springbootsample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import smlee.springbootsample.domain.SampleDomain;
import smlee.springbootsample.repository.SampleMemoryRepository;

@Service
// @RequiredArgsConstructor // 모든 final이 선언된 모든 필드에 대해 생성자 주입방식의 Bean 주입을 대신해준다.
// @AutoWired를 사용할 필요가없다.
public class SampleService {

    private final SampleMemoryRepository repository = new SampleMemoryRepository();

    public Long validateDuplicationOnSave(SampleDomain domain) {

        // 중복된 attr을 가진 domain이 저장되는것을 방지하는 로직
        repository.findByAttr(domain.getAttr())
                .ifPresent(_domain -> {
                    throw new IllegalStateException("Already existing domain");
                });

        repository.save(domain);

        return domain.getId();
    }

    public List<SampleDomain> findAllDomains() {
        return repository.findAll();
    }

    public Optional<SampleDomain> findDomainById(Long id) {
        return repository.findById(id);

    }

}
