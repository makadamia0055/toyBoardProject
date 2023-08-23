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
@Table(name="bf_boardfiles")
@Data
@NoArgsConstructor
public class BoardFilesVO {
	@Id
	@GeneratedValue
	private int bf_num;
	private String bf_fileurl;
	private String bf_ori_filename;
	
	@ManyToOne
	@JoinColumn(name="bf_bo_num")
	private BoardVO board;
	
	public void setBoard(BoardVO board) {
		// 일단 향후 로직을 어떻게 짤지 몰라서 일단 여기는 기본적인 코드만
		this.board = board;
		board.getBoardFilesList().add(this);
	}
}
