package com.ljf.entity;

import java.io.Serializable;

public class Picture implements Serializable{
	
	private String id;
	private String path; //路径
	private String type;	//类型
	private String time;	//插入时间
	private String url;
	private String grade;	//另一个外键
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Picture [id=" + id + ", path=" + path + ", type=" + type + ", time=" + time + ", ulr=" + url
				+ ", grade=" + grade + "]";
	}
	
	

}
