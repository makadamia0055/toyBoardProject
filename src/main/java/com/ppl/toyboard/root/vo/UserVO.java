package com.ppl.toyboard.root.vo;

import java.util.List;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserVO {
	@Id
	private String us_id;
	private String us_pw;
	private String us_nickname;
	private int us_auth;
	private List<BoardVO> boardList;
	private List<CommentVO> commentList;
	private List<BoardVoteVO> boardVoteList;

	
	
	
}
