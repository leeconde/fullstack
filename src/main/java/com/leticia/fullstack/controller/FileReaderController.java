package com.leticia.fullstack.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leticia.fullstack.services.FileReader;

@RestController
public class FileReaderController {

	@Autowired
	FileReader fileReader;

	@GetMapping("/fileReader")
	public ResponseEntity<String> findAll() throws ParseException {
		fileReader.lerArquivo();
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
