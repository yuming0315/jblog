package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public int updateBlog(BlogVo blog) {
		return sqlSession.update("blog.updateBlog",blog);
	}
	
	public List<CategoryVo> getCategory(String id) {
		return sqlSession.selectList("category.getCategory",id);
	}

	public Long findCategoryNo(CategoryVo category) {
		return sqlSession.selectOne("category.findCategoryNo",category);
	}
		
	public List<CategoryVo> getCategoryAndPostNum(String id) {
		return sqlSession.selectList("category.getCategoryAndPostNum",id);
	}
	
	public int addPost(PostVo post) {
		return sqlSession.insert("post.addPost",post);
	}

	public List<PostVo> getPostList(String id,Long c_no) {
		Map<String,Object> map = new HashMap<>();
		map.put("id",id);
		map.put("c_no", c_no);
		return sqlSession.selectList("post.getPostList",map);
	}
	

	public int addCategory(CategoryVo category) {
		return sqlSession.insert("category.addCategory",category);
	}

	public int deleteCategory(CategoryVo category) {
		if(getCategory(category.getId()).size()>1) {
			return sqlSession.delete("category.deleteCategory",category);
		}
		return 0;
	}

	public PostVo getPost(Long p_no) {
		return sqlSession.selectOne("post.getPost",p_no);
	}
}
