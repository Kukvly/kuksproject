package kuks.back.kuksmsa.domain.reservation;

import org.apache.coyote.BadRequestException;

import java.time.LocalDate;

public class ReserveService {
    public Long reserveHotelRoom(Long hotelId, String roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
        hotelRoomRepository.findByHotelIdAndRoomNumber(hotelId, roomNumber)
                .orElseThrow(() -> {
                    log.error("Invalid roomNumber. hotelId:{}, roomNumber:{}", hotelId, roomNumber);

                    return new BadRequestException("Not existing roomNumber");
                });
    }
}
