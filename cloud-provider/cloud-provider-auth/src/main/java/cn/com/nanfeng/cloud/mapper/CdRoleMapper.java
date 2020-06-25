package cn.com.nanfeng.cloud.mapper;

import cn.com.nanfeng.cloud.model.po.CdRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liutap
 * @date 2020/06/20
 */
@Mapper
public interface CdRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CdRole record);

    int insertSelective(CdRole record);

    CdRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CdRole record);

    int updateByPrimaryKey(CdRole record);

    /**
     * 通过用户id查询角色
     * @param userId
     * @return
     */
    List<CdRole> selectRoleByUserId(@Param("userId") Integer userId);


}