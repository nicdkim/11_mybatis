package com.ohgiraffers.section01.xmlconfig.model;

import com.ohgiraffers.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {


    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }


    public List<MenuDTO> selectMenuByCode(SqlSession sqlSession, String code) {
        return sqlSession.selectList("MenuMapper.selectMenuByCode", code);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, String code) {
        return sqlSession.delete("MenuMapper.deleteMenu", code);
    }
}
