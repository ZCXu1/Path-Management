package com.hust.hospital.service;

import com.hust.hospital.entity.Variation;

public interface VariationService {
    public Variation getVariationById(String id);

    public void addVariation(Variation v);

    public void updateVariation(Variation v);
}
