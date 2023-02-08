package com.douzone.jblog.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;


@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	public Map<String, Object> getMain(String id) {
		Map<String,Object> map = new HashMap<>();
		map.put("blog", blogRepository.getBlog(id));
		map.put("latestPost", blogRepository.getLatestPost(id));
		map.put("category", blogRepository.getCategory(id));
		return map;
	}

	public boolean updateBlog(BlogVo blog) {
		return blogRepository.updateBlog(blog)>0 ? true : false;
	}

	public BlogVo getBlog(String id) {
		return blogRepository.getBlog(id);
	}
	
	
}
