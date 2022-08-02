package com.leticia.fullstack;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leticia.fullstack.utils.FileReader;

@SpringBootApplication
public class FullstackApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(FullstackApplication.class, args);

//		File file = new File("C:\\Users\\Leticia\\Documents\\tmp\\Importar.txt");
//		Scanner sc = null;
//
//		try {
//			sc = new Scanner(file);	
//			while (sc.hasNextLine()) {
//				System.out.println(sc.nextLine());
//			}
//		} catch (IOException e) {
//			// TODO: handle exception
//		}

		System.out.println("Importando arquivo");
		FileReader fileReader = new FileReader();
		fileReader.lerArquivo();
	}

}
