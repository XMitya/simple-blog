package ru.ifmo.blog.simpleblog.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {
    @With
    private Long id;
    private String name;
    private String login;
    @ToString.Exclude
    @With
    private String password;
    private LocalDateTime createdAt;
    private Integer age;
}
