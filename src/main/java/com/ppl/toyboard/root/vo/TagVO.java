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
public class TagVO {
	
	private int tg_tagnum;
	private String tg_tagname;
	private List<BoardTagsVO> boardTagsList;
}
