package smlee.springbootsample.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import smlee.springbootsample.domain.SampleDomain;

@Repository
public class SampleMemoryRepository implements SampleRepository {

    private static Map<Long, SampleDomain> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public SampleDomain save(SampleDomain domain) {
        domain.setId(++sequence);
        store.put(domain.getId(), domain);
        return domain;
    }

    @Override
    public Optional<SampleDomain> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<SampleDomain> findByAttr(String attr) {
        return store.values().stream() // 해시맵에서 전체 리스트를 가져와 하나씩 스트림한 다음
                .filter(domain -> domain.getAttr().equals(attr)) // 각 도메인의 attr을 가져와 찾고자 하는 attr값과 일치하는지 확인하여
                .findAny(); // 찾는대로 리턴한다.
    }

    @Override
    public List<SampleDomain> findAll() {
        return new ArrayList<>(store.values()); // 해시맵에서 전체 리스트를 가져와 ArrayList에 담아 리턴한다.
    }

    public void clearStore() {
        store.clear();
    }
}
