package com.nttdata.BC21.ActiveProduct.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class BaseModel {
    @Id
    private String id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
