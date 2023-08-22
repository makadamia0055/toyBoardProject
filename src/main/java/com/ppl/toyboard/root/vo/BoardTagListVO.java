package com.ppl.toyboard.root.vo;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bt_boardtaglist")
public class BoardTagListVO {
	@Id
	@GeneratedValue
	private int bt_num;
	@ManyToOne
	@JoinColumn(name="bt_bo_num")
	private BoardVO board;
	@OneToMany
	@JoinColumn(name="bt_tg_tagnum")
	private ArrayList<TagsVO> tagList;
}
