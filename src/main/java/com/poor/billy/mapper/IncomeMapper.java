package com.poor.billy.mapper;

import com.poor.billy.dto.IncomeDTO;
import com.poor.billy.model.operation.Income;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class IncomeMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(Income.class, IncomeDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(IncomeDTO.class, Income.class)
                .byDefault()
                .register();
    }
}