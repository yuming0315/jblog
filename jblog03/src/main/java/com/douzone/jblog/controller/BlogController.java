package com.douzone.jblog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.jblog.service.BlogService;
import com.douzone.jblog.service.FileuploadService;
import com.douzone.jblog.vo.BlogVo;

@Controller
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private FileuploadService fileuploadService;

	//interceptor 써서 없는 id 메인으로 보내거나 양해페이지
	@RequestMapping("/{id}")
	public String index(@PathVariable("id") String id,Model model) {
		Map<String, Object> map = blogService.getMain(id);
		model.addAllAttributes(map);
		return "blog/main";
	}
	
	@RequestMapping(value="/{id}/edit",method = RequestMethod.GET)
	public String edit(@PathVariable("id") String id,Model model) {
		BlogVo blog = blogService.getBlog(id);
		model.addAttribute("blog",blog);
		return "blog/blog-edit";
	}
	
	@RequestMapping(value="/{id}/edit",method = RequestMethod.POST)
	public String updateEdit(@PathVariable("id") String id,
			@RequestParam("file") MultipartFile multipartFile,
			BlogVo blog) {
		String url = fileuploadService.restore(multipartFile);
		blog.setProfile(url);
		blogService.updateBlog(blog);
		
		return "redirect:/"+id;
	}
	
}
