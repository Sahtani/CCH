package com.youcode.services.api;

import java.util.List;

public interface GenericService<T, ID ,RequestDto, ResponseDto> {
    List<T> getAll();
    ResponseDto getById(ID id);
    ResponseDto save(ResponseDto responseDto);
    void delete(ID id);
}
