package com.memorynotfound.ldap.jpa;

import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Entry(
        base = "dc=memorynotfound,dc=com",
        objectClasses = { "person", "inetOrgPerson", "top" })
@Data
public final class User {
    @Id
    private Name id;

    private @Attribute(name = "cn") String username;
    private @Attribute(name = "sn") String lastName;
    private @Attribute(name = "phone") String phone;
    private @Attribute(name = "email") String email;
}
