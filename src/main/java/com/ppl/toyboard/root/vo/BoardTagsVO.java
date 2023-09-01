package com.ppl.toyboard.root.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BoardTagsVO {
	private int bt_num;
	private BoardVO board;
	private TagVO tag;
	
	
}
