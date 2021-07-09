package com.poor.billy.mapper;

import com.poor.billy.dto.SpendingDTO;
import com.poor.billy.model.operation.Spending;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class SpendingMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(Spending.class, SpendingDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(SpendingDTO.class, Spending.class)
                .byDefault()
                .register();
    }
}