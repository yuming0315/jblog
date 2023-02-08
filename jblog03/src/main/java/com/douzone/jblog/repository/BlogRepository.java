package com.douzone.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Repository
public class BlogRepository {
	@Autowired
	private SqlSession sqlSession;

	public BlogVo getBlog(String id) {
		return sqlSession.selectOne("blog.getBlog",id);
	}

	public List<PostVo> getLatestPost(String id) {
		return sqlSession.selectList("blog.getLatestPost",id);
	}

	public List<CategoryVo> getCategory(String id) {
		return sqlSession.selectList("blog.getCategory",id);
	}

	public int updateBlog(BlogVo blog) {
		return sqlSession.update("blog.updateBlog",blog);
	}
	
	
	
}
