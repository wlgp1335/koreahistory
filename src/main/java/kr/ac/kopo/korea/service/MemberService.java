package kr.ac.kopo.korea.service;

import java.util.List;

import kr.ac.kopo.korea.model.Member;
import kr.ac.kopo.korea.pager.Pager;

public interface MemberService {

	boolean login(Member member);

	void signup(Member item);

	boolean checkId(String id);
	
	List<Member> list(Pager pager);

	void changeGrade(Member item);

	Member item(String id);

	void profile(Member item);

	void delete(String id);
}
