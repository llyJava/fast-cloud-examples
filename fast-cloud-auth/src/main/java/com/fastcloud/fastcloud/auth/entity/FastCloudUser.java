package com.fastcloud.fastcloud.auth.entity;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Describe:
 *
 * @Author sunliang
 * @Since 2019/07/10
 */
@Data
public class FastCloudUser implements Serializable {
    private static final long serialVersionUID = 4989309292401711788L;

    private Long id;

    private String username;

    private String password;

    @Transient
    private Set<GrantedAuthority> authorities = new HashSet<>();

    public FastCloudUser() {
        this.username = "user";
        this.password = "12345678";
    }

    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> userAuthotities = new HashSet<>();
        userAuthotities.add(new SimpleGrantedAuthority("管理员(Admin)"));
        return userAuthotities;
    }
}
