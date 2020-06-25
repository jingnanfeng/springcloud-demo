package cn.com.nanfeng.cloud.mapper;

import cn.com.nanfeng.cloud.model.po.CdUsers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liutap
 * @date 2020/06/20
 */
@Mapper
public interface CdUsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CdUsers record);

    int insertSelective(CdUsers record);

    CdUsers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdUsers record);

    int updateByPrimaryKey(CdUsers record);

    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    CdUsers getUserByUsername(@Param("username") String username);

    /**
     * 查询所有的用户
     * @return
     */
    List<CdUsers> selectAllUser();
}