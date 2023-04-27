package org.zerock.myapp.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.myapp.domain.MemberDTO;

public interface MemberMapper {

	// 회원 가입  혁규
	public void memberSignup(MemberDTO memberDTO);

	// [셍나] 로그인
	// MemberVO로 하면 MemberVO 어노테이션 @Value라서 객체 생성이 안댐!
	// DTO 따로 생성해서 @Data 값 주고 사용하기
	public MemberDTO memberLogin(MemberDTO memberDTO);
	
	// [셍나] 아이디 찾기 - 휴대폰 인증 (이름과 전화번호로 사용자 정보가 존재하는지 확인)
	public int idCheck(@Param("name") String name, @Param("tel") String tel);
	
	// [셍나] 아이디 찾기 - 휴대폰 인증 - 결과
	public String findIdResult(@Param("name")String name, @Param("tel")String tel);
	
	// 주문자 주소 정보 (찬돌)
	public MemberDTO getMemberInfo(String id); // memberId 가 테이블에 ID로 되어있고 String임
	
} // end class
