package com.ohgiraffers.section02.javaconfig.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section02.javaconfig.model.MenuMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getJavaSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getJavaSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectAllMenu();
        sqlSession.close();
        return menuList;

    }

    public List<MenuDTO> selectMenuByCode(int code) {
        SqlSession sqlSession = getJavaSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectMenuByCode(code);
        sqlSession.close();
        return menuList;
    }

    public boolean insertMenu(MenuDTO menu) {
        SqlSession sqlSession = getJavaSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menu);
        if(result > 0) sqlSession.commit();
        else sqlSession.rollback();
        sqlSession.close();
        return result > 0;
    }

    public boolean updateMenu(MenuDTO menu) {
        SqlSession sqlSession = getJavaSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menu);
        if(result > 0) sqlSession.commit();
        else sqlSession.rollback();
        sqlSession.close();
        return result > 0;
    }

    public boolean deleteMenu(int code) {
        SqlSession sqlSession = getJavaSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenuByCode(code);
        if(result > 0) sqlSession.commit();
        else sqlSession.rollback();
        sqlSession.close();
        return result > 0;
    }
}
