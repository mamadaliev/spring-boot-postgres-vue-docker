package com.github.egnaf.spring_boot_docker_example.transfer;

import lombok.Data;

@Data
public class UserDto {

    private long id;
    private String nickname;
    private String email;
}
