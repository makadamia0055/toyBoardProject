package com.ppl.toyboard.root.vo;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bo_board")
@Data
@NoArgsConstructor
public class BoardVO {
	@Id
	@GeneratedValue
	private int bo_num;
	private String bo_title;
	private String bo_content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date bo_date;
	private int bo_state;
	
	@ManyToOne
	@JoinColumn(name="bo_us_id")
	private UserVO user;
	
	@ManyToOne
	@JoinColumn(name="bo_ct_num")
	private CategoryVO category;
	
	@OneToMany(mappedBy = "board")
	private ArrayList<BoardFilesVO> boardFilesList;
	
	@OneToMany(mappedBy = "board")
	private ArrayList<BoardVoteVO> boardVoteList;
	
	@OneToMany(mappedBy = "board")
	private ArrayList<BoardTagsVO> boardTagsList;
	
	@OneToMany(mappedBy = "board")
	private ArrayList<CommentVO> commentList;
	
	public void setUser(UserVO user) {
		if(this.user==null) {
			this.user = user;
			user.getBoardList().add(this);
		}
	}
	
	public void setCategory(CategoryVO category) {
		if(this.category!=null)
			this.category.getBoardList().remove(this);
		this.category = category;
		category.getBoardList().add(this);
		
	}
	
}
