package com.cn.entity;

import javax.persistence.*;

@Entity
@Table(name="like" ,catalog = "tipstravel")
public class Like {
	private int like_id;
	private User user;
	private Message message;

	@Id
	@Column(name="like_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getLike_id() {
		return like_id;
	}
	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY) // ManyToOneָ���˶��һ�Ĺ�ϵ��fetch=FetchType.LAZY���Ա�ʾ�ڶ����һ��ͨ���ӳټ��صķ�ʽ���ض���(Ĭ�ϲ����ӳټ���)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(fetch=FetchType.LAZY) // ManyToOneָ���˶��һ�Ĺ�ϵ��fetch=FetchType.LAZY���Ա�ʾ�ڶ����һ��ͨ���ӳټ��صķ�ʽ���ض���(Ĭ�ϲ����ӳټ���)
	@JoinColumn(name="message_id")
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Like [like_id=" + like_id + ", user=" + user + ", message="
				+ message + "]";
	}
		
}
