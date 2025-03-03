package kuks.back.kuksmsa.controller;

import kuks.back.kuksmsa.domain.HotelRoomType;
import lombok.Getter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Getter
@ToString
public class HotelRoomUpdateRequest {

    @NotNull(message="roomType can't be null")
    private HotelRoomType roomType;

    @NotNull(message="originalPrice can't be null")
    @Min(value=0, message="originalPrice must be larger than 0")
    private BigDecimal originalPrice;

}
