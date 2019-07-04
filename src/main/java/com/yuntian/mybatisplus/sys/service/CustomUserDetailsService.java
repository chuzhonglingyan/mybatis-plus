package com.yuntian.mybatisplus.sys.service;


import com.yuntian.mybatisplus.sys.model.entity.SysUser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Resource;

/**
 * @Auther: yuntian
 * @Date: 2019/7/2 0002 23:47
 * @Description:
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser user = new SysUser();
//        SysUser user = userService.g(username);

        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 添加权限


        // 返回UserDetails实现类
        return new User(user.getUserName(), user.getPassWord(), authorities);
    }
}
