package com.ohgiraffers.section03.remix.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section03.remix.model.MenuMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getJavaSqlSession;
import static com.ohgiraffers.common.Template.getRemixSession;

public class MenuService {


    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getRemixSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectAllMenu();
        sqlSession.close();
        return menuList;
    }

    public List<MenuDTO> selectMenuByCode(int code) {
        SqlSession sqlSession = getRemixSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuDTO = menuMapper.selectMenuByCode(code);

        sqlSession.close();
        return menuDTO;
    }

    public boolean insertMenu(MenuDTO menu) {
        SqlSession sqlSession = getRemixSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0;
    }

    public boolean updateMenu(MenuDTO menu) {
        SqlSession sqlSession = getRemixSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menu);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result > 0;
    }

    public boolean deleteMenu(int code) {
        SqlSession sqlSession = getRemixSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenuByCode(code);
        if(result > 0) sqlSession.commit();
        else sqlSession.rollback();
        sqlSession.close();
        return result > 0;

    }
}
