package com.ppl.toyboard.root.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BoardVO {
	
	private int bo_num;
	private String bo_title;
	private String bo_content;
	private Date bo_date;
	private int bo_state;
	private int bo_view;
	
	
	
	private UserVO user;
	private CategoryVO category;
	
	
	public int getBoardVote() {
		int sum = 0;
		for(BoardVoteVO tmp : this.boardVoteList) {
			sum+=tmp.getBv_state();
		}
		return sum;
	}
	
}
