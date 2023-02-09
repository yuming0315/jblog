package com.douzone.jblog.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.PostVo;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private FileuploadService fileuploadService;

	//interceptor 써서 없는 id 메인으로 보내거나 양해페이지
	//카테고리가 선택 안 될때랑 정확히 글이 선택될 때 출력이 다름.
	@RequestMapping({"","/{c_no:[0-9]*}","/{c_no:[0-9]*}/{p_no:[0-9]*}"})
	public String index(@PathVariable("id") String id,
			@PathVariable("c_no") Optional<Long> c_no,
			@PathVariable("p_no") Optional<Long> p_no,
			Model model) {
		Map<String, Object> map = null;
		if(p_no.isPresent()) {
			map = blogService.getMain(id,c_no.get(),p_no.get());
		}else if(c_no.isPresent()) {
			map = blogService.getMain(id,c_no.get());
		}else {
			map = blogService.getMain(id);
		}
		model.addAllAttributes(map);
		return "blog/main";
	}
	
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public String edit(@PathVariable("id") String id, Model model) {
		
		BlogVo blog = blogService.getBlog(id);
		model.addAttribute("blog",blog);
		return "blog/blog-edit";
	}
	
	@RequestMapping(value="/edit",method = RequestMethod.POST)
	public String updateEdit(@PathVariable("id") String id,
			@RequestParam("file") MultipartFile multipartFile,
			BlogVo blog) {
		String url = fileuploadService.restore(multipartFile);
		blog.setProfile(url);
		blogService.updateBlog(blog);
		
		return "redirect:/"+id;
	}

	
	@RequestMapping(value={"/write"},method = RequestMethod.GET)
	public String getWrite(@PathVariable("id") String id, Model model) {
		List<CategoryVo> category = blogService.getCategory(id);
		model.addAttribute("category",category);
		return "blog/write";
	}
	
	@RequestMapping(value={"/write"},method = RequestMethod.POST)
	public String postWrite(@PathVariable("id") String id,
			PostVo post, CategoryVo category,Model model) {
		post.setCategory_no(category.getNo());
		blogService.addPost(post);
		return "redirect:/"+id+"/write";
	}
	
	@RequestMapping(value={"/category"},method = RequestMethod.GET)
	public String getCategory(@PathVariable("id") String id, Model model) {
		List<CategoryVo> category = blogService.getCategoryAndPostNum(id);
		model.addAttribute("category",category);
		return "blog/category";
	}
	
	//post일 때만 인터셉터 하나 더 추가해서 중복검사 prehandle
	@RequestMapping(value={"/category"},method = RequestMethod.POST)
	public String postCategory(@PathVariable("id") String id,CategoryVo category) {
		category.setId(id);
		blogService.addCategory(category);
		return "redirect:/"+id+"/category";
	}
	
	@RequestMapping(value={"/deleteCategory/{no:[0-9]*}"},method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") String id,
			@PathVariable("no") Long no) {
		CategoryVo category = new CategoryVo();
		category.setNo(no);
		category.setId(id);
		blogService.deleteCategory(category);
		return "redirect:/"+id+"/category";
	}
}
