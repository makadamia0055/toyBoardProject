package com.ppl.toyboard.root.dataAccess;

import java.util.List;

import com.ppl.toyboard.root.dto.InsertBoardDTO;
import com.ppl.toyboard.root.entity.Board;

public interface BoardDA {

	void insertBoard(InsertBoardDTO boardDto);

	List<Board> getBoardList();

}
