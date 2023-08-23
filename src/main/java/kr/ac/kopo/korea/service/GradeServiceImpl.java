package kr.ac.kopo.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.korea.dao.GradeDao;
import kr.ac.kopo.korea.model.Grade;

@Service
public class GradeServiceImpl implements GradeService {
	
	@Autowired
	GradeDao dao;

	@Override
	public List<Grade> list() {
		return dao.list();
	}

	@Override
	public void add(Grade item) {
		dao.add(item);

	}

	@Override
	public Grade item(int id) {
		return dao.item(id);
	}

	@Override
	public void update(Grade item) {
		dao.update(item);

	}

	@Override
	public void delete(int id) {
		dao.delete(id);

	}

	@Override
	public void firstAdd(Grade item) {
		dao.firstAdd(item);
	}

}
