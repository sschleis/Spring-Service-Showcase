package de.dev.schleis.showcase.service;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil
{
    @Test
    public void test()
    {
        final BCryptPasswordEncoder standardPasswordEncoder = new BCryptPasswordEncoder();
        final String geheim = standardPasswordEncoder.encode("geheim");
        System.out.println(geheim);
    }
}
