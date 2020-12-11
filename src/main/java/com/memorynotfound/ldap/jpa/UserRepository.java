package com.memorynotfound.ldap.jpa;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends LdapRepository<User> {
    User findByUsername(String username);

    List<User> findByEmail(String email);

    List<User> findByPhone(String phone);

    List<User> findByUsernameLikeIgnoreCase(String username);
}
