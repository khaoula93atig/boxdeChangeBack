package com.tta.boxchange.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.boxchange.dao.BoxInterface;
import com.tta.boxchange.entities.Box;
import com.tta.boxchange.response.BasicResponse;

@RestController
@RequestMapping("/box")
public class BoxController {
	@Autowired
	BoxInterface boxInterface;

	@GetMapping
	public List<Box> findAll() {

		return boxInterface.findAll();
	}
/*
	@GetMapping("/specialite/{id}")
	public List<News> findByIDSpecialite(@PathVariable("id") int idSpecialite) {

		return newsInterface.findByIDSpecialite(idSpecialite);
	}
*/
	@PostMapping("/save")
	public BasicResponse save(@RequestBody Box box) {
		return boxInterface.save(box);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody Box box) {
		return boxInterface.update(box);
	}
	/*
	// categorie 1 ou 2 ou 3 idSpecialite exemple "9ef9bb4a9aff49259acf95306f42886b"
	@GetMapping("/service/{categorie}/{idSpecialite}")
	public List<News> findByIDService(@PathVariable("categorie") int categorie,@PathVariable("idSpecialite") String idSpecialite) {

		return newsInterface.findByIDService(categorie,idSpecialite);
	}
*/

}
