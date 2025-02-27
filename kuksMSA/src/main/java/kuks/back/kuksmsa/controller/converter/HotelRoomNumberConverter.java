package kuks.back.kuksmsa.controller.converter;

import kuks.back.kuksmsa.domain.HotelRoomNumber;

public class HotelRoomNumberConverter implements Converter<String, HotelRoomNumber> {
    @Override
    public HotelRoomNumber convert(String source){
        return HotelRoomNumber.parse(source);
    }
}
