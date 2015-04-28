package com.cn.controller;

import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.entity.Message;
import com.cn.entity.PaginationSupport;
import com.cn.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {

	private TagService tagService;
	
	
	public TagService getTagService() {
		return tagService;
	}

	@Resource
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}


	@RequestMapping(value="/search" )
	public PaginationSupport searchbytag(int tagid,int startindex)
	{
		PaginationSupport ps=tagService.searchbytag(tagid, startindex);
		if(ps!=null) ps.setMessage("���سɹ�");
		else ps.setMessage("����ʧ��");
//		System.out.println(ps);
//		Iterator iterator=ps.getData().iterator();
//		while(iterator.hasNext())
//		{
//			Message message=(Message)iterator.next();
//			System.out.println(message);
//		}
		return ps;
	}
}
