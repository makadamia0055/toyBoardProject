package com.ppl.toyboard.root.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppl.toyboard.root.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService {
	
	EntityManagerFactory emf;
	
	@Autowired
	public BoardServiceImp(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public void insertBoard(BoardVO board) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            //게시글 검증과정 이후 추가
            
            em.persist(board);

            tx.commit();


        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
	}
	public List<BoardVO> getBoardList(){
		EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

        // 
        String jpql = "select b from BoardVO b order by b.bo_num desc";
        List<BoardVO> boardList = em.createQuery(jpql, BoardVO.class).getResultList();
        return boardList;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
	}
}
