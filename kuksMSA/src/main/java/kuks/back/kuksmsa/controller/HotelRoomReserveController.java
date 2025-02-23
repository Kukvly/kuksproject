package kuks.back.kuksmsa.controller;

import kuks.back.kuksmsa.controller.validator.HotelRoomReserveValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelRoomReserveController {

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.addValidators(new HotelRoomReserveValidator());
    }

    @PostMapping(path="/hotels/{hotelId}/rooms/{roomNumber}/reserve")
    public ResponseEntity<HotelRoomIdResponse> reserveHotelRoomByRoomNumber(
            @PathVariable Long hotelId,
            @PathVariable String roomNumber,
            @Valid @RequestBody HotelRoomReserveRequest reserveRequest,
            BindingResult bindingResult){

        Long reservationId = reserveService.reserveHotelRoom(
            hotelId, roomNumber,
            reserveRequest.getCheckInDate(),
            reserveRequest.getCheckOutDate());

        HotelRoomIdResponse body = HotelRoomIdResponse.from(reservationId);

        return ResponseEntity.ok(body);
    }

}
