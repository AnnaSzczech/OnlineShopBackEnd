package team.java.auction.house.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class MyUserDetails implements UserDetails, Principal {
    @Getter
    private final UserEntity user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
//        return Arrays.asList(authority);
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
//        return new BCryptPasswordEncoder().encode(user.getPassword());
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String getName() {
        return user.getUsername();
    }
}
