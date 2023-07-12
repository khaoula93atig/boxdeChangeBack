package com.tta.boxchange.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tta.boxchange.entities.Box;
import com.tta.boxchange.entities.Proposition;
import com.tta.boxchange.repositories.BoxRepository;
import com.tta.boxchange.response.BasicResponse;

@Service
public class BoxInterface {
	@Autowired
	BoxRepository boxRespository;


	public BasicResponse AddBox(Box box) {
		try {
			box.setIdbox("box-" + org.apache.commons.lang.StringUtils.leftPad(String.valueOf(boxRespository.count() + 1), 4, "0"));
			box.setStatus("active");
			boxRespository.save(box);
			return new BasicResponse("Ajout box a été effectué", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}
	
	public List<Box> getAll(){
		return boxRespository.findAll();
	}
	
	public BasicResponse UpdateBox(String idbox,Box box) {
		try {
			Box boxAmodifier = boxRespository.findById(box.getIdbox()).get();

	        if (boxAmodifier != null) {
	        	boxRespository.save(box);
	        }

            return new BasicResponse("ok", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}
}
