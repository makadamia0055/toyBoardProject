package com.ppl.toyboard.root.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bf_boardfiles")
public class BoardFilesVO {
	@Id
	@GeneratedValue
	private int bf_num;
	private String bf_fileurl;
	private String bf_ori_filename;
}
