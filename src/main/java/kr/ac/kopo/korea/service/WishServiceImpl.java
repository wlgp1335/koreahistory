package kr.ac.kopo.korea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.korea.dao.WishDao;

@Service
public class WishServiceImpl implements WishService {
	
	@Autowired
	WishDao dao;

	@Override
	public boolean add(int historyId) {
		if(dao.add(historyId)>0)
			return true;
		
		return false;
	}

	@Override
	public boolean delete(int historyId) {
		if(dao.delete(historyId)>0)
			return true;
		
		return false;
	}

}
