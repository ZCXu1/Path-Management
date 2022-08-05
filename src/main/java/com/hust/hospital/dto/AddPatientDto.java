package com.hust.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPatientDto {
    private String id;

    private String name;

    private Integer bed;

}

