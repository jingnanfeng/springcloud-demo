package cn.com.nanfeng.cloud.sevice;

import cn.com.nanfeng.cloud.exception.BussinessException;
import cn.com.nanfeng.cloud.exception.ExceptionEnum;
import cn.com.nanfeng.cloud.mapper.CdMenuMapper;
import cn.com.nanfeng.cloud.mapper.CdUsersMapper;
import cn.com.nanfeng.cloud.model.po.CdUsers;
import cn.com.nanfeng.cloud.model.vo.UserVO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-20 20:46
 */
@Service
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    @Resource
    private CdUsersMapper cdUsersMapper;
    @Resource
    private CdMenuMapper cdMenuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户
        CdUsers user = cdUsersMapper.getUserByUsername(username);
        if (user == null){
            log.error("CustomUserDetailService -> loadUserByUsername - user不存在");
            throw new BadCredentialsException("用户不存在");
        }
        //通过用户id查询角色
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        //查询用户下有哪些菜单权限
        Set<String> menuUrlSet = cdMenuMapper.selectMenuByUserId(user.getId());
        menuUrlSet.stream().forEach(menuUrl ->
                grantedAuthoritySet.add(new SimpleGrantedAuthority(menuUrl)));
        //将user转成json
        UserVO userVO = UserVO.builder().id(user.getId()).email(user.getEmail()).username(username).build();
        String principal = JSON.toJSONString(userVO);
        return new User(
                principal,
                user.getPassword(),
                true,true,true,true,
                grantedAuthoritySet);
    }
}
