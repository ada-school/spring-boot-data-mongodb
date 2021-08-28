package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceHashMap
    implements UserService
{

    private final HashMap<String, User> usersMap = new HashMap<>();


    @Override
    public User create( User user )
    {
        usersMap.put( user.getId(), user );
        return user;
    }

    @Override
    public Optional<User> findById( String id )
    {
        if ( usersMap.containsKey( id ) )
        {
            return Optional.ofNullable(usersMap.get( id ));
        }
        return Optional.empty();
    }

    @Override
    public List<User> all()
    {
        return new ArrayList<>( usersMap.values() );
    }

    @Override
    public boolean deleteById( String id )
    {
        return usersMap.remove( id ) != null;
    }

    @Override
    public User update( UserDto userDto, String id )
    {
        if ( usersMap.containsKey( id ) )
        {
            User user = usersMap.get( id );
            user.update( userDto );
            return user;
        }
        else
        {
            return null;
        }
    }


}
