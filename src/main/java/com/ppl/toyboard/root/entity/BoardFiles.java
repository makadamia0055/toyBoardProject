package com.ppl.toyboard.root.entity;

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
public class BoardFiles {
	@Id
	@GeneratedValue
	private int bf_num;
	private String bf_fileurl;
	private String bf_ori_filename;
	
	@ManyToOne
	@JoinColumn(name="bf_bo_num")
	private Board board;
	
	public void setBoard(Board board) {
		// �ϴ� ���� ������ ��� ©�� ���� �ϴ� ����� �⺻���� �ڵ常
		this.board = board;
		board.getBoardFilesList().add(this);
	}
}
