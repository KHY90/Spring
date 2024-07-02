package com.ohgiraffers.mapping.section06.compositekey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

// 복합키 설정
@Embeddable
public class MemberPk implements Serializable { // Serializable 직렬화

    @Column(name = "member_no")
    private int memberNo;

    @Column(name = "member_id")
    private String memberId;

    public MemberPk() {
    }

    public MemberPk(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /*
    해시 함수 또는 해시 알고리즘 또는 해시함수알고리즘은
    임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수이다
    비밀번호를 암호화 시킬 때 사용되곤한다.
    */
    @Override
    public int hashCode() {
        // Objects.hash 메서드를 사용하여 memberNo와 memberId 필드의 해시 값을 계산하고 이를 결합하여 고유한 해시 코드를 생성합니다.
        return Objects.hash(memberNo, memberId);
    }

    @Override
    public boolean equals(Object obj) {
        // 객체 자신과 비교하는 경우 항상 true를 반환합니다.
        if (this == obj) {
            return true;
        }
        // 비교 대상 객체가 null이거나, 현재 객체의 클래스와 비교 대상 객체의 클래스가 다른 경우 false를 반환합니다.
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // 비교 대상 객체를 현재 클래스 타입으로 캐스팅합니다.
        MemberPk memberPk = (MemberPk) obj;

        // memberNo 필드가 동일하고, memberId 필드가 동일한지 확인하여 결과를 반환합니다.
        return memberNo == memberPk.memberNo && Objects.equals(memberId, memberPk.memberId);
        //       인트타입이라 == 로 비교              // 스트링이라 equals로 비교
    }

    @Override
    public String toString() {
        return "MemberPk{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
