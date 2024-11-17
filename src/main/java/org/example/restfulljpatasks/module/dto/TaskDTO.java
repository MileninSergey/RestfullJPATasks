package org.example.restfulljpatasks.module.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class TaskDTO {

    @Pattern(regexp = ".*[\\p{L}].*", message = "сообщение должно содержать хотя бы одну букву")
    @NotBlank
    @Size(min = 6,max = 16, message = "длинна поле не менее 6 и не более 16 знаков")

    private String title;

    @NotBlank
    private String description;

    private LocalDate createDate;

    private LocalDateTime implementTime;
}
