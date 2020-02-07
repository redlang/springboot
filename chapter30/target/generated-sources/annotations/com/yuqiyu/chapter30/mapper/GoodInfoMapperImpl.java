package com.yuqiyu.chapter30.mapper;

import com.yuqiyu.chapter30.bean.GoodInfoBean;
import com.yuqiyu.chapter30.bean.GoodTypeBean;
import com.yuqiyu.chapter30.dto.GoodInfoDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-26T19:45:18+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
@Component
public class GoodInfoMapperImpl implements GoodInfoMapper {

    @Override
    public GoodInfoDTO from(GoodInfoBean good, GoodTypeBean type) {
        if ( good == null && type == null ) {
            return null;
        }

        GoodInfoDTO goodInfoDTO = new GoodInfoDTO();

        if ( good != null ) {
            if ( good.getId() != null ) {
                goodInfoDTO.setGoodId( String.valueOf( good.getId() ) );
            }
            goodInfoDTO.setGoodName( good.getTitle() );
            goodInfoDTO.setGoodPrice( good.getPrice() );
        }
        if ( type != null ) {
            goodInfoDTO.setTypeName( type.getName() );
        }

        return goodInfoDTO;
    }
}
