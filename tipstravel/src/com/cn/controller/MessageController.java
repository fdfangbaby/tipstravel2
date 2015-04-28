package com.cn.controller;

import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.entity.Message;
import com.cn.entity.PaginationSupport;
import com.cn.entity.User;
import com.cn.service.MessageService;
import com.cn.service.UserService;

@Controller
@RequestMapping("/message")
public class MessageController {

	private MessageService messageService;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	@Resource
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	//�����ײ�ķ�����д���ˣ���һ�¾�������
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addMessage()
	{
		Message message=new Message();
		message.setContext("test from add");
		message.setUser(userService.loadbyid(1));
		messageService.addMessage(message);
	}
	
	@RequestMapping("/homepage")
	public PaginationSupport showhomepage(int userid,int startindex)
	{
		PaginationSupport ps=messageService.showhome(userid,startindex);
		if(ps!=null)ps.setMessage("���سɹ�");
		else ps.setMessage("����ʧ��");
		return ps;
	}
	
	@RequestMapping("/following")
	public PaginationSupport showfollowing(int userid,int startindex)
	{
		PaginationSupport ps=messageService.showfollowing(userid, startindex);
		if(ps!=null)ps.setMessage("���سɹ�");
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
