package kr.ac.kopo.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.korea.dao.QADao;
import kr.ac.kopo.korea.model.QA;
import kr.ac.kopo.korea.pager.Pager;

@Service
public class QAServiceImpl implements QAService {

	@Autowired
	QADao dao;
	
	@Override
	public List<QA> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(QA item) {
		dao.add(item);

	}

	@Override
	public QA item(int id) {
		return dao.item(id);
	}

	@Override
	public void update(QA item) {
		dao.update(item);

	}

	@Override
	public void delete(int id, String memberId) {
		dao.delete(id, memberId);

	}

	@Override
	public List<QA> search(String keyword) {
		return dao.search(keyword);
	}

}
