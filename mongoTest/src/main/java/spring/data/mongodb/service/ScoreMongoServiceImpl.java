package spring.data.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.data.mongodb.dao.ScoreMongoDAO;
import spring.data.mongodb.dto.ScoreDTO;

@Repository
public class ScoreMongoServiceImpl implements ScoreMongoService {
	@Autowired
	ScoreMongoDAO dao;
	@Override
	public ScoreDTO findById(String key, String value) {
		// TODO Auto-generated method stub
		return dao.findById(key, value);
	}

	@Override
	public void insertDocument(ScoreDTO doc) {
		dao.insertDocument(doc);
	}

	@Override
	public void insertAllDocument(List<ScoreDTO> docs) {
		dao.insertAllDocument(docs);
	}
	
	//search메소드
	@Override
	public List<ScoreDTO> findCriteria(String key, String value) {
		return dao.findCriteria(key, value);
	}

	@Override
	public List<ScoreDTO> findAll() {
		return dao.findAll();
	}

	@Override
	public List<ScoreDTO> findAll(int pageNo) {
		return dao.findAll(pageNo);
	}

	@Override
	public void update(ScoreDTO document) {
		dao.update(document);

	}

}
