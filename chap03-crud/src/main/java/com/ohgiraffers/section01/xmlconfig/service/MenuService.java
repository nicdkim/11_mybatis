package com.ohgiraffers.section01.xmlconfig.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.MenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();
        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
        sqlSession.close();
        return menuList;
    }

    public List<MenuDTO> selectMenuByCode(String code) {

        SqlSession sqlSession = getSqlSession();
        List<MenuDTO> menuList = menuDAO.selectMenuByCode(sqlSession, code);
        sqlSession.close();
        return menuList;

    }

    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();
        int result = menuDAO.insertMenu(sqlSession,menu);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();
        int result = menuDAO.updateMenu(sqlSession, menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

    public boolean deleteMenu(String code) {
        SqlSession sqlSession = getSqlSession();
        int result = menuDAO.deleteMenu(sqlSession, code);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }
}
