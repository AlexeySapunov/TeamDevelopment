package ru.gb.controler;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gb.controler.dto.RoleDto;

@Component
public class StringToRoleDtoConverter implements Converter<String, RoleDto> {

    @Override
    public RoleDto convert(String source) {
        String[] arr = source.split(";");
        return new RoleDto(Long.parseLong(arr[0]), arr[1]);
    }
}
