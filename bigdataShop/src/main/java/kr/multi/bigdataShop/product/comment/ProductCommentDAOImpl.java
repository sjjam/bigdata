package kr.multi.bigdataShop.product.comment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCommentDAOImpl implements ProductCommentDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(ProductCommentDTO comment) {
		return sqlSession.insert("kr.multi.bigdataShop.product.comment.insert", comment);
	}
}
