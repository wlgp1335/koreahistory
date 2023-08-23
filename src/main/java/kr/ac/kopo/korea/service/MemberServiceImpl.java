package kr.ac.kopo.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.korea.dao.MemberDao;
import kr.ac.kopo.korea.model.Member;
import kr.ac.kopo.korea.pager.Pager;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao dao;

	@Override
	public boolean login(Member member) {
		Member item = dao.login(member);
		
		if(item != null) {
			member.setPasswd(null);
			member.setName(item.getName());
			member.setPhone(item.getPhone());
			member.setNickname(item.getNickname());
			member.setRegDate(item.getRegDate());
			member.setGradeId(item.getGradeId());
			
			return true;
		} else
			return false;
	}

	@Override
	public void signup(Member item) {
		dao.signup(item);
		
	}

	@Override
	public boolean checkId(String id) {
		if(dao.checkId(id)==0)
			return true;
		else
			return false;
	}

	@Override
	public List<Member> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void changeGrade(Member item) {
		dao.changeGrade(item);
	}

	@Override
	public Member item(String id) {
		return dao.item(id);
	}

	@Override
	public void profile(Member item) {
		dao.profile(item);
		
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
		
	}
}
