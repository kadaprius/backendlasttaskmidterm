package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.FilmInfo;
import ge.ibsu.demo.entities.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("select new ge.ibsu.demo.dto.FilmInfo(f.title, f.releaseYear, f.film_category) From Films f where f.title = :title and " +
            "concat(f.releaseYear, concat(' ', f.film_category)) like :searchValue")
    Page<FilmInfo> searchFilmInfo(@Param("searchValue") String searchValue, Pageable pageable);
}
