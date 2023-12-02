package com.group.devops;

import com.group.devops.model.DevOps;
import com.group.devops.repository.DevOpsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DevOpsApplication {

	@Bean
	CommandLineRunner runner(DevOpsRepository DevOpsRepository) {
		return args -> {

			DevOps point1 = new DevOps("sit", false);
			DevOps point2 = new DevOps("stand", false);
			DevOps point3 = new DevOps("lie",true);
			DevOps point4 = new DevOps("Point 4", true);
			DevOpsRepository.save(point1);
			DevOpsRepository.save(point2);
			DevOpsRepository.save(point3);
			DevOpsRepository.save(point4);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DevOpsApplication.class, args);
	}

}