package com.vishwa.mbs.services.impl;

import com.vishwa.mbs.entities.Theatre;
import com.vishwa.mbs.exceptions.TheatreDetailsNotFoundException;
import com.vishwa.mbs.services.TheatreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Override
    public Theatre acceptTheatreDetails(Theatre theatre) {
        return null;
    }

    @Override
    public Theatre getTheatreDetails(int id) throws TheatreDetailsNotFoundException {
        return null;
    }

    @Override
    public Theatre updateTheatreDetails(int id, Theatre theatre) throws TheatreDetailsNotFoundException {
        return null;
    }

    @Override
    public boolean deleteTheatre(int id) throws TheatreDetailsNotFoundException {
        return false;
    }

    @Override
    public List<Theatre> getAllTheatreDetails() {
        return null;
    }
}
