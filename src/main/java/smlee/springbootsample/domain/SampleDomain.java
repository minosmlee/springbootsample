package smlee.springbootsample.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SampleDomain {

    @Id // 이 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙 GenerationType.IDENTITY 는 auto increment 를 의미)
    private Long Id;

    // @Column(name = "attr") // 테이블의 컬럼에 각종 속성을 정의한다. name을 지정할 경우 테이블의 컬럼과 매핑됨
    private String attr;

    @Builder
    public SampleDomain(String attr) {
        this.attr = attr;
    }
}
