package uz.java.clinics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import uz.java.clinics.repository.AdminRepository;

@Configuration
public class ApplicationConfig {

    @Autowired
    private AdminRepository adminRepository;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> adminRepository.findFirstByLogin(username)
    }
}
