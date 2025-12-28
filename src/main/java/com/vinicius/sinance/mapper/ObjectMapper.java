package com.vinicius.sinance.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return modelMapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObject(List<O> originList, Class<D> destination) {
        List<D> destinationList = new ArrayList<>();
        for(O origin : originList) {
            destinationList.add(modelMapper.map(origin, destination));
        }
        return destinationList;
    }

}
