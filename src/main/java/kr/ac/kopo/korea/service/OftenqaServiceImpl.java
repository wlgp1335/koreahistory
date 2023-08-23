package kr.ac.kopo.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.korea.dao.OftenqaDao;
import kr.ac.kopo.korea.model.Often;
import kr.ac.kopo.korea.pager.Pager;

@Service
public class OftenqaServiceImpl implements OftenqaService {
	
	@Autowired
	OftenqaDao dao;

	@Override
	public List<Often> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Often item) {
		dao.add(item);

	}

	@Override
	public Often item(int id) {
		
		return dao.item(id);
	}

	@Override
	public void update(Often item) {
		dao.update(item);

	}

	@Override
	public void delete(int id, String memberId) {
		dao.delete(id, memberId);

	}

	@Override
	public List<Often> search(String keyword) {
		return dao.search(keyword);
	}

}
