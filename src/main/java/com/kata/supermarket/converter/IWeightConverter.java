package com.kata.supermarket.converter;

import com.kata.supermarket.type.WeightUnity;

public interface IWeightConverter {
    default float getRate(WeightUnity fromUnity, WeightUnity toUnity) {
        return 1;
    }

}
