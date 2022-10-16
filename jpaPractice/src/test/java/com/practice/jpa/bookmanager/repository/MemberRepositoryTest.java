package com.practice.jpa.bookmanager.repository;

import com.practice.jpa.bookmanager.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class MemberRepositoryTest {
    // 스프링 컨텍스트를 로딩하여 테스트에 활용하겠다.  // 
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






    }

}