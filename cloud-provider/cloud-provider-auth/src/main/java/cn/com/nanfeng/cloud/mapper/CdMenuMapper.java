package cn.com.nanfeng.cloud.mapper;

import cn.com.nanfeng.cloud.model.po.CdMenu;
import cn.com.nanfeng.cloud.model.po.CdUsers;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @author liutap
 * @date 2020/06/20
 */
@Mapper
public interface CdMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CdMenu record);

    int insertSelective(CdMenu record);

    CdMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdMenu record);

    int updateByPrimaryKey(CdMenu record);

    /**
     * 查询当前用户所菜单
     * @param userId
     * @return
     */
    Set<String> selectMenuByUserId(@Param("userId")Integer userId);
}