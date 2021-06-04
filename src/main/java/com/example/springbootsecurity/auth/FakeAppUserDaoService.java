package com.example.springbootsecurity.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.springbootsecurity.security.AppUserRole.*;

@Repository("fake")
public class FakeAppUserDaoService implements AppUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeAppUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<AppUser> findAppUserByUsername(String username) {
        return getAppUsers().stream()
                .filter(appUser -> username.equals(appUser.getUsername()))
                .findFirst();
    }

    private List<AppUser> getAppUsers() {
        List<AppUser> appUsers = Lists.newArrayList(
            new AppUser(
                    "franz",
                    passwordEncoder.encode("pass"),
                    STUDENT.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),
            new AppUser(
                    "sofia",
                    passwordEncoder.encode("pass"),
                    ADMIN.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),
            new AppUser(
                    "tom",
                    passwordEncoder.encode("pass"),
                    TRAINEE.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            )
        );

        return appUsers;
    }
}
