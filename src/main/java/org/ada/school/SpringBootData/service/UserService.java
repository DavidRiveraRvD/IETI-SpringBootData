package org.ada.school.SpringBootData.service;

import org.ada.school.SpringBootData.dto.UserDto;
import org.ada.school.SpringBootData.model.User;

import java.util.List;

public interface UserService
{
    User create( User user );

    User findById( String id );

    List<User> all();

    boolean deleteById( String id );

    User update( UserDto userDto, String id );
}
