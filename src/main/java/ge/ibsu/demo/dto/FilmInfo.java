package ge.ibsu.demo.dto;

import jakarta.persistence.Column;

public class FilmInfo {
    private String title;

    private String releaseYear;
    private String category;

    public FilmInfo(String title, String releaseYear, String category) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
