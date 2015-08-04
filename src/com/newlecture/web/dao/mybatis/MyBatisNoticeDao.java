package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.Notice;

public class MyBatisNoticeDao implements NoticeDao{
	
/*	SqlSessionFactory factory =
			new SqlNewlecSessionFactory().getSqlSessionFactory();*/
	
	
	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}


	@Override
	public List<Notice> getNotices(int page, String field, String query) {
		
		/*session = fopenSession();*/
		NoticeDao dao = session.getMapper(NoticeDao.class);
		NoticeFileDao fileDao = session.getMapper(NoticeFileDao.class);
		
		List<Notice> list = dao.getNotices(page, field, query);
		
		for(Notice n:list)
			n.setFiles(fileDao.getNoticeFiles(n.getCode()));
		
			return list;
	}
	
	
	@Override
	public Notice getNotice(String code) {

		Notice n = session.selectOne("com.newlecture.web.dao.NoticeDao.getNotice",
				code);

		//session.close();

		return n;
	}


	@Override
	public List<Notice> getNotices() {
		// TODO Auto-generated method stub
		return getNotices(1,"TITLE","");
	}


	@Override
	public List<Notice> getNotices(int page) {
		// TODO Auto-generated method stub
		return getNotices(page,"TITLE","");
	}


	@Override
	public int addNotice(Notice notice) {
		
		int result=0;

		NoticeDao dao = session.getMapper(NoticeDao.class);
		result = dao.addNotice(notice);
		
		return result;
	}


	@Override
	public String getLastCode() {
		
		NoticeDao dao = session.getMapper(NoticeDao.class);
		
		return dao.getLastCode();
	}
}
