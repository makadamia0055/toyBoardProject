package com.ppl.toyboard.root.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CommentVO {
	
	private int cm_num;
	private Date cm_date;
	private String cm_content;
	private int cm_state;
	
	
	private BoardVO board;
	private UserVO user;
	
	
}
