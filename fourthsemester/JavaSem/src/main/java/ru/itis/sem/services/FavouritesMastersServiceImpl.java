package ru.itis.sem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.sem.model.FavouritesMasters;
import ru.itis.sem.repositories.FavouritesMastersRepository;

import java.util.List;

@Service
public class FavouritesMastersServiceImpl implements FavouritesMastersService {
    @Autowired
    private FavouritesMastersRepository favouritesMastersRepository;

    public FavouritesMastersServiceImpl(FavouritesMastersRepository favouritesMastersRepository) {
        this.favouritesMastersRepository = favouritesMastersRepository;
    }

    @Override
    public void addToFavourites(Long userId, Long masterId) {
        favouritesMastersRepository.saveFavourites(userId, masterId);
    }

    @Override
    public FavouritesMasters findFavouritesByMasterId(Long id) {
        return favouritesMastersRepository.findByMasterId(id);
    }

    @Override
    public List<FavouritesMasters> findFavouritesByUserId(Long id) {
        return favouritesMastersRepository.findByUserId(id);
    }

    @Override
    public void deleteFavouritesById(Long id) {
        favouritesMastersRepository.deleteById(id);
    }
}
