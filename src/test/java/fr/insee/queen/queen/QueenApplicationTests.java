package fr.insee.queen.queen;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.insee.queen.queen.domain.Operation;

class QueenApplicationTests extends AbstractTests {

	@Test
	void testFindOperation() {
		login("admin");
		var result = get("/api/operation/", Operation[].class);
		assert	result.getStatusCode().is2xxSuccessful():"error status will be 200";
		
		assert List.of(result.getBody()).stream().anyMatch(o -> o.getId().equals("TRVTST")):"TRVTST should exist";
	}
	
	

}
