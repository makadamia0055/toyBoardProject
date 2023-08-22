package com.ppl.toyboard.root.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bt_boardtaglist")
public class BoardTagListVO {
	@Id
	@GeneratedValue
	private int bt_num;
}
