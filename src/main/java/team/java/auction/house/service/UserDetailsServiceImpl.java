package team.java.auction.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import team.java.auction.house.domain.MyUserDetails;
import team.java.auction.house.domain.UserEntity;
import team.java.auction.house.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByLogin(login);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), new BCryptPasswordEncoder().encode(user.get().getPassword()), getGrantedAuth(user.get()));
//        return new MyUserDetails(user.get());
    }

    private Collection<? extends GrantedAuthority> getGrantedAuth(UserEntity user) {
        return new MyUserDetails(user).getAuthorities();
    }
}
