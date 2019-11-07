package dmacc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Exercise;
import dmacc.repository.ExerciseRepository;

@Controller
public class WebController {

	@Autowired
	ExerciseRepository repo;
	
	@GetMapping("/viewexercises")public String viewExercises(Model model) {
		model.addAttribute("exercise", repo.findAll());
		return "viewexercises";
		}
	
	@GetMapping("/inputexercise")public String addExercise(Model model) {
		Exercise e = new Exercise();
		model.addAttribute("exercise", e);
		return "inputexercise";
		}
	
	@PostMapping("/inputexercise")public String addExercise(@ModelAttribute Exercise e, Model model) {
		repo.save(e);
		model.addAttribute("exercise", repo.findAll());
		return "viewexercises";
		}
	
	@GetMapping("/delete/{id}")public String deleteExercise(@PathVariable("id") long id, Model model) {
		Exercise e= repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid exercise" + id));
		repo.delete(e);
		model.addAttribute("exercise", repo.findAll());
		return "viewexercises";
		}

	@GetMapping("/edit/{id}")public String updateExercise(@PathVariable("id") long id, Model model) {
		Exercise e = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Exercise Id:" + id));
		model.addAttribute("exercise", e);
	    return "updateexercise";
	}
	
	@PostMapping("/update/{id}")public String updateExercise(@PathVariable("id") long id, @Valid Exercise e, BindingResult result, Model model) {
		if(result.hasErrors()) {
			e.setExerciseid(id);
			return "updateexercise";}
		repo.save(e);
		model.addAttribute("exercise", repo.findAll());
		return "viewexercises";
		}
}
