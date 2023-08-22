package com.ppl.toyboard.root.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ct_category")
public class CategoryVO {
	@Id
	@GeneratedValue
	private int ct_num;
	private String ct_name;

}
