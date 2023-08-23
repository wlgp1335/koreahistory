package kr.ac.kopo.korea.dao;

import java.util.List;

import kr.ac.kopo.korea.model.Member;
import kr.ac.kopo.korea.pager.Pager;

public interface MemberDao {

	Member login(Member member);

	void signup(Member item);

	int checkId(String id);
	
	int total(Pager pager);

	List<Member> list(Pager pager);

	void changeGrade(Member item);

	Member item(String id);

	void profile(Member item);

	void delete(String id);
	
}
