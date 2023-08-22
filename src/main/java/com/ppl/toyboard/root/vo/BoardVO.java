package com.ppl.toyboard.root.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private int bo_state;
	@ManyToOne
	@JoinColumn(name="bo_us_id")
	private UserVO user;
	@ManyToOne
	@JoinColumn(name="bo_ct_num")
	private CategoryVO category;
	
	
	
	
}
