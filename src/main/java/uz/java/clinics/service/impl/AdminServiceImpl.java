package uz.java.clinics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.java.clinics.config.JwtService;
import uz.java.clinics.dto.AdminDto;
import uz.java.clinics.dto.ResponseDto;
import uz.java.clinics.entity.Admin;
import uz.java.clinics.exeption.DatabaseException;
import uz.java.clinics.repository.AdminRepository;
import uz.java.clinics.service.AdminService;
import uz.java.clinics.service.mapper.AdminMapper;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository repository;
    @Autowired
    private AdminMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Override
    public ResponseDto<String> signIn(AdminDto adminDto) {
        Optional<Admin> admin = repository.findFirstByLoginAndPassword(adminDto.getLogin(), adminDto.getPassword());
        var jwtToken = jwtService.generateToken(admin.get());
        return ResponseDto.<String>builder().data(jwtToken).status("success").build();
    }

    @Override
    public ResponseDto<AdminDto> signUp(AdminDto adminDto) {
        Optional<Admin> find = repository.findFirstByLogin(adminDto.getLogin());
        if(find.isPresent()){
            throw new DatabaseException("Login is already exists");
        }
        return ResponseDto.<AdminDto>builder().status("success").data(mapper.toDto(repository.save(mapper.toEntity(adminDto)))).build();

    }

    @Override
    public ResponseDto<AdminDto> update(AdminDto adminDto) {
        Optional<Admin> find = repository.findById(adminDto.getId());
        if(find.isEmpty()){
            throw new DatabaseException("Admin not found");
        }
        return ResponseDto.<AdminDto>builder().status("success").data(mapper.toDto(repository.save(mapper.toEntity(adminDto)))).build();
    }

    @Override
    public ResponseDto<List<AdminDto>> getAll() {
        return ResponseDto.<List<AdminDto>>builder().status("success").data(repository.findAll().stream().map(mapper::toDto).toList()).build();
    }

    @Override
    public ResponseDto<AdminDto> delete(Long id) {
        Optional<Admin> find = repository.findById(id);
        if(find.isEmpty()){
            throw new DatabaseException("Admin not found");
        }
        repository.deleteById(id);
        return ResponseDto.<AdminDto>builder().status("success").data(find.map(mapper::toDto).get()).build();
    }
}
