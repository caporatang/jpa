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
@Entity
public class Member {
    // 엔티티는 모두 컬럼으로 표현 해야함
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

}
