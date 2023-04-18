package org.zerock.myapp.domain;

import lombok.AllArgsConstructor;
import lombok.Value;
import oracle.sql.TIMESTAMP;

//@Data
@Value
@AllArgsConstructor
public class MemberVO {

	private String id;
	private String password;
	private String name;
	private String email;
	private String tel;
	private Integer address1;
	private String address2;
	private String address3;
	private String gender;
	private TIMESTAMP signup_date;
	private String birth_date;
	private Integer adminCk;
	
} // end class