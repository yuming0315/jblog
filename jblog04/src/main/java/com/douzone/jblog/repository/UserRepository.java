package com.douzone.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.UserVo;

@Repository
public class UserRepository {
	@Autowired
	private SqlSession sqlSession;

	public int insertUser(UserVo user) {
		return sqlSession.insert("user.insertUser",user);
	}

	public UserVo getUser(UserVo vo) {
		return sqlSession.selectOne("user.getUser",vo);
	}
	
	
}
