package com.experis.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    String movies = "";
    List<Movie> moviesList = getBestMovies();
    movies = moviesList.stream()
        .map(Movie::getName)
        .collect(Collectors.joining(", "));
    model.addAttribute("movies",movies);
    return "movies";
  }
  
  @GetMapping("/songs") public String songs(Model model){
    String songs = "";
    List<Song> songsList = getBestSongs();
    songs = songsList.stream()
        .map(Song::getName)
        .collect(Collectors.joining(", "));
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

