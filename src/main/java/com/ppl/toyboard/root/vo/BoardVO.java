package com.ppl.toyboard.root.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bo_board")
public class BoardVO {
	@Id
	@GeneratedValue
	private int bo_num;
	private String bo_title;
	private String bo_content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date bo_date;
	private String bo_us_id;
	private int bo_ct_num;
	private int bo_state;
	
	public int getBo_num() {
		return bo_num;
	}
	public void setBo_num(int bo_num) {
		this.bo_num = bo_num;
	}
	public String getBo_title() {
		return bo_title;
	}
	public void setBo_title(String bo_title) {
		this.bo_title = bo_title;
	}
	public String getBo_content() {
		return bo_content;
	}
	public void setBo_content(String bo_content) {
		this.bo_content = bo_content;
	}
	public Date getBo_date() {
		return bo_date;
	}
	public void setBo_date(Date bo_date) {
		this.bo_date = bo_date;
	}
	public String getBo_us_id() {
		return bo_us_id;
	}
	public void setBo_us_id(String bo_us_id) {
		this.bo_us_id = bo_us_id;
	}
	public int getBo_ct_num() {
		return bo_ct_num;
	}
	public void setBo_ct_num(int bo_ct_num) {
		this.bo_ct_num = bo_ct_num;
	}
	public int getBo_state() {
		return bo_state;
	}
	public void setBo_state(int bo_state) {
		this.bo_state = bo_state;
	}
	
	
	
}
