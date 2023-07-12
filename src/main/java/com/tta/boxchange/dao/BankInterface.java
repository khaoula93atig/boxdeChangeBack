package com.tta.boxchange.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tta.boxchange.entities.Bank;
import com.tta.boxchange.entities.Box;
import com.tta.boxchange.repositories.BankRepository;
import com.tta.boxchange.response.BasicResponse;

@Service
public class BankInterface {
	@Autowired
	BankRepository bankRepository;
	
	public BasicResponse AddBank(Bank bank) {
		try {
			bank.setIdBank("bk-" + org.apache.commons.lang.StringUtils.leftPad(String.valueOf(bankRepository.count() + 1), 3, "0"));
			bankRepository.save(bank);
			return new BasicResponse("Ajout bank a été effectué", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}
	
	public List<Bank> getAll(){
		return bankRepository.findAll();
	}
	
	public BasicResponse UpdateBank(String idbank,Bank bank) {
		try {
			Bank bankmodifier = bankRepository.findById(bank.getIdBank()).get();

	        if (bankmodifier != null) {
	        	bankRepository.save(bank);
	        }

            return new BasicResponse("ok", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

}
