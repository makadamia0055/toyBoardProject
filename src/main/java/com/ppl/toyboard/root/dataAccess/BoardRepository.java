package com.ppl.toyboard.root.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ppl.toyboard.root.dto.InsertBoardDTO;
import com.ppl.toyboard.root.entity.Board;
import com.ppl.toyboard.root.mapStruct.BoardMapper;

@Transactional
@Repository
public class BoardRepository implements BoardDA {
	@PersistenceContext
	EntityManager em;

	@Override
	public void insertBoard(InsertBoardDTO boardDto) {
		Board board = BoardMapper.INSTANCE.toEntity(boardDto);
        em.persist(board);

	}

	@Override
	public List<Board> getBoardList() {
		String jpql = "select b from Board b order by b.bo_num desc";
        List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
        return boardList;
	}
	
}
