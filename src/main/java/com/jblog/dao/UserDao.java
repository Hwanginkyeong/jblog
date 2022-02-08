package com.jblog.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jblog.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//유저 정보 가져오기 (로그인 시 사용)
	public UserVo getUser(UserVo userVo) {
		System.out.println("[UserDao.getUser()]");
		System.out.println(userVo);
		
		UserVo authUser = sqlSession.selectOne("user.getUser", userVo);
		return authUser;
		
		
	}

}
