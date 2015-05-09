package com.cn.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="tag")
public class Tag {
	private int tag_id;
	private String tag_name;
	private Set<Tag_Message> tag_message;
	private Topic topic;
	
	@ManyToOne // ManyToOneָ���˶��һ�Ĺ�ϵ��fetch=FetchType.LAZY���Ա�ʾ�ڶ����һ��ͨ���ӳټ��صķ�ʽ���ض���(Ĭ�ϲ����ӳټ���)
	@JoinColumn(name="topic_id")
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Tag(){
		tag_message=new HashSet<Tag_Message>();
	}
	
	@OneToMany(mappedBy="tag",cascade=CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.EXTRA) //LazyCollection�������ó�EXTRAָ���˵������ѯ���ݵĸ���ʱ��ֻ�ᷢ��һ�� count(*)����䣬�������
	@JsonIgnore
	public Set<Tag_Message> getTag_message() {
		return tag_message;
	}

	@JsonIgnore
	public void setTag_message(Set<Tag_Message> tag_message) {
		this.tag_message = tag_message;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tag_id")
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	
	@Column(name="tag_name")
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	

}
