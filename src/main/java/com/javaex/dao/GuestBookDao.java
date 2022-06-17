package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	@Autowired
	private SqlSession sqlSeeion;


	public List<GuestBookVo> getList() {
		List<GuestBookVo> list = sqlSeeion.selectList("guestbook.getList");
		return list;

	}

	public int insert(GuestBookVo  guestbookvo) {
		
		int count = sqlSeeion.insert("guestbook.insert", guestbookvo);
		
		return count;
	}

	public int delete(int no, String password) {
		GuestBookVo guestbookVo = new GuestBookVo();
		guestbookVo.setNo(no);
		guestbookVo.setPassword(password);
		int count = sqlSeeion.delete("guestbook.delete",guestbookVo);
		
		return count;
	}

}
