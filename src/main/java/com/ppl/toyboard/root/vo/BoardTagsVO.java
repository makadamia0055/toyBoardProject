package com.ppl.toyboard.root.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bt_boardtaglist")
@Data
@NoArgsConstructor
public class BoardTagsVO {
	@Id
	@GeneratedValue
	private int bt_num;
	@ManyToOne
	@JoinColumn(name="bt_bo_num")
	private BoardVO board;
	@ManyToOne
	@JoinColumn(name="bt_tg_tagnum")	
	private TagVO tag;
}
