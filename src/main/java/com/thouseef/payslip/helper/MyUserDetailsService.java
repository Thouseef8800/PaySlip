package com.thouseef.payslip.helper;

import com.thouseef.payslip.entity.Employee;
import com.thouseef.payslip.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employee user = repo.findByEmail(username);
        if(user == null) {
            System.out.println("User Not found");
            throw new UsernameNotFoundException("User Not found");
        }

        return new UserPrincipal(user);
    }
}
