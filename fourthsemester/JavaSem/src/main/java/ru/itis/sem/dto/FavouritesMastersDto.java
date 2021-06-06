package ru.itis.sem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.sem.model.FavouritesMasters;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavouritesMastersDto {
    private Long userId;
    private Long masterId;

    public static FavouritesMastersDto from(FavouritesMasters favouritesMasters){
        return FavouritesMastersDto.builder()
                .userId(favouritesMasters.getUser().getId())
                .masterId(favouritesMasters.getMaster().getId())
                .build();
    }

    public static List<FavouritesMastersDto> from(List<FavouritesMasters> favouritesMastersList){
        return favouritesMastersList.stream()
                .map(FavouritesMastersDto::from)
                .collect(Collectors.toList());
    }
}
