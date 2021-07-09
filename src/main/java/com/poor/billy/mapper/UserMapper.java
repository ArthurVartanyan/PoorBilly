package com.poor.billy.mapper;

import com.poor.billy.model.user.User;
import com.poor.billy.security.jwt.JWTUser;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(JWTUser.class, User.class)
                .byDefault()
                .register();
    }
}