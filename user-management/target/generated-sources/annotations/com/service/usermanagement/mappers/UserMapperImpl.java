package com.service.usermanagement.mappers;

import com.service.usermanagement.dtos.UserCreateDto;
import com.service.usermanagement.dtos.UserDto;
import com.service.usermanagement.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-25T09:32:51+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public List<UserDto> userListToUserDtoList(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( user.size() );
        for ( User user1 : user ) {
            list.add( userToUserDto( user1 ) );
        }

        return list;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPhoneNumber( user.getPhoneNumber() );

        return userDto;
    }

    @Override
    public User userCreateDtoToUser(UserCreateDto user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setFirstName( user.getFirstName() );
        user1.setLastName( user.getLastName() );
        user1.setEmail( user.getEmail() );
        user1.setPhoneNumber( user.getPhoneNumber() );

        return user1;
    }
}
