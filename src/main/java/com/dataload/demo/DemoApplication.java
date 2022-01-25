package com.dataload.demo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.transaction.Transactional;

import com.dataload.demo.dao.DosisRepository;
import com.dataload.demo.model.Dosis;
import com.dataload.demo.service.DosisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class DemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	 
	}

	
}
