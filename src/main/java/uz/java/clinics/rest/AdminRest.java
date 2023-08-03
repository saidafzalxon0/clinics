package uz.java.clinics.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.java.clinics.dto.AdminDto;
import uz.java.clinics.dto.ResponseDto;
import uz.java.clinics.service.AdminService;
import java.util.List;


@RestController
@RequestMapping("/admin")
public record AdminRest(AdminService service) {

    @PostMapping("/sign-in")
   private ResponseDto<String> signIn(@Valid @RequestBody AdminDto adminDto){

    return service.signIn(adminDto);
   }
    @PostMapping("/sign-up")
   private ResponseDto<AdminDto> signUp(@Valid @RequestBody AdminDto adminDto){
       return service.signUp(adminDto);
   }

   @PatchMapping("/edit")
    private ResponseDto<AdminDto> update(@Valid @RequestBody AdminDto adminDto){
       return service.update(adminDto);
    }
    @GetMapping("/get")
    private ResponseDto<List<AdminDto>> getAll(){
       return service.getAll();
    }

    @DeleteMapping("/{id}")
    private ResponseDto<AdminDto> delete(@NotNull @PathVariable Long id){
       return service.delete(id);
    }
}
