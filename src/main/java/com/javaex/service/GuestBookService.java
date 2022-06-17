package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestBookService {

	@Autowired
	private GuestBookDao gueskbookDao;

	// 리스트
	public List<GuestBookVo> gList() {

		List<GuestBookVo> gList = gueskbookDao.getList();

		return gList;
	}

	// 등록
	public int gbinsert(GuestBookVo guestbookVo) {
		int count = gueskbookDao.insert(guestbookVo);
		return count;
	}
	//삭제
	public int gbdelete(int no, String password) {

		int count = gueskbookDao.delete(no, password);

		return count;
	}
}
