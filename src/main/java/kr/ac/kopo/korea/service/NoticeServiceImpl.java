package kr.ac.kopo.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.korea.dao.AttachDao;
import kr.ac.kopo.korea.dao.NoticeDao;
import kr.ac.kopo.korea.model.Attach;
import kr.ac.kopo.korea.model.Notice;
import kr.ac.kopo.korea.pager.Pager;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao dao;
	
	@Autowired
	AttachDao attachdao;

	@Override
	public List<Notice> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Notice item) {
		dao.add(item);
		
		if(item.getAttachs() != null) {
			for(Attach attach : item.getAttachs()) {
				attach.setNoticeId(item.getId());
				
				attachdao.noticeAdd(attach);
			}
		}

	}

	@Override
	public Notice item(int id) {
		
		return dao.item(id);
	}

	@Override
	public void update(Notice item) {
		dao.update(item);
		
		if(item.getAttachs() != null) {
			for(Attach attach : item.getAttachs()) {
				attach.setNoticeId(item.getId());
				
				attachdao.noticeAdd(attach);
			}
		}

	}

	@Override
	public void delete(int id, String memberId) {
		attachdao.deleteByNoticeId(id);
		
		dao.delete(id, memberId);

	}

	@Override
	public boolean deleteAttach(int id) {
		if(attachdao.delete(id))
			return true;
		else
			return false;
	}

	@Override
	public List<Notice> search(String keyword) {
		return dao.search(keyword);
	}

}
