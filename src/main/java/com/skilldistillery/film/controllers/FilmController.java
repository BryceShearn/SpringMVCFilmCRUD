package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDAO;

	@RequestMapping(path = { "/", "home.do" })
	public String home() {
		return "WEB-INF/views/index.jsp";
	}

	@RequestMapping(path = "updatefilm.do")
	public ModelAndView updateFilm(int filmID, String title, String description, Integer releaseYear, Integer languageId,
			Integer rentalDuration, Double rentalRate, Integer length, Double replacementCost, String rating,
			String specialFeatures) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("updatedFilm", filmDAO.updateFilm(filmID, title, description, releaseYear, languageId, rentalDuration,
				rentalRate, length, replacementCost, rating, specialFeatures));
		mv.setViewName("WEB-INF/views/UpdateAddResults.jsp");

		return mv;
	}

	@RequestMapping(path = "addfilm.do")
	public ModelAndView addFilm(Film film) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("WEB-INF/views/AddFilmForm.jsp");

		return mv;
	}
	@RequestMapping(path = "addfilmresult.do")
	public ModelAndView addFilmResult(Film film) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("film", filmDAO.findFilmById(filmDAO.createFilm(film).getId()));
		mv.setViewName("WEB-INF/views/AddFilmResult.jsp");

		return mv;
	}

	@RequestMapping(path = "searchid.do")
	public ModelAndView searchById(int id) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.findFilmById(id);
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/SearchFilmByIdResult.jsp");
		return mv;
	}

	@RequestMapping(path = "searchkeyword.do")
	public ModelAndView searchByKeyword(String keyword) {
		List<Film> films = filmDAO.findFilmByKeyword(keyword);
		ModelAndView mv = new ModelAndView();
		mv.addObject("films", films);
		mv.setViewName("WEB-INF/views/SearchFilmByKeywordResult.jsp");

		return mv;

	}

	@RequestMapping(path = "updatefilmform.do")
	public ModelAndView UpdateFilmForm(int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", filmDAO.findFilmById(id));
		mv.setViewName("WEB-INF/views/UpdateFilmForm.jsp");
		return mv;
	}

	@RequestMapping(path = "deleteresult.do")
	public ModelAndView deletedResults(int id) {
		ModelAndView mv = new ModelAndView();
		boolean deletedBool = filmDAO.deleteFilm(id);
		mv.addObject("deletedBool", deletedBool);
		mv.setViewName("WEB-INF/views/DeleteFilmResult.jsp");
		return mv;
	}

	@RequestMapping(path="updatefilmresult.do")
	public ModelAndView showUpdatedFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		filmDAO.updateFilm(film.getId(),film.getTitle() , film.getDescription(), film.getReleaseYear(), film.getLanguageId(), film.getRentalDuration(), film.getRentalRate(), film.getLength(), film.getReplacementCost(), film.getRating(), film.getSpecial_features());
		mv.addObject("film", filmDAO.findFilmById(film.getId()));
		mv.setViewName("WEB-INF/views/UpdateFilmResult.jsp");
		return mv;
	}

	@RequestMapping(path = "returntomain.do")
	public String returnToMain() {
		return "WEB-INF/views/index.jsp";
	}
}
