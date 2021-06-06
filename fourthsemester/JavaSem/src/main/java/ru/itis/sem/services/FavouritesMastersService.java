package ru.itis.sem.services;

import ru.itis.sem.model.FavouritesMasters;

import java.util.List;

public interface FavouritesMastersService  {

    void addToFavourites(Long userId, Long masterId);

    FavouritesMasters findFavouritesByMasterId(Long id);

    List<FavouritesMasters> findFavouritesByUserId(Long id);

    void deleteFavouritesById(Long id);
}
