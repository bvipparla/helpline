package org.playload.helpline.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.playload.helpline.base.BaseController;
import org.playload.helpline.base.SingleItemResponse;
import org.playload.helpline.dto.CreateGrievanceRequest;
import org.playload.helpline.dto.CreateGrievanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/grievances", produces = { MediaType.APPLICATION_JSON_VALUE })
public class GrievanceController extends BaseController {
	@Autowired
	ObjectMapper objectMapper;
	@RequestMapping("/{grievanceId}")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public SingleItemResponse<CreateGrievanceResponse> createGrievance(@RequestBody @Valid CreateGrievanceRequest far) {
		// CreateGrievanceResponse result = gs.createGrievance(far);
		CreateGrievanceResponse result = new CreateGrievanceResponse();
		result.setGid(UUID.randomUUID().toString());
		result.setName("Some Name");
		return new SingleItemResponse<CreateGrievanceResponse>(result);
	}
}
