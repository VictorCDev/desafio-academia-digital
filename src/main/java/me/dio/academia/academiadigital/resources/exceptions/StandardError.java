package me.dio.academia.academiadigital.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    private Integer status;
    private Long timestamp;
    private String message;


}
