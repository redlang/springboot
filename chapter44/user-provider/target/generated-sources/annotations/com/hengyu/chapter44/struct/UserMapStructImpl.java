package com.hengyu.chapter44.struct;

import com.hengyu.chapter44.entity.UserDetailDTO;
import com.hengyu.chapter44.entity.UserInfoEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-26T19:52:24+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class UserMapStructImpl implements UserMapStruct {

    @Override
    public UserDetailDTO fromUserEntity(UserInfoEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDetailDTO userDetailDTO = new UserDetailDTO();

        userDetailDTO.setUserId( user.getUserId() );
        userDetailDTO.setUserName( user.getUserName() );
        userDetailDTO.setNickName( user.getNickName() );
        userDetailDTO.setAge( user.getAge() );
        userDetailDTO.setAddress( user.getAddress() );

        return userDetailDTO;
    }
}
