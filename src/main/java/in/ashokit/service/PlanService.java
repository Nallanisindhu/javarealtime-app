package in.ashokit.service;

import java.util.List;
import java.util.Map;

import in.ashokit.entity.Plan;

public interface PlanService {

	// This method used to get data for category drop down,category id available As
	// Key.
	public Map<Integer, String> getPlanCategories();

	// This method is used to save the Plan 'T' indicates plan is saved to DB,'F'
	// indicates plan is not saved to DB
	public boolean savePlan(Plan plan);
	
	//To display all plan details whatever the data available in DB 
	public List<Plan> getAllPlans();
	
	//To edit the particular plan details
	public Plan getPlanById(Integer planId);
	
	//To update plan data 
	public boolean updatePlan(Plan plan);
	
	//To delete plan data by id permanently (hard delete)
	public boolean deletePlanById(Integer planId);
	
	//To Activate and deactivate plan data with ActiveSwitch(soft delete)
	public boolean planStatusChange(Integer planId,String status);
	
	
	

}
