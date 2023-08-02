package uz.java.clinics.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import uz.java.clinics.dto.ResponseDto;

import java.util.HashMap;
import java.util.Map;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String message){
        super(message);
    }

}
