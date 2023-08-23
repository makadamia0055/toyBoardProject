package com.ppl.toyboard.root.vo;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tg_tag")
public class TagVO {
	@Id
	@GeneratedValue
	private int tg_tagnum;
	private String tg_tagname;
	@OneToMany(mappedBy = "tag")
	private ArrayList<BoardTagsVO> boardTagList;
}
