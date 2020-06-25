package cn.com.nanfeng.cloud.sevice.impl;

import cn.com.nanfeng.cloud.exception.BussinessException;
import cn.com.nanfeng.cloud.exception.ExceptionEnum;
import cn.com.nanfeng.cloud.mapper.CdUsersMapper;
import cn.com.nanfeng.cloud.model.po.CdUsers;
import cn.com.nanfeng.cloud.sevice.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-25 22:49
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Resource
    private CdUsersMapper usersMapper;


    @Override
    public List<CdUsers> getUser() {
        try {
            List<CdUsers> usersList = usersMapper.selectAllUser();
            return usersList;
        }catch (Exception e){
            e.printStackTrace();
            log.error("UserServiceImpl -> getUser -  服务器内部错误");
            throw new BussinessException(ExceptionEnum.AUTH10500.code(),ExceptionEnum.AUTH10001.message());
        }
    }
}
