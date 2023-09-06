package com.ppl.toyboard.root.dto;

import java.util.List;

import com.ppl.toyboard.root.vo.BoardVO;

import lombok.Data;

@Data
public class BoardListDTO {
	List<BoardVO> boardList;
}
