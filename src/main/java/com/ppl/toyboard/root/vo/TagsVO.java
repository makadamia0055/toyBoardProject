package com.ppl.toyboard.root.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tg_tags")
public class TagsVO {
	@Id
	@GeneratedValue
	private int bt_tagnum;
	private String bt_tagname;
	
}
