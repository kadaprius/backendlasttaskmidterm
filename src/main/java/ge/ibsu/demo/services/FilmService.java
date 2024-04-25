package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.*;
import ge.ibsu.demo.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    public Page<FilmInfo> search(SearchFilm searchFilm, Paging paging) {
        String searchText = searchFilm.getSearchText() != null ? "%" + searchFilm.getSearchText() + "%" : "";
        Pageable pageable = PageRequest.of(paging.getPage() - 1, paging.getSize(), Sort.by("id").descending());
        return filmRepository.searchFilmInfo(searchText, pageable);
    }
}
