package com.coderhouse.springbootcoder.entity.schemas.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {
    @NotBlank(message = "se requiere el campo nombre")
    private String nombre;
    @NotBlank(message = "se requiere el campo nombre")
    @Pattern(regexp = "^[0-9]*$", message = "se requiere solo numeros para el celular")
    private String celular;
    @Min(value=18, message = "La edad mínima es 18")
    @Max(value=100, message = "La edad máxima es 100")
    private Integer edad;
}

