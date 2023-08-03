package uz.java.clinics.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.java.clinics.dto.AdminDto;
import uz.java.clinics.entity.Admin;

@Mapper(componentModel = "spring")
public abstract class AdminMapper implements CommonMapper<AdminDto, Admin>{

    @Autowired
    protected PasswordEncoder passwordEncoder;

   @Mapping(target = "password",expression = "java(passwordEncoder.encode(adminDto.getPassword()))")
    public abstract Admin toEntity(AdminDto adminDto);
}
