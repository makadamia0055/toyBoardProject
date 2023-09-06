package com.ppl.toyboard.root.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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
	
	@Builder
	public BoardVO(int bo_num, String bo_title, String bo_content, Date bo_date, int bo_state, int bo_view, UserVO user,
			CategoryVO category) {
		super();
		this.bo_num = bo_num;
		this.bo_title = bo_title;
		this.bo_content = bo_content;
		this.bo_date = bo_date;
		this.bo_state = bo_state;
		this.bo_view = bo_view;
		this.user = user;
		this.category = category;
	}
	
	
	
}
