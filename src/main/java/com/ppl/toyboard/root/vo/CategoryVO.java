package com.ppl.toyboard.root.vo;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ct_category")
public class CategoryVO {
	@Id
	@GeneratedValue
	private int ct_num;
	private String ct_name;

	@OneToMany(mappedBy = "category")
	private ArrayList<BoardVO> boardList;
}
