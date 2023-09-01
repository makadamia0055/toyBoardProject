package com.ppl.toyboard.root.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bv_boardvote")
@Data
@NoArgsConstructor
public class BoardVoteVO {
	@Id
	@GeneratedValue
	private int bv_num;
	private int bv_state;
	
	@ManyToOne
	@JoinColumn(name="bv_bo_num")
	private BoardVO board;
	
	@ManyToOne
	@JoinColumn(name="bv_us_id")
	private UserVO user;
	
	public void setBoard(BoardVO board) {
		this.board = board;
		board.getBoardVoteList().add(this);
	}
	
	public void setUser(UserVO user) {
		this.user = user;
		user.getBoardVoteList().add(this);
	}
}
