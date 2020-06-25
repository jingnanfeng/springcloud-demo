package cn.com.nanfeng.cloud.sevice;

import cn.com.nanfeng.cloud.model.po.CdUsers;

import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-25 22:48
 */
public interface IUserService {

    /**
     * 查询所有的用户
     * @return
     */
    List<CdUsers> getUser();

}
