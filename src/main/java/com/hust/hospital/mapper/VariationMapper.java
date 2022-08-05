package com.hust.hospital.mapper;

import com.hust.hospital.entity.Variation;

public interface VariationMapper {
    public Variation getVariationById(String id);

    public void addVariation(Variation v);

    public void updateVariation(Variation v);
}
