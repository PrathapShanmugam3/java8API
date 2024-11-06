package com.oasys.helpdesk.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.helpdesk.entity.SiteVisitStatusEntity;
import com.oasys.helpdesk.entity.YearMasterEntity;
import com.oasys.helpdesk.service.YearMasterAndSiteVisitStatusService;
import com.oasys.helpdesk.utility.GenericResponse;
import com.oasys.helpdesk.utility.ResponseHeaderUtility;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "HelpDeskData", description = "This controller contain all  operation of Year Master and Site Visit Status")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		@ApiResponse(code = 409, message = "Conflict occurred") })

@RequestMapping("/data")
public class YearMasterAndSiteVisitStatusController {
	
	@Autowired
	private YearMasterAndSiteVisitStatusService yearMasterAndSiteVisitStatusService;

	
	@RequestMapping(value = "/addYearMaster", method = RequestMethod.POST)
	@ApiOperation(value = "This api is used to create the Year Master", notes = "Returns HTTP 200 if successful get the record")
	public GenericResponse  createYearMaster(@Valid @RequestBody YearMasterEntity yearMasterEntity)
			 {
		return  yearMasterAndSiteVisitStatusService.createYearMaster(yearMasterEntity);
	}
	

	
	@RequestMapping(value = "/addSiteVisitStatus", method = RequestMethod.POST)
	@ApiOperation(value = "This api is used to create the Site Visit Status", notes = "Returns HTTP 200 if successful get the record")
	public GenericResponse  createSiteVisitStatus(@Valid @RequestBody SiteVisitStatusEntity siteVisitStatusEntity)
			 {
		return  yearMasterAndSiteVisitStatusService.createSiteVisitStatus(siteVisitStatusEntity);
	}
	
	@GetMapping("/allSiteVisitStatus")
	@ApiOperation(value = "This api is to get all active Year Master records", notes = "Returns HTTP 200 if successful get the record")
	public ResponseEntity<Object> getAllActiveSiteVisitStatus() {
		return new ResponseEntity<>(yearMasterAndSiteVisitStatusService.getAllActiveSiteVisitStatus(), ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);
	}
	
	@GetMapping("/allYearMaster")
	@ApiOperation(value = "This api is to get all active Year Master records", notes = "Returns HTTP 200 if successful get the record")
	public ResponseEntity<Object> getAllActiveYearMaster() {
		return new ResponseEntity<>(yearMasterAndSiteVisitStatusService.getAllActiveYearMaster(), ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);
	}

	
}
