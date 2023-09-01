package com.ppl.toyboard.root.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BoardVoteVO {
	
	private int bv_num;
	private int bv_state;
	
	private BoardVO board;
	
	private UserVO user;
	
	
}
