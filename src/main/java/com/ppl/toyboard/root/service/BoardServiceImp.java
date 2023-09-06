package com.ppl.toyboard.root.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppl.toyboard.root.dataAccess.BoardDA;
import com.ppl.toyboard.root.dto.BoardListDTO;
import com.ppl.toyboard.root.dto.InsertBoardDTO;
import com.ppl.toyboard.root.entity.Board;
import com.ppl.toyboard.root.mapStruct.BoardMapper;
import com.ppl.toyboard.root.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService {
	
	BoardDA boardDa;
	
	@Autowired
	public BoardServiceImp(BoardDA boardDa) {
		this.boardDa = boardDa;
	}
	@Override
	public void insertBoard(InsertBoardDTO boardDto) {
		//validation 나중에 추가
		boardDa.insertBoard(boardDto);
        
	}
	@Override
	public BoardListDTO getBoardList(){
		List<Board> entityList = boardDa.getBoardList();
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for(Board tmp: entityList) {
			boardList.add(BoardMapper.INSTANCE.toVO(tmp));
		}
		
		BoardListDTO blDto = new BoardListDTO();
		blDto.setBoardList(boardList);
		return blDto;
        
       
	}
}
