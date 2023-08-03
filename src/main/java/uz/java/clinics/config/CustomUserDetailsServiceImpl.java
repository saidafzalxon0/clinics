package uz.java.clinics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import uz.java.clinics.entity.Admin;
import uz.java.clinics.repository.AdminRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService{

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsernameAndRole(String username, String role) throws UsernameNotFoundException {
        if (role.equals("USER")) {

        } else if (role.equals("ADMIN")) {
            Optional<Admin> admin = adminRepository.findFirstByLogin(username);
            if (admin.isPresent()) {
                Set<SimpleGrantedAuthority> authorities = new HashSet<>();
                authorities.add(new SimpleGrantedAuthority("ADMIN"));

                return new org.springframework.security.core.userdetails.User(admin.get().getUsername(), admin.get().getPassword(), authorities);
            }
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadUserByUsernameAndRole(username, null);
    }
}
