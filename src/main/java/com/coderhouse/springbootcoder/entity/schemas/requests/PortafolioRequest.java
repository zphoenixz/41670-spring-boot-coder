package com.coderhouse.springbootcoder.entity.schemas.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PortafolioRequest extends UsuarioRequest{
    private String dirección;
    private String urlAvatar;
}

