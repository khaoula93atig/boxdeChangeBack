package com.tta.boxchange.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.tta.boxchange.entities.ExcelData;
import com.tta.boxchange.entities.Enchere;
import com.tta.boxchange.services.ExcelImportService;
import com.tta.boxchange.repositories.EnchRepository;
import com.tta.boxchange.repositories.ExcelDataRepository;
@CrossOrigin("*")
@RequestMapping("/excel")
@RestController
public class ExcelImportController {
  private final ExcelImportService excelImportService;
  @Autowired
	ExcelDataRepository excelDataRepository;

  public ExcelImportController(ExcelImportService excelImportService) {
    this.excelImportService = excelImportService;
  }

  /*@PostMapping("/import")
  public void handleFileImport(@RequestParam("file") MultipartFile file) throws IOException {
    int originalCount = excelImportService.countRows();
    excelImportService.importData(file.getInputStream());
    int newCount = excelImportService.countRows();
   
    }*/
  @GetMapping("/import")
public void exeldata()
{
	excelImportService.loadConfigs();
	
}
  @GetMapping("/all")
	public List<ExcelData> findAlldataExcel() {

		//return enchereInterface.findAllNull();
		System.out.println(excelDataRepository.findAll());
		return excelDataRepository.findAll();
	}
}
  


