package com.ppl.toyboard.root.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bv_boardvote")
public class BoardVoteVO {
	@Id
	@GeneratedValue
	private int bv_num;
	private boolean bv_state;
	
}
