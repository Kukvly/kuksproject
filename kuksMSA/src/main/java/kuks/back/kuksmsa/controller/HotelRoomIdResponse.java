package kuks.back.kuksmsa.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Objects;

public class HotelRoomIdResponse {
    @JsonProperty("id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long hotelRoomId;

    private HotelRoomIdResponse(Long hotelRoomId) {
        if(Objects.isNull(hotelRoomId))
            throw new IllegalArgumentException("hotelRoomId is null");

        this.hotelRoomId = hotelRoomId;
    }

    public static HotelRoomIdResponse from(Long hotelRoomId) {
        return new HotelRoomIdResponse(hotelRoomId);
    }
}
