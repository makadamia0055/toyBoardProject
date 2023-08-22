package com.ppl.toyboard.root.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cm_boardcomment")
public class BoardCommentVO {
	@Id
	@GeneratedValue
	private int cm_num;
	@Temporal(TemporalType.TIMESTAMP)
	private Date cm_date;
	private String cm_content;
	private int cm_state;
	
}
