package kuks.back.kuksmsa.controller;

import kuks.back.kuksmsa.domain.HotelRoomType;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class HotelRoomRequest {
    private String roomNumber;
    private HotelRoomType roomType;
    private BigDecimal originalPrice;
}
