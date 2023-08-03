package uz.java.clinics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.java.clinics.entity.Admin;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findFirstByLogin(String login);

    Optional<Admin> findFirstByLoginAndPassword(String login,String password);
}
