package com.example.springbootsecurity.auth;

import java.util.Optional;

public interface AppUserDao {

    Optional<AppUser> findAppUserByUsername(String username);
}
