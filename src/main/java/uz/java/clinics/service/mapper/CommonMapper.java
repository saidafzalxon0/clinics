package uz.java.clinics.service.mapper;
public interface CommonMapper<D,E> {

    D toDto(E e);

    E toEntity(D d);
}

