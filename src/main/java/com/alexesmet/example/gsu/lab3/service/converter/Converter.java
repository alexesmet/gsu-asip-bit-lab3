package com.alexesmet.example.gsu.lab3.service.converter;

import com.alexesmet.example.gsu.lab3.entity.EntityInterface;
import com.alexesmet.example.gsu.lab3.model.Model;

public interface Converter<E extends EntityInterface, M extends Model<E>> {
    E convert(M m);
    M convert(E e);
}
