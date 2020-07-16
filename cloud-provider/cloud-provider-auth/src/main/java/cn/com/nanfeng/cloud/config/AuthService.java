package cn.com.nanfeng.cloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-07-16 12:06
 */
@Component("authService")
@Slf4j
public class AuthService {

    public static final String EXCLUDDE_URL = "/oauth/token";

    public static final String ANONYMOU_SUSER = "anonymousUser";

    /**
     * 查询是否有权限
     * @param request
     * @param authentication
     * @return
     */
    public boolean hasAccess(HttpServletRequest request, Authentication authentication){

        Object ss = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Object principal = authentication.getPrincipal();
        if (principal == null || ANONYMOU_SUSER.equals(principal)){
            return false;
        }
        //查询当前的url
        String requestURI = request.getRequestURI();
        if (requestURI.contains(EXCLUDDE_URL)){
            return true;
        }
        //查询用户权限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Set<String> menuUrlSet = new HashSet<>();
        for (GrantedAuthority authority : authorities) {
            String menuUrl = authority.getAuthority();
            menuUrlSet.add(menuUrl);
        }
        //如果包含请求的url,证明请求有权限
        if (menuUrlSet.contains(requestURI)){
            return true;
        }
        return false;
    }

}
