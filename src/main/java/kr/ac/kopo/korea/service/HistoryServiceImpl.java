package kr.ac.kopo.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.korea.dao.AttachDao;
import kr.ac.kopo.korea.dao.HistoryDao;
import kr.ac.kopo.korea.model.Attach;
import kr.ac.kopo.korea.model.History;
import kr.ac.kopo.korea.pager.Pager;

@Service
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	HistoryDao dao;
	
	@Autowired
	AttachDao attachdao;
	
	@Override
	public List<History> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	@Transactional
	public void add(History item) {
		dao.add(item);
		
		if(item.getAttachs() != null) {
			for(Attach attach : item.getAttachs()) {
				attach.setHistoryId(item.getId());
				
				attachdao.historyAdd(attach);
			}
		}
	}

	@Override
	public History item(int id) {
		return dao.item(id);
	}

	@Override
	@Transactional
	public void update(History item) {	
		dao.update(item);
		
		if(item.getAttachs() != null) {
			for(Attach attach : item.getAttachs()) {
				attach.setHistoryId(item.getId());
				
				attachdao.historyAdd(attach);
			}
		}
	}

	@Override
	@Transactional
	public void delete(int id, String memberId) {
		attachdao.deleteByhistoryId(id);
		
		dao.delete(id, memberId);
	}

	@Override
	public boolean deleteAttach(int id) {
		if(attachdao.delete(id))
			return true;
		else
			return false;
	}

	//검색 기능
	@Override
	public List<History> search(String keyword) {
		return dao.search(keyword);
	}

}
