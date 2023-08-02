package uz.java.clinics.service;

import uz.java.clinics.dto.AdminDto;
import uz.java.clinics.dto.ResponseDto;

import java.util.List;

public interface AdminService {

    ResponseDto<String> signIn(AdminDto adminDto);

    ResponseDto<AdminDto> signUp(AdminDto adminDto);

    ResponseDto<AdminDto> update(AdminDto adminDto);

    ResponseDto<List<AdminDto>> getAll();

    ResponseDto<AdminDto> delete(Long id);
}
