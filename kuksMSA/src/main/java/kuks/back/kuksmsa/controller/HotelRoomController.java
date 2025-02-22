package kuks.back.kuksmsa.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@RestController
public class HotelRoomController {
    @GetMapping(path="/hotels/{hotelId}/rooms/{roomNumber}")
    public HotelRoomResponse getHotelRoomByPeriod(
            @PathVariable Long hotelId,
            @PathVariable String roomNumber,
            @RequestParam(value="fromDate", required = false)
            @DateTimeFormat(pattern="yyyyMMdd") LocalDate fromDate,
            @RequestParam(value="toDate", required = false)
            @DateTimeFormat(pattern="yyyyMMdd") LocalDate toDate
    )
        {
            Long hotelRoomId = IdGenerator.create();
            BigDecimal originalPrice = new BigDecimal("130.00");

            HotelRoomResponse response = HotelRoomResponse.of(hotelRoomId,
            roomNumber, HotelRoomType.Double, originalPrice);

            if(Objects.nonNull(fromDate) && Objects.nonNull(toDate))
                fromDate.datesUntil(toDate.plusDats(1)).forEach(date -> response.reservedAt(date));
            return response;
        }

        @DeleteMapping()
    public DeleteResultResponse deleteHotelRoom(){

        }
    }
