package kr.ac.kopo.korea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.korea.dao.ReplyDao;
import kr.ac.kopo.korea.model.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyDao dao;

	@Override
	public List<Reply> qaList(int qaId) {
		return dao.qaList(qaId);
	}

	@Override
	public void qaAdd(Reply reply) {
		dao.qaAdd(reply);
	}
	
	@Override
	public void qaDelete(int id) {
		dao.qaDelete(id);
	}

	@Override
	public List<Reply> historyList(int historyId) {
		return dao.historyList(historyId);
	}

	@Override
	public void historyAdd(Reply reply) {
		dao.historyAdd(reply);
	}

	@Override
	public void historyDelete(int id) {
		dao.historyDelete(id);
	}

}
