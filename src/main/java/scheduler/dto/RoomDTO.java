package scheduler.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import scheduler.entity.RoomEntity;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    @NonNull
    private String code;
    
    public RoomDTO(RoomEntity roomEntity){
        this.code = roomEntity.getCode();
    }
}
