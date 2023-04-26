package org.zerock.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.mapper.SocialMemberMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SocialMemberServiceImpl implements SocialMemberService {

	@Autowired
	private SocialMemberMapper socialMemberMapper;

	@Override
	public boolean isMember(MemberDTO memberDTO) throws Exception {
		// member 테이블에서 id 또는 email이 일치하는 데이터가 있는지 조회
		MemberDTO member = socialMemberMapper.idEmailCheck(memberDTO.getId(), memberDTO.getEmail());

		return member != null; // null이 아니면 중복이므로 true 반환

	} // isMember

	@Override
	public MemberDTO idEmailCheck(String id, String email) throws Exception {
		log.trace("readByIdOrEmail invoked");

		return socialMemberMapper.idEmailCheck(id, email);
	} // idEmailCheck

	@Override
	public void insert(MemberDTO memberDTO) throws Exception {
		log.trace("insert invoked");

		socialMemberMapper.insert(memberDTO);
	} // insert

	@Override
	public void kakaoSignupAddInfo(MemberDTO memberDTO) throws Exception {
		log.trace("kakaoSignupAddInfo invoked");

		socialMemberMapper.kakaoSignupAddInfo(memberDTO);

	} // kakaoSignupAddInfo
} // end class