package com.douzone.jblog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;


@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public Map<String, Object> getMain(String id,Long c_no,Long p_no) {
		Map<String,Object> map = new HashMap<>();
		map.put("blog", blogRepository.getBlog(id));
		map.put("post", blogRepository.getPostList(id,c_no));
		map.put("category", blogRepository.getCategory(id));
		if(map.get("post") != null) {
			p_no = ((List<PostVo>)map.get("post")).get(0).getNo();
			map.put("onPost", blogRepository.getPost(p_no) );
		}
		return map;
	}
	public Map<String, Object> getMain(String id,Long c_no) {
		return getMain(id,c_no,null);
	}
	public Map<String, Object> getMain(String id) {
		return getMain(id,null);
	}

	public boolean updateBlog(BlogVo blog) {
		return blogRepository.updateBlog(blog)!=0;
	}

	public BlogVo getBlog(String id) {
		return blogRepository.getBlog(id);
	}

	public List<CategoryVo> getCategory(String id) {
		return blogRepository.getCategory(id);
	}

	public boolean addPost(PostVo post) {
		return blogRepository.addPost(post)!=0;
	}

	public List<CategoryVo> getCategoryAndPostNum(String id) {
		return blogRepository.getCategoryAndPostNum(id);
	}

	public boolean addCategory(CategoryVo category) {
		return blogRepository.addCategory(category)!=0;
	}

	public boolean deleteCategory(CategoryVo category) {
		return blogRepository.deleteCategory(category)!=0;
	}
	
	
}
