package kr.ac.kopo.korea.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.korea.model.Member;
import kr.ac.kopo.korea.pager.Pager;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public Member login(Member member) {

		return sql.selectOne("member.login", member);
	}

	@Override
	public void signup(Member item) {
		sql.insert("member.signup", item);
		
	}

	@Override
	public int checkId(String id) {
		
		return sql.selectOne("member.check_id", id);
	}
	
	@Override
	public int total(Pager pager) {
		
		return sql.selectOne("member.total", pager);
	}

	@Override
	public List<Member> list(Pager pager) {
		
		return sql.selectList("member.list");
	}

	@Override
	public void changeGrade(Member item) {
		sql.update("member.changeGrade", item);
		
	}

	@Override
	public Member item(String id) {
		return sql.selectOne("member.item", id);
	}

	@Override
	public void profile(Member item) {
		sql.update("member.profile", item);
		
	}

	@Override
	public void delete(String id) {
		sql.delete("member.delete", id);
		
	}
}
