package ge.ibsu.demo.controllers;
import ge.ibsu.demo.dto.*;
import ge.ibsu.demo.services.FilmService;
import ge.ibsu.demo.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;

public class FilmController extends BaseController {
    private final FilmService filmService;
    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }
    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = {"application/json"})
    public Page<FilmInfo> search(@RequestBody RequestData<SearchFilm> rd) throws Exception {
        GeneralUtil.checkRequiredProperties(rd.getData(), Arrays.asList("searchText"));
        return filmService.search(rd.getData(), rd.getPaging());
    }
}
