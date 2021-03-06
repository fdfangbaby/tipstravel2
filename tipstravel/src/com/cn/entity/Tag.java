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
	private Set<Topic_Tag> topic_Tag;
	
	@OneToMany(mappedBy="tt_tag",cascade=CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.EXTRA)
	@JsonIgnore
	public Set<Topic_Tag> getTopic_Tag() {
		return topic_Tag;
	}

	@JsonIgnore
	public void setTopic_Tag(Set<Topic_Tag> topic_Tag) {
		this.topic_Tag = topic_Tag;
	}

	public Tag(){
		tag_message=new HashSet<Tag_Message>();
	}
	
	@OneToMany(mappedBy="tm_tag",cascade=CascadeType.REMOVE)
	@LazyCollection(LazyCollectionOption.EXTRA) //LazyCollection属性设置成EXTRA指定了当如果查询数据的个数时候，只会发出一条 count(*)的语句，提高性能
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

	@Override
	public String toString() {
		return "Tag [tag_id=" + tag_id + ", tag_name=" + tag_name
				+ ", tag_message=" + tag_message + ", topic_Tag=" + topic_Tag
				+ "]";
	}

	
}
