package ru.boris.ex_website_api.entity.dto;

import lombok.Data;

@Data
public class RegDto {
    private String login;
    private String password;
    private String confirm;
}
