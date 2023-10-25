package edu.spring.mall.controller;

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

import edu.spring.mall.domain.QnaBoardVO;
import edu.spring.mall.qnapageutil.PageCriteria;
import edu.spring.mall.qnapageutil.PageMaker;
import edu.spring.mall.qnaservice.QnaBoardService;

@Controller
@RequestMapping(value = "/qnaBoard")
public class BoardController {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private QnaBoardService qnaBoardService;
	
	@GetMapping("/qnaBoard")
	public void qnaBoardGET(Model model, Integer page, Integer numsPerPage) {
		logger.info("qnaBoardGET() ȣ��");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<QnaBoardVO> list = qnaBoardService.read(criteria);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(qnaBoardService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@GetMapping("/qnaDetail")
	public void detail(Model model, Integer qnaBoardId, Integer page) {
		logger.info("detail() ȣ�� : qnaBoardId = " + qnaBoardId);
		QnaBoardVO vo = qnaBoardService.read(qnaBoardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);		
	} // end detail()
	
	@GetMapping("/qnaRegister")
	public void registerGET() {
		logger.info("qnaRegisterGET()");
	} // end registerGET()
	
	@PostMapping("/qnaRegister")
	public String registerPOST(QnaBoardVO vo, RedirectAttributes reAttr) {
		logger.info("registerPOST() ȣ��");
		logger.info(vo.toString());
		int result = qnaBoardService.create(vo);
		logger.info(result + "�� ����");
		if(result == 1) {
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/qnaBoard/qnaBoard";
		} else {
			return "redirect:/qnaBoard/qnaRegister";
		}
	}
	
	@GetMapping("/qnaUpdate")
	public void updateGET(Model model, Integer qnaBoardId, Integer page) {
		logger.info("updateGET() ȣ�� : qnaBoardId = " + qnaBoardId);
		QnaBoardVO vo = qnaBoardService.read(qnaBoardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end updateGET()
	
	@PostMapping("/qnaUpdate")
	public String updatePOST(QnaBoardVO vo, Integer page) {
		logger.info("updatePOST() ȣ�� : vo " + vo.toString());
		int result = qnaBoardService.update(vo);
		
		if(result == 1) {
			return "redirect:/qnaBoard/qnaDetail?qnaBoardId=" + vo.getQnaBoardId();
		}else {
			return "redirect:/qnaBoard/qnaUpdate?qnaBoardId=" + vo.getQnaBoardId();
		}
	}
	
	@PostMapping("/delete")
	public String delete(Integer qnaBoardId) {
		logger.info("delete() ȣ�� : qnaBoardId = " + qnaBoardId);
		int result = qnaBoardService.delete(qnaBoardId);
		if(result == 1) {
			return "redirect:/qnaBoard/qnaBoard";
		} else {
			return "redirect:/qnaBoard/qnaBoard";
		}
	}
	
	
}












