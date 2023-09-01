package com.ppl.toyboard.root.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CategoryVO {
	
	private int ct_num;
	private String ct_name;

	private List<BoardVO> boardList;
}
