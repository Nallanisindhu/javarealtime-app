package in.ashokit.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.constants.AppConstants;
import in.ashokit.entity.Plan;
import in.ashokit.properties.AppProperties;
import in.ashokit.service.PlanService;

@RestController
public class PlanRestController {

	//@Autowired
	//private PlanService planService;

	//@Autowired
	//private AppProperties appProperties;
	private PlanService planService;

	private Map<String,String>messages;
    
	public PlanRestController(PlanService planService,AppProperties appProperties) {
		this.planService=planService;
		this.messages=appProperties.getMessages();
		//System.out.println(this.messages);
	}
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories() {

		Map<Integer, String> MapPlanCategories = planService.getPlanCategories();

		return new ResponseEntity<>(MapPlanCategories, HttpStatus.OK);
	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String responceMessage = AppConstants.EMPTY_STRING;
		boolean isPlanSaved = planService.savePlan(plan);
		
		if (isPlanSaved) {
			responceMessage	= messages.get(AppConstants.PLAN_SAVE_SUCCESS);
		} else {
			responceMessage = messages.get(AppConstants.PLAN_SAVE_FAIL);

		}
		return new ResponseEntity<>(responceMessage, HttpStatus.CREATED);
	}

	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans() {
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans, HttpStatus.OK);

	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
		Plan planById = planService.getPlanById(planId);
		return new ResponseEntity<Plan>(planById, HttpStatus.OK);
	}

	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
		boolean isPlanUpdated = planService.updatePlan(plan);
		
		
		String msg = AppConstants.EMPTY_STRING;
		if (isPlanUpdated) {
			
			msg=messages.get(AppConstants.PLAN_UPDATE_SUCC);
		} else {
			msg =messages.get(AppConstants.PLAN_UPDATE_FAIL);
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		boolean isDeletedPlanById = planService.deletePlanById(planId);
		
		String msg =  AppConstants.EMPTY_STRING;
		if (isDeletedPlanById) {
			msg = messages.get(AppConstants.PLAN_DELETE_SUCC);
		} else {
			msg = messages.get(AppConstants.PLAN_DELETE_FAIL);
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status) {
		boolean isplanStatusChange = planService.planStatusChange(planId, status);
		
		
		
		String msg = AppConstants.EMPTY_STRING;
		if (isplanStatusChange) {
			msg = messages.get(AppConstants.PLAN_STATUS_CHANGE);
		
		} else {
			msg = messages.get(AppConstants.PLAN_STATUS_CHANGE_FAIL);

		}
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
