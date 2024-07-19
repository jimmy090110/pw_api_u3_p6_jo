package com.edu.ec.pw.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.edu.ec.pw.api.service.EstudianteServiceImpl;
import com.edu.ec.pw.api.service.MateriaServiceImpl;

@SpringBootApplication
public class PwApiU3P6JoApplication implements CommandLineRunner {

	@Autowired
	private MateriaServiceImpl materiaService;

	@Autowired
	private EstudianteServiceImpl estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(PwApiU3P6JoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	


}
}