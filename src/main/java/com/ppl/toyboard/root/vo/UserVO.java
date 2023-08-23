package com.ppl.toyboard.root.vo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="us_user")
@Data
@NoArgsConstructor
public class UserVO {
	@Id
	private String us_id;
	private String us_pw;
	private String us_nickname;
	private int us_auth;
	
	@OneToMany(mappedBy = "user")
	private List<BoardVO> boardList;
	
	@OneToMany(mappedBy = "user")
	private List<CommentVO> commentList;
	
	@OneToMany(mappedBy = "user")
	private List<BoardVoteVO> boardVoteList; 
}
