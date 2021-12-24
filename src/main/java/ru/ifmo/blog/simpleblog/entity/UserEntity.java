package ru.ifmo.blog.simpleblog.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table("users")
public class UserEntity {
    @With
    @Id
    private Long id;
    private String name;
    private String login;
    @ToString.Exclude
    @With
    private String password;
    private LocalDateTime createdAt;
    private Integer age;
}
