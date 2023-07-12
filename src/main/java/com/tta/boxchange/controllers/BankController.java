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

import com.tta.boxchange.dao.BankInterface;
import com.tta.boxchange.entities.Bank;
import com.tta.boxchange.entities.Box;
import com.tta.boxchange.response.BasicResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	BankInterface bankInterface;
	
	@GetMapping
	public List<Bank> findAll() {

		return bankInterface.getAll();
	}

	@PostMapping("/save")
	public BasicResponse save(@RequestBody Bank bank) {
		return bankInterface.AddBank(bank);
	}

	@PutMapping("/update/{idbank}")
	public BasicResponse update(@PathVariable("idbank") String idBank,@RequestBody Bank bank) {
		return bankInterface.UpdateBank(idBank,bank);
	}

}
