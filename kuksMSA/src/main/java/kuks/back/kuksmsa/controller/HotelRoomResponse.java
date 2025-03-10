package kuks.back.kuksmsa.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import kuks.back.kuksmsa.domain.HotelRoomType;
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

    public static HotelRoomResponse of(Long hotelRoomId, String roomNumber,
                            HotelRoomType hotelRoomType, BigDecimal originalPrice) {
        return new HotelRoomResponse(hotelRoomId, roomNumber, hotelRoomType, originalPrice);

    }

    public void reservedAt(LocalDate reservedAt){
        reservations.add(new Reservation(IdGenerator.create(), reservedAt));
    }

    @Getter
    private static class Reservation {
        @JsonProperty("Id")
        @JsonSerialize(using = ToStringSerializer.class)
        private final Long reservationId;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
        private final LocalDate reservedAt;

        public Reservation(Long reservationId, LocalDate reservedAt){
            this.reservationId = reservationId;
            this.reservedAt = reservedAt;
        }
    }
}
