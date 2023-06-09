package com.tta.boxchange.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/box")
public class BoxController {
	@Autowired
	BoxInterface boxInterface;

	@GetMapping
	public List<Box> findAll() {

		return boxInterface.getAll();
	}

	@PostMapping("/save")
	public BasicResponse save(@RequestBody Box box) {
		return boxInterface.AddBox(box);
	}

	@PutMapping("/update/{idbox}")
	public BasicResponse update(@PathVariable("idbox") String idBox,@RequestBody Box box) {
		return boxInterface.UpdateBox(idBox,box);
	}
	

}
