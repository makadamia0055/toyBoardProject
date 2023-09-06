package com.ppl.toyboard.root.service;

import java.util.List;

import com.ppl.toyboard.root.dto.BoardListDTO;
import com.ppl.toyboard.root.dto.InsertBoardDTO;
import com.ppl.toyboard.root.entity.Board;
import com.ppl.toyboard.root.vo.BoardVO;

public interface BoardService {

	BoardListDTO getBoardList();

	void insertBoard(InsertBoardDTO boardDto);

}
