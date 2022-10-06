package com.coderhouse.springbootcoder.entity.schemas.responses;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private Instant timestamp;
    private T data;
    private int respondeCode;
    private String status;
}
