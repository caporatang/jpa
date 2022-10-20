package com.practice.jpa.bookmanager.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity // --> jpa에서 관리하는 entitiy 클래스임을 명시  // name으로 인덱스 설정(잘 사용하지 않음)           // 테이블에 유니크 설정(제약사항)
@Table(name="member", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})// catalog, name, schema를 지정할수있음 따로 설정하지 않으면 디폴트로 설정된다.
public class Member {
    // 엔티티는 모두 컬럼으로 표현 해야함
    //generationType이란
    // IDENTITY --> mysql에서 사용되고 auto-Increment와 같다
    // SEQUENCE --> oracle,h2DB에서 사용
    // TABLE --> DB종류의 상관없이 아이디를 관리하는 별도의 테이블을 생성하여 관리
    // AUTO --> 지정하지 않으면 각 DB에 맞는 값으로 자동으로 넘겨줌
    @Id // pk는 필수로 필요하다.
    @GeneratedValue // 생성된 데이터를 사용하겠다.
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    //
    @Column
    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

}
