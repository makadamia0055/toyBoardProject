package com.ppl.toyboard.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ppl.toyboard.root.vo.BoardVO;


@Controller
public class HomeController {
	@Autowired
	EntityManagerFactory emf;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {

        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // �Խñ� �߰�
            BoardVO board = new BoardVO();
            board.setBo_title("JPA ����");
            board.setBo_us_id("������");
            board.setBo_content("JPA �� ���� �׽�Ʈ");
            board.setBo_date(new Date());

            em.persist(board);

            tx.commit();

            // �� ��� ��ȸ
            String jpql = "select b from BoardVO b order by b.bo_num desc";
            List<BoardVO> boardList = em.createQuery(jpql, BoardVO.class).getResultList();
            
            mv.addObject("boardList", boardList);

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        mv.setViewName("home");
		return mv;
	}
	
}
