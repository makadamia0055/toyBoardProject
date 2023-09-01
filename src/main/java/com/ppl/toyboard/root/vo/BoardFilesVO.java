package com.ppl.toyboard.root.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BoardFilesVO {

	private int bf_num;
	private String bf_fileurl;
	private String bf_ori_filename;
	
	private BoardVO boardVo;
	
	
}
