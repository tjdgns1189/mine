package edu.spring.ex02.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.pageutil.PageMaker;
import edu.spring.ex02.service.BoardService;

@Controller // @Component
// * ǥ�� ����(Presentation Layer)
// - view(������)�� service�� �����ϴ� ����
// - request�� ���� response�� �����ϴ� ����
@RequestMapping(value="/board") // url : /ex02/board
public class BoardController {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/list") // views/board/list.jsp
	public void list(Model model, Integer page, Integer numsPerPage) {
		logger.info("list() ȣ��");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		
		// Paging ó��
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<BoardVO> list = boardService.read(criteria);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(boardService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
		
	}// end list()
	
	@GetMapping("/register")
	public void registerGET() {
		logger.info("registerGET()");
	} // end registerGET()
	
	@PostMapping("/register")
	public String registerPOST(BoardVO vo, RedirectAttributes reAttr) {
		// RedirectAttributes
		// - �����̷�Ʈ �� �����͸� �����ϱ� ���� �������̽�
		logger.info("registerPOST() ȣ��");
		logger.info(vo.toString());
		int result = boardService.create(vo);
		logger.info(result + "�� ����");
		if(result == 1) {
		reAttr.addFlashAttribute("insert_result", "success"); // �Ͻ��� ����.
		return "redirect:/board/list";	
		}else {
		return "redirect:/board/register";
		}
	} // end registerPOST()
	
	@GetMapping("/detail")
	public void detail(Model model, Integer boardId, Integer page) { // page ������ �ޱ����� , Integer page�߰�
		logger.info("detail() ȣ�� : boardId = " + boardId);
		BoardVO vo = boardService.read(boardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end detail()
	
	@GetMapping("/update")
	public void update(Model model, Integer boardId, Integer page) {
		logger.info("updateGET() ȣ�� : boardId = " + boardId);
		BoardVO vo = boardService.read(boardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end updateGET()
	
	@PostMapping("/update")
	public String updatePOST(BoardVO vo, Integer page) {
		logger.info("updatePOST() ȣ�� : vo = " + vo.toString());
		int result = boardService.update(vo);
		
		if(result == 1) {
			return "redirect:/board/list?page=" + page;
		}else {
			return "redirect:/board/update?boardId=" + vo.getBoardId(); // �����̷�Ʈ : �ּҹٲ�. 
		}	   
	} // end updatePOST()
	
	@PostMapping("/delete")
	public String delete(Integer boardId) {
		logger.info("delete()ȣ�� : boardId = " + boardId);
		int result = boardService.delete(boardId);
		if(result == 1) {
			return"redirect:/board/list";
		}else {
			return"redirect:/board/list";
		}
	}
	
} // end BoardController











