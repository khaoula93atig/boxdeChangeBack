package com.tta.boxchange.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SysexMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tta.boxchange.entities.ExcelData;
import com.tta.boxchange.entities.ExcelData;
import com.tta.boxchange.mappers.ExcelDataRowMapper;
import com.tta.boxchange.repositories.ExcelDataRepository;

@Service
public class ExcelImportService {
	
  private final JdbcTemplate jdbcTemplate;
  @Autowired
   ExcelDataRepository dataRepository;

  public ExcelImportService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
	public List<ExcelData> findAlldataExcel() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT id, bankname, data, devisename FROM public.excel_data;", new ExcelDataRowMapper());

	}
  /*public void importData(InputStream inputStream) throws IOException {
    List<ExcelData> dataList = readExcelData(inputStream);
    for (ExcelData data : dataList) {
      jdbcTemplate.update("INSERT INTO excel_data (column1, column2, column3, column4, column5) VALUES (?, ?, ?, ?, ?)", data.getColumn1(), data.getColumn2(),data.getColumn3(),data.getColumn4(),data.getColumn5());
    }
  }

  public int countRows() {
	    return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM excel_data", Integer.class);
	  }

	  private List<ExcelData> readExcelData(InputStream inputStream) throws IOException {
	    // Use Apache POI to read the data from the Excel sheet
	    List<ExcelData> dataList = new ArrayList<>();
	    // Add code here to read the data and populate the dataList
	    return dataList;
	  }*/
  public  void loadConfigs() {
      try {
          BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("https://docs.google.com/spreadsheets/d/e/2PACX-1vSYdGCYOIb4V5mJYObYdmJ5OwOpd6XdY6rcl-mtqtG-w1QO_X-3aHSiExrWr9San3ffu__sRxsb-1UB/pub?output=csv").openConnection().getInputStream()));
          String line = "";
          int counter = 5;
          String bankname ="stb";
          //String name = 
          
          
          while((line = reader.readLine()) != null) {
     
              counter++;
              String[] content = null;
              try {
                  content = line.split(",");
                  if(content.length == 0) {
                      continue;
                  }
                  String word = content[4];
                  String devise=content[2];
                  if (!(word.equals("COURS ACH")))
                  {                
                  //save database
                	  
                  ExcelData data = new ExcelData( bankname,  devise,  word);
                  dataRepository.save(data);
                System.out.println(word);
                  }
              } catch(Exception e) {
                  e.printStackTrace();
              }

          }
      } catch (IOException e) {
          e.printStackTrace();
      }

  }
}
