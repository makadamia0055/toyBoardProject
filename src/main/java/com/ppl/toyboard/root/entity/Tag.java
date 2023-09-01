package com.ppl.toyboard.root.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tg_tag")
@Data
@NoArgsConstructor
public class Tag {
	@Id
	@GeneratedValue
	private int tg_tagnum;
	private String tg_tagname;
	@OneToMany(mappedBy = "tag")
	private List<BoardTags> boardTagsList;
}
