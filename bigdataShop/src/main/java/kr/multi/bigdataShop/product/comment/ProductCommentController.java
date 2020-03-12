package kr.multi.bigdataShop.product.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

	@Controller
	public class ProductCommentController {
	@Autowired
	ProductCommentService service;
	
	@RequestMapping(value="/comment/write.do", method=RequestMethod.POST)
	public String insert(ProductCommentDTO comment) {
	System.out.println("**************"+comment);
	int result = service.insert(comment);
	System.out.println("########################"+result);
	return "redirect:/product/read.do?prd_no="+comment.prd_no;
	}
}
