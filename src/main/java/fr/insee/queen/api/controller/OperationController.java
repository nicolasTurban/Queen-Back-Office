package fr.insee.queen.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insee.queen.api.domain.Operation;
import fr.insee.queen.api.dto.operation.OperationDto;
import fr.insee.queen.api.repository.OperationRepository;
import io.swagger.annotations.ApiOperation;

/**
* OperationController is the Controller using to manage {@link Operation} entity
* 
* @author Claudel Benjamin
* 
*/
@RestController
@RequestMapping(path = "/api")
public class OperationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OperationController.class);

	/**
	* The operation repository using to access to table 'operation' in DB 
	*/
	@Autowired
	private OperationRepository operationRepository;
	
	/**
	* This method is using to get all operations
	* 
	* @return List of all {@link OperationDto}
	*/
	@ApiOperation(value = "Get list of operations")
	@GetMapping(path = "/operations")
	public ResponseEntity<Object> getListOperation(){
		LOGGER.info("GET operations resulting in 200");
		return new ResponseEntity<Object>(operationRepository.findDtoBy(), HttpStatus.OK);
	}
	
}
