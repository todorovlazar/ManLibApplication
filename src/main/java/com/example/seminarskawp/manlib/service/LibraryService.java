package com.example.seminarskawp.manlib.service;

import com.example.seminarskawp.manlib.model.Library;
import com.example.seminarskawp.manlib.model.LibraryCoordinates;

import java.util.List;
import java.util.Optional;

public interface LibraryService {

    List<Library> findAll();

    Library findById(Long id);

    Library findByName(String name);

    Library save(String name, String location, LibraryCoordinates coordinates, List<Long> books, List<Long> users);

    Library edit(Long id, String name, String location, LibraryCoordinates coordinates, List<Long> books, List<Long> users);

    List<Library> findLibrariesByBook(Long bookId);

    void deleteById(Long id);
}
