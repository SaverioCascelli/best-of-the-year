package com.experis.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/")
public class BestOfYearController {
  
  @GetMapping
  public String home(Model model){
    model.addAttribute("name","Saverio");
    return "home";
  }
  
  @GetMapping("/movies")
  public String movies(Model model){
//    String movies = "";
//    List<Movie> moviesList = getBestMovies();
//    movies = moviesList.stream()
//        .map(Movie::getName)
//        .collect(Collectors.joining(", "));
    List<Movie> movies = getBestMovies();
    model.addAttribute("movies",movies);
    
    return "movies";
  }
  
  @GetMapping("/movie/{id}")
  public String movieById(Model model, @PathVariable("id") int movieId){
    String founded = null;
    List<Movie> movieList = getBestMovies();
    Movie movieSearch = movieList.stream()
        .filter(movie -> movie.getId() == movieId)
        .findFirst()
        .orElse(null);
  
    if (movieSearch == null) {
      founded = "Not Founded";
    } else {
      founded = movieSearch.getName();
    }
    
    model.addAttribute("movieDetail" ,founded);
    
    return "showmovie";
  }
  
  @GetMapping("/song/{id}")
  public String songById(Model model, @PathVariable("id") int songId){
    String founded = null;
    List<Song> songList =getBestSongs();
    Song songSearch = songList.stream()
        .filter(movie -> movie.getId() == songId)
        .findFirst()
        .orElse(null);

    if (songSearch== null) {
      founded = "Not Founded";
    } else {
      founded = songSearch.getName();
    }
    model.addAttribute("songDetail" ,founded);
    return "showsong";
  }
  
  @GetMapping("/songs") public String songs(Model model){
//    String songs = "";
//    List<Song> songsList = getBestSongs();
//    songs = songsList.stream()
//        .map(Song::getName)
//        .collect(Collectors.joining(", "));
    List<Song> songs = getBestSongs();
    model.addAttribute("songs",songs);
    return "songs";
  }
  
  private List<Movie> getBestMovies(){
    List<Movie> movies = new ArrayList<>();
    
    movies.add(new Movie("Movie1",10));
    movies.add(new Movie("Movie2",11));
    movies.add(new Movie("Movie3",12));
    return movies;
  }
  private List<Song> getBestSongs(){
    List<Song> songs = new ArrayList<>();
    
    songs.add(new Song("Song1",20));
    songs.add(new Song("Song2",21));
    songs.add(new Song("Song3",22));
    return songs;
  }
}

