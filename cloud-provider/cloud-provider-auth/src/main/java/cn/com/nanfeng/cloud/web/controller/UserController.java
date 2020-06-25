package cn.com.nanfeng.cloud.web.controller;

import cn.com.nanfeng.cloud.common.WrapMapper;
import cn.com.nanfeng.cloud.common.Wrapper;
import cn.com.nanfeng.cloud.model.po.CdUsers;
import cn.com.nanfeng.cloud.sevice.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-25 22:48
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/getUser")
    public Wrapper getUser(){
        List<CdUsers> usersList = userService.getUser();
        return WrapMapper.ok(usersList);
    }

}
