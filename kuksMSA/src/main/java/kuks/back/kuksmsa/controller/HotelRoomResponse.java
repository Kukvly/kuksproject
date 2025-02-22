package kuks.back.kuksmsa.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Getter
public class HotelRoomResponse {
    @JsonProperty("id")
    @JsonSerialize(using=ToStringSerializer.class)

    private final long hotelRoomId;

    private final String roomNumber;

    private final HotelRoomType hotelRoomType;

    @JsonSerialize(using=ToDollarStringSerializer.class)
    private final BigDecimal originalPrice;

    private final List<Reservation> reservations;

    private HotelRoomResponse(Long hotelRoomId, String roomNumber,
                              HotelRoomType hotelRoomType, BigDecimal originalPrice) {

        this.hotelRoomId = hotelRoomId;
        this.roomNumber = roomNumber;
        this.hotelRoomType = hotelRoomType;
        this.originalPrice = originalPrice;
        reservations = new ArrayList<>();
    }

    public static HotelRoomResponse of(){

    }

    public void reservedAt(LocalDate reservedAt){

    }

    @Getter
    private static class Reservation {

    }
}
