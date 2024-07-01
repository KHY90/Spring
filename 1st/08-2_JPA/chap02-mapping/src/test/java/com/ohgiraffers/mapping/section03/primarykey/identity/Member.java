package com.ohgiraffers.mapping.section03.primarykey.identity;

import jakarta.persistence.*;

import java.util.Date;

    /* Primary key에는 @Id 어노테이션과 @GeneratedValue 어노테이션을 사용한다.
       @Id 어노테이션은 엔티티 클래스에서 primary key 역할을 하는 필드를 지정할 때 사용된다.
       @GeneratedValue 어노테이션을 함께 사용하면 primary key 값을 자동으로 생성할 수 있다.

      데이터베이스마다 기본 키를 생성하는 방식이 서로 다르다.
      @GeneratedValue 어노테이션은 다음과 같은 속성을 가지고 있다.

   - strategy : 자동 생성 전략을 지정
       - GenerationType.IDENTITY : 기본 키 생성을 데이터베이스에 위임(MySQL의 AUTO_INCREMENT)
       - GenerationType.SEQUENCE : 데이터베이스 시퀀스 객체 사용(ORACLE의 SEQUENCE)
       - GenerationType.TABLE : 키 생성 테이블 사용
       - GenerationType.AUTO : 자동 선택 (MySQL이라면 IDENTITY, ORACLE이라면 SEQUENCE로 선택)
   - generator : strategy 값을 GenerationType.TABLE로 지정한 경우 사용되는 테이블 이름을 지정
   - initialValue : strategy 값을 GenerationType.SEQUENCE로 지정한 경우 시퀀스 초기값을 지정
   - allocationSize : strategy 값을 GenerationType.SEQUENCE로 지정한 경우 시퀀스 증가치를 지정
    * */

@Entity(name = "member_section03") // 이름은 생략가능
@Table(name = "tbl_member_section03") // DB 테이블과 매칭시킬 이름
public class Member {

//    데이터베이스 생성

    @Id // 프라이머리키 선언 없으면 에러남. 필수값
    @Column(name = "member_no") // 데이터베이스 테이블 컬럼 이름
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql, postsql에서 사용 애노테이션은 주로 데이터베이스의 자동 증가(auto-increment) 기능을 이용하여 고유한 기본 키 값을 생성합니다.
    private int memberNo;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_pwd")
    private String memberPwd;

    @Column(name = "nickName")
    @Transient // select에서 안보임
    private String nickName;

    // 컬럼 길이를 varchar 200으로 정의하고 없을땐 기본 값을 정해줌
    @Column(name = "phone", columnDefinition = "varchar(200) default '010-0000-0000'")
    private String phone;

    @Column(name = "address", unique = true) // 유니크 제약조건을 검
    private String address;

    @Column(name = "erroll_data")
    @Temporal(TemporalType.TIMESTAMP) // 시간
    private Date enrollDate;

    @Column(name = "member_role", nullable = false) // null을 허용할 것인가.
    private String memberRole;

    @Column(name = "status")
    private String status;

    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPwd, String nickName, String phone, String address, Date enrollDate, String memberRole, String status) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.nickName = nickName;
        this.phone = phone;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
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

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", enrollDate=" + enrollDate +
                ", memberRole='" + memberRole + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
