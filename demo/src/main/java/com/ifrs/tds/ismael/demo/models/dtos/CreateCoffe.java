package com.ifrs.tds.ismael.demo.models.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCoffe {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @DecimalMin(value = "0.1")
    private BigDecimal price;
}
