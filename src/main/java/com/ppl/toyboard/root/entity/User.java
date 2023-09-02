package com.ppl.toyboard.root.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="us_user")
@Data
@NoArgsConstructor
public class User {
	@Id
	private String us_id;
	private String us_pw;
	private String us_nickname;
	private int us_auth;
	
	@OneToMany(mappedBy = "user")
	private List<Board> boardList;
	
	@OneToMany(mappedBy = "user")
	private List<Comment> commentList;
	
	@OneToMany(mappedBy = "user")
	private List<BoardVote> boardVoteList;

	@Builder
	User(String us_id, String us_pw, String us_nickname, int us_auth){
		this.us_id = us_id;
		this.us_pw = us_pw;
		this.us_nickname = us_pw;
		this.us_auth = us_auth;
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(us_id, other.us_id) && Objects.equals(us_pw, other.us_pw);
	}

	
	
}
