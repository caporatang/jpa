package com.practice.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class MemberTest {
    //모든 클래스는 오브젝트를 하위객체
    // toString을 안하면 오브젝트에 해쉬값이 프린트된다.
    // public String toString() {
    //        return getClass().getName() + "@" + Integer.toHexString(hashCode());

    @Test
    void test() {
        Member user = new Member();
        user.setEmail("capo@naver.com");
        user.setName("김태일");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdateAt(LocalDateTime.now());
        System.out.println(">>>> @@@  " + user);

        Member user1 = new Member(null, "martin", "capo@naver.com", LocalDateTime.now(), LocalDateTime.now());
        Member user2 = new Member("martin", "capo@naver.com");





    }
}