package gabriel.carvalho1.demo;

import gabriel.carvalho1.demo.dto.PageResponseDTO;
import gabriel.carvalho1.demo.dto.ResponseDTO;
import gabriel.carvalho1.demo.service.WorldBankService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@Slf4j
public class MetaProjectApplication implements CommandLineRunner {
	@Autowired
	WorldBankService service;

	@Override
	public void run( String...args) throws IOException {
		PageResponseDTO responseDTO = service.execute("");
		log.info(responseDTO.toString());
		int counter = 1;
		for(ResponseDTO r : responseDTO.getResponses()) {
			log.info(String.valueOf(counter++));
			log.info(r.toString());
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(MetaProjectApplication.class, args);
	}

}
