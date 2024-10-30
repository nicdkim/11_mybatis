package com.ohgiraffers.section02.javaconfig.model;

import com.ohgiraffers.dto.MenuDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {

    @Results(id = "menuResultMap", value = {
            @Result(id = true, property = "code", column = "MENU_CODE"),
            @Result(property = "name", column = "MENU_NAME"),
            @Result(property = "price", column = "MENU_PRICE"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "orderable_status", column = "ORDERABLE_STATUS")
    })
    @Select("SELECT MENU_CODE\n"  +
            ", MENU_NAME \n"      +
            ", MENU_CODE \n"      +
            ", CATEGORY_CODE \n"  +
            ", ORDERABLE_STATUS \n" +
            " FROM TBL_MENU \n" +
            " WHERE ORDERABLE_STATUS = 'Y'")
    List<MenuDTO> selectAllMenu();

    @Select("SELECT MENU_CODE, " +
            "MENU_NAME, " +
            "MENU_PRICE, " +
            "CATEGORY_CODE, " +
            "ORDERABLE_STATUS " +
            "FROM TBL_MENU " +
            "WHERE MENU_CODE = #{code}")
    @ResultMap("menuResultMap")
    List<MenuDTO> selectMenuByCode(int code);

    @Insert("INSERT INTO TBL_MENU(" +
            "MENU_NAME, MENU_PRICEM CATEGORY_CODE, ORDERABLE_STATUS" +
            ")VALUES (" +
            "#{name}, #{price}, #{categoryCode}, 'Y')")
    int insertMenu(MenuDTO menu);

    @Update("UPDATE TBL_MENU" +
            "SET MENU_NAME = #{name}," +
            "    MENU_PRICE = ${price}," +
            "    CATEGORY_CODE = #{categoryCode}," +
            "WHERE MENU_CODE = #{code}")
    int updateMenu(MenuDTO menu);

    @Delete("DELETE FROM TBL_MENU WHERE MENU_CODE = #{code}")
    int deleteMenuByCode(int code);

}
