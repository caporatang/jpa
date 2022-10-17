package com.practice.jpa.bookmanager.repository;

import com.practice.jpa.bookmanager.domain.Member;
import org.aspectj.weaver.ast.Or;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class MemberRepositoryTest {
    // 스프링 컨텍스트를 로딩하여 테스트에 활용하겠다.  // testsetsetset
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void crud() {
//        memberRepository.save(new Member());
//        memberRepository.findAll().forEach(System.out::println);
//        for(Member member : memberRepository.findAll()) {
//            System.out.println(member);
//        }

        //역순으로 전체 조회
//        List<Member> members = memberRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));

        //리스트 세팅 --> 테스트에서만 제공되는 메서드이다
        //List<Member> members = memberRepository.findAllById(Lists.newArrayList(1L,3L,5L));
        //members.forEach(System.out::println);

        //기본 저장 출력, 리스트 저장
        //Member member1 = new Member("jack", "jack@naver.com");
//        Member member2 = new Member("steve", "steve@naver.com");
//        memberRepository.saveAll(Lists.newArrayList(member1,member2));
        //memberRepository.save(member1);

        //List<Member> members = memberRepository.findAll();
        //members.forEach(System.out::println);

        //getOne은 lazy패치 로딩을 지원함 --> 트랜잭셔널을 써야함
        //Member member = memberRepository.getOne(1L);
        //System.out.println(member);

        //옵셔널로 감싸져있음..옵셔널로 받는경우 다른 처리가 필요함
        //Member member = memberRepository.findById(1L).orElse(null);

        //flush 일단은 ..db반영의 타이밍을 설정? 하는것 영속성컨텍스트에 대한 이해 필요
        //memberRepository.save(new Member("new taeil", "newTaeil@naver.com"));
        //memberRepository.saveAndFlush(new Member("new taeil", "newTaeil@naver.com"));
        //memberRepository.flush();
        //memberRepository.findAll().forEach(System.out::println);

        // 해당 테이블에 있는 데이터 갯수 --> 카운트
//        long count = memberRepository.count();
//        System.out.println("데이터의 갯수는 " + count);
        // 데이터의 존재 유무
        // boolean exists = memberRepository.existsById(1L);
//        System.out.println("데이터가 있니? " + exists);

        //1L이라는 pk를 가진 로우를 삭제
        //memberRepository.delete(memberRepository.findById(1L).orElseThrow(RuntimeException::new));
//    memberRepository.deleteById(1L);
//    memberRepository.findAll().forEach(System.out::println);


        // findAll과 마찬가지로 deleteAll을 사용해도 성능 이슈가 있다
        // findAll로 한번 조회를 하기 때문..
        // 그럴때 사용하는게 deleteInBatch
        //memberRepository.deleteAll(memberRepository.findAllById(Lists.newArrayList(1L,3L)));
        //memberRepository.findAll().forEach(System.out::println);

        //deleteInBatch는 조회쿼리를 한번 호출하지 않고 바로 delete쿼리를 날려줌
//  memberRepository.deleteInBatch(memberRepository.findAllById(Lists.newArrayList(1L,3L)));
//  memberRepository.findAll().forEach(System.out::println);

        //deleteAllInBatch --> 조회하지 않고 무조건 삭제함(where절 없음)
        //memberRepository.deleteAllInBatch();
        //memberRepository.findAll().forEach(System.out::println);

        //-----------------------------_Paging------------------------------------------------------------------
        // 페이징은 0을 기준으로 시작함.
//        Page<Member> member = memberRepository.findAll(PageRequest.of(0,3));
//        System.out.println("page : " + member);
//        System.out.println("totalElements : " + member.getTotalElements()); // --> 들어있는 데이터의 총 갯수
//        System.out.println("totalPages : " + member.getTotalPages()); // --> 5를 3으로 나누면 2페이지
//        System.out.println("numberOfElements : " + member.getNumberOfElements()); // --> 가져온 엘리먼츠의 갯수
//        System.out.println("sort : " + member.getSort()); // --> 정렬 미지정
//        System.out.println("size : " + member.getSize()); // --> 지정한 사이즈
//
//        member.getContent().forEach(System.out::println); // --> 가져온 데이터를 찍어봄 2개


        // --> like escape 검색(조건)
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name") // --> 이름은 무시한다
//                .withMatcher("email", endsWith());
//        Example<Member> member = Example.of(new Member("na", "naver.com"), matcher);

        //Example<Member> member = Example.of(new Member("taeil", "taeil@naver.com"));
        //memberRepository.findAll(member).forEach(System.out::println);

        //matcher는 실제로 이런식으로 구현된다. --> 양방향 like 검색
//        Member member = new Member();
//        member.setEmail("taeil");
//
//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
//        //맴버에 어떤 대상이 오던지 ~ 조회
//        Example<Member> example = Example.of(member, matcher);
//        memberRepository.findAll(example).forEach(System.out::println);

    //------------------- update 처리 ---------------------
//    memberRepository.save(new Member("david", "david@naver.com"));
//    Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
//    member.setEmail("taeil-updated@fastcampus.com");
//
//    memberRepository.save(member);

    } // --> crud end

    @Test
    void select()  {

        //------------------------------------쿼리 메서드 select ---------------------------------------------------

        //System.out.println(memberRepository.findByName("james"));
        // 모두 다 같은 쿼리 실행결과가 나옴 --> 가독성이 가장 좋은 메서드로 사용할것.
        //System.out.println("findByEmail : " + memberRepository.findByEmail("capo@naver.com"));
        //System.out.println("getByEmail : " + memberRepository.getByEmail("capo@naver.com"));
        //System.out.println("readByEmail : " + memberRepository.readByEmail("capo@naver.com"));
        //System.out.println("queryByEmail : " + memberRepository.queryByEmail("capo@naver.com"));
        //System.out.println("searchByEmail : " + memberRepository.searchByEmail("capo@naver.com"));
        //System.out.println("streamByEmail : " + memberRepository.streamByEmail("capo@naver.com"));
        //System.out.println("findmemberByEmail : " + memberRepository.findMemberByEmail("capo@naver.com"));
        // something을 넣어도 동작에 문제가 없음, 자유도를 제공하는 만큼 맞는 엔티티를 넣어주어야함
        //System.out.println("findSomethingByEmail : " + memberRepository.findSomethingByEmail("capo@naver.com"));
        //잘못된 메서드
        //System.out.println("findByByName : " + memberRepository.findByByName("capo@naver.com"));

        //System.out.println("findTop1ByName : " + memberRepository.findTop1ByName("taeil"));
        //System.out.println("findFirstByName : " + memberRepository.findFirst1ByName("taeil"));

        //System.out.println("findTop2ByName : " + memberRepository.findTop2ByName("taeil"));
        //System.out.println("findFirst2ByName : " + memberRepository.findFirst2ByName("taeil"));
        //last는 인식하지 못해 실행되지 않는다.
        //System.out.println("findLast1ByName : " + memberRepository.findLast1ByName("taeil"));

        // 여러 조건을 추가하여 조회하는 경우
        System.out.println("findByEmailAndName : " + memberRepository.findByEmailAndName("taeil@naver.com", "taeil"));
        System.out.println("findByEmailOrName : " + memberRepository.findByEmailOrName("taeil@fastcampus.com", "dd"));

        // 시간에 대한 조건 추가
        // 하루 이전의 데이터로 맞춰줌
        System.out.println("findByCreatedAtAfter : " + memberRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        //숫자도 가능하다. 쿼리가 조건 보다 큰것을 가져오는것이므로 동작된다.
        System.out.println("findByIdAfter : " + memberRepository.findByIdAfter(4L));
        //before, after는 = 동일은 체크하지 않는다.
        System.out.println("findByCreatedAtGreaterThanAnd : " + memberRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual : " + memberRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
        // between 날짜와 숫자(pk) 가능
        System.out.println("findByCreatedAtBetween : " + memberRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));

        System.out.println("findByIdBetween : " + memberRepository.findByIdBetween(1L, 3L));

        // between로직을 풀어서 쓰면.. 익셉션은 잡기 힘들기 때문에 꼭 신경쓸것..
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + memberRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

        //-------------------------------------빈값(null) 조회-----------------------------------------------
        // --> 실행 쿼리 조건이 is not null
        System.out.println("findByIdIsNotNull : " + memberRepository.findByIdIsNotNull());
        // where exist inner 쿼리로 동작된다.
        //System.out.println("indByAddressIsNotEmpty : " + memberRepository.findByAddressIsNotEmpty());

        //in구절은 자주 사용된다. --> in절에 리스트 인자가 너무 많은경우 성능 이슈가 발생할수있기 때문에 미리 체크하고 사용할것..
        System.out.println("findByNameIn : " + memberRepository.findByNameIn(Lists.newArrayList("capo","sophia")));


        //%를 추가하면 sql과 동일한 like기능이 실행된다.
        System.out.println("findByNameStartingWith : " + memberRepository.findByNameStartingWith("tae"));
        System.out.println("findByNameEndingWith : " + memberRepository.findByNameEndingWith("il"));
        //양방향
        System.out.println("findByNameContains : " + memberRepository.findByNameContains("aei"));
        System.out.println("findByNameLike" + memberRepository.findByNameLike("%aei%"));

        //--------------------------------------is ----------------------------is equals----------------------
    }

    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByName : " + memberRepository.findTop1ByName("taeil"));
        // 동작되지 않음
        System.out.println("findLast1ByName : " + memberRepository.findLast1ByName("taeil"));
        // --> 라스트를 풀어서 사용하면..
        System.out.println("findTop1ByNameOrderByIdDesc : " + memberRepository.findTop1ByNameOrderByIdDesc("taeil"));
        System.out.println("findTopByNameOrderByIdDesc : " + memberRepository.findTopByNameOrderByIdDesc("taeil"));

        // 이름으로 찾을건데, 아이디 역순 이메일 정순으로 검색
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + memberRepository.findFirstByNameOrderByIdDescEmailAsc("taeil"));
        //가독성이 떨어질수있으나 인자로 속성을 주는것도 좋은 방법이다. --> 적절한 방법으로 사용하여야한다....어렵다
        System.out.println("findFirstByName : " + memberRepository.findFirstByName("taeil", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findFirstByNameWithSortParams : " + memberRepository.findFirstByName("taeil", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));

        //--------------------------------------Pageing-----------------------------------
        // 페이지 값은 zero베이스 값이다.
        System.out.println("findByNameWithPaging : " + memberRepository.findByName("taeil", PageRequest.of(1,1, Sort.by("id"))).getContent());
        System.out.println("findByNameWithPagingGetTotalElements : " + memberRepository.findByName("taeil", PageRequest.of(1,1, Sort.by("id"))).getTotalElements());



    }





}