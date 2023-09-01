package com.ppl.toyboard.root.entity;

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
public class BoardVote {
	@Id
	@GeneratedValue
	private int bv_num;
	private int bv_state;
	
	@ManyToOne
	@JoinColumn(name="bv_bo_num")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name="bv_us_id")
	private User user;
	
	public void setBoard(Board board) {
		this.board = board;
		board.getBoardVoteList().add(this);
	}
	
	public void setUser(User user) {
		this.user = user;
		user.getBoardVoteList().add(this);
	}
}
