package com.ppl.toyboard.root.vo;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="us_user")
public class UserVO {
	@Id
	private String us_id;
	private String us_pw;
	private String us_nickname;
	private int us_auth;
	
	@OneToMany(mappedBy = "user")
	private ArrayList<BoardVO> boardList;
	
	@OneToMany(mappedBy = "user")
	private ArrayList<CommentVO> commentList;
}
