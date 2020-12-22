package api.fontys.spotifree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import api.fontys.spotifree.controller.UserController;

@SpringBootTest
public class SpotifreeApplicationTests {

	@Autowired
	private UserController controller;
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
