package com.newlecture.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.vo.Member;

public class MyBatisMemberDao implements MemberDao {
	
	private SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	
	@Override
	public Member getMember(String uid) {
		
		//SqlSession session = factory.openSession();

		Member member = session.selectOne(
				"com.newlecture.web.dao.MemberDao.getMember", uid);
		//session.close();

		return member;
	}

	@Override
	public List<Member> getMembers(int page, String field, String query) {
		
		//SqlSession session = factory.openSession();

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("field", field);
		params.put("query", query);

		List<Member> list = session.selectList("getMembers", params);
		//session.close();

		return list;
	}

	@Override
	public int addMember(Member member) {
		
		//SqlSession session = factory.openSession();
		
		int result = 0;
		
			result = session.insert("com.newlecture.web.dao.MemberDao.addMember", member);

		return result;
	}

}
