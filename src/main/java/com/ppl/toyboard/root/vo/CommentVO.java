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

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cm_comment")
@Data
@NoArgsConstructor
public class CommentVO {
	@Id
	@GeneratedValue
	private int cm_num;
	@Temporal(TemporalType.TIMESTAMP)
	private Date cm_date;
	private String cm_content;
	private int cm_state;
	@ManyToOne
	@JoinColumn(name="cm_bo_num")
	private BoardVO board;
	@ManyToOne
	@JoinColumn(name="cm_us_id")
	private UserVO user;
}
