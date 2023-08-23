package kr.ac.kopo.korea.model;

import java.util.Date;

public class Reply {
	//댓글
	private int id;
	private String contents;
	private Date regDate;
	
	//외래키
	private String memberId;
	private String writer;
	private String qaId;
	private String historyId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getQaId() {
		return qaId;
	}
	public void setQaId(String qaId) {
		this.qaId = qaId;
	}
	public String getHistoryId() {
		return historyId;
	}
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}
}
