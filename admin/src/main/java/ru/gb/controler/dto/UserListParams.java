package ru.gb.controler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserListParams {

    private String usernameFilter;

    private Integer minAge;

    private Integer maxAge;

    private Integer page;

    private Integer size;

    private String sortField;
}
