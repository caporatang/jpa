package com.practice.jpa.bookmanager.repository;

import com.practice.jpa.bookmanager.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // --> QueryMethod 활용하기
    //Member findByName(String name);
    //List<Member> findByName(String name);
    //Optional<Member> findByName (String name);
    Set<Member> findByName(String name);

    Member findByEmail(String email);

    Member getByEmail(String email);

    Member readByEmail(String email);

    Member queryByEmail(String email);

    Member searchByEmail(String email);

    Member streamByEmail(String email);

    Member findMemberByEmail(String email);

    Member findSomethingByEmail(String email);

    //잘못된 메서드
    //Member findByByName(String email);

    //List타입이 아닌 Member객체로도 가능하다
    Member findFirst1ByName(String name);
    List<Member> findFirst2ByName(String name);
    Member findTop1ByName(String name);
    List<Member> findTop2ByName(String name);

    //jpa에서 인식하지 않는 문자(last) 같은것을 넣는 경우 동작하지 않는다
    // 마지막것을 가져오고싶으면 오더바이로 조회를 한 후 top1을 사용하여 마지막것을 가지고오자.
    List<Member> findLast1ByName(String name);

    //여러조건 추가해서 조회하기
    List<Member> findByEmailAndName(String email, String name);
    List<Member> findByEmailOrName(String email, String name);

    // 시간에 대한 조건 --> 생성 시간 및 날짜 , 업데이트 시간 및 날짜
    List<Member> findByCreatedAtAfter(LocalDateTime yesterday);
    //일반적인 숫자도 가능하다
    List<Member> findByIdAfter(Long id);

    //before, after는 = 동일은 체크하지 않는다.
    List<Member> findByCreatedAtGreaterThan(LocalDateTime yesterday);
    List<Member> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    // between 날짜와 숫자(pk) 가능
    List<Member> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);
    List<Member> findByIdBetween(Long id1, Long id2);

    List<Member> findByIdGreaterThanEqualAndIdLessThanEqual(Long id, Long Long2);

    // ---------------------------빈값 조회 ----------------------------------------------------
    List<Member> findByIdIsNotNull();
//    List<Member> findByIdIsNotEmpty();

    // isnotEmpty empty는 자주 사용되지 않는다.
    //List<Member> findByAddressIsNotEmpty();

    //in구절은 자주 사용된다.
    List<Member> findByNameIn(List<String> names);

    //------------------------------------------------------------------------------
    List<Member> findByNameStartingWith(String names);
    List<Member> findByNameEndingWith(String name);
    List<Member> findByNameContains(String name);

    List<Member> findByNameLike(String name);

    //-----------------------is ------------------------------------------
    // is는 생략이 된다는것을 알수있고, 가독성이 높은 코드를 작성할수있게 도와주는 키워드이다.
    Set<Member> findMemberByNameIs(String name);
    Set<Member> findMemberByName(String name);
    Set<Member> findMemberByNameEquals(String name);


    //---------------------------------Sort------------------------------------
    List<Member> findTop1ByNameOrderByIdDesc(String name);
    List<Member> findTopByNameOrderByIdDesc(String name);

    // 이름으로 찾을건데, 아이디 역순 이메일 정순으로 검색
    List<Member> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<Member> findFirstByName(String name, Sort sort);

    //------------------------------Paging--------------------------------------
    //리턴타입을 페이지 인터페이스로 지정
    // page는 slice인터페이스를 상속받음 --> Page는 응답값 , Pageable은 요청값으로 사용된다.
    Page<Member> findByName(String name, Pageable pageable);



}
