package com.youcode.services.api;

import com.youcode.dtos.response.TeamResponseDTO;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID ,RequestDto, ResponseDto> {
    List<ResponseDto> getAll();

    Optional<ResponseDto> getById(ID id);
    ResponseDto save(RequestDto requestDto);
    ResponseDto update(Long id,RequestDto requestDto);
    void delete(ID id);

}
