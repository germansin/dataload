package com.dataload.demo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.dataload.demo.model.Dosis;
import com.dataload.demo.service.DosisService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ScheduleProcessor { 

    private static final Logger logger = LoggerFactory.getLogger(ScheduleProcessor.class);
    
    @Value("${app.dataload.path}")
    private String pathToFile;

    @Autowired
	private  DosisService dosisService;

    @Scheduled(cron = "0 * * * * ?")
    public void load(){
        logger.info("Running load process.. ");
		try {
			File myfile=new File(pathToFile+"covid_vaccine_statewise.csv"); 
			Scanner reader=new Scanner(myfile);
            int count=0;
			StringTokenizer st=null;
            
			while (reader.hasNextLine()&&count < 200) {
                String line=reader.nextLine();
				st=new StringTokenizer(line,",");

				if(count>0){
				  Dosis dosis=new Dosis();				
				  SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				  dosis.setId(count+1);
				  dosis.setUpdated(sdf.parse(st.nextToken()));
                  dosis.setState(st.nextToken());
				  dosis.setTotalDosis(Double.parseDouble(st.nextToken()));
				  dosis.setSessions(Double.parseDouble(st.nextToken()));
                  dosisService.addDosis(dosis);
                  
			   }
				count++;
                
			}

			reader.close();

		} catch (Exception e) {
			//TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}


}
