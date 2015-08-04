
package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.Member;
import com.newlecture.web.vo.NoticeFile;

public class MyBatisNoticeFileDao implements NoticeFileDao{
	
	/*SqlSessionFactory factory =
			new SqlNewlecSessionFactory().getSqlSessionFactory();*/
	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public int addNoticeFile(NoticeFile noticeFile) {
		
		int result=0;
		//SqlSession session = factory.openSession(); 
		

		NoticeFileDao dao = session.getMapper(NoticeFileDao.class);
		result = dao.addNoticeFile(noticeFile);
		
		return result;
	}
	
	@Override
	public List<NoticeFile> getNoticeFiles(String noticeCode) {
		
		List<NoticeFile> list = session.selectList("getNoticeFiles", noticeCode);
		
		return list;
	}
	

}
