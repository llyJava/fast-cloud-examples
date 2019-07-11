package com.fastcloud.fastcloud.auth.security;

import com.fastcloud.fastcloud.auth.entity.FastCloudUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Describe:
 *
 * @Author sunliang
 * @Since 2019/07/10
 */
@Slf4j
public class FastCloudUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    // 这里的username 可以是username、mobile、email
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("表单登录用户名:" + username);
        return buildUser(username);
    }

    private UserDetails buildUser(String userId) {
        // 根据用户名查找用户信息
        //根据查找到的用户信息判断用户是否被冻结
        //TODO
        FastCloudUser mermaidUser = new FastCloudUser();
        log.info("数据库密码是:" + mermaidUser.getPassword());
        return new User(mermaidUser.getUsername(),passwordEncoder.encode(mermaidUser.getPassword()),mermaidUser.getAuthorities());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
