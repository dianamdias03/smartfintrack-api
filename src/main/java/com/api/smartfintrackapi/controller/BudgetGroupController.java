package com.api.smartfintrackapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.smartfintrackapi.model.BudgetGroup;
import com.api.smartfintrackapi.repository.BudgetGroupRepository;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class BudgetGroupController {
	@Autowired
	BudgetGroupRepository budgetGroupRepository;
	
	@GetMapping("/budgetGroups")
	public List<BudgetGroup> listGroup(){
		return budgetGroupRepository.findAll();
	}
	
	@GetMapping("/budgetGroup/{id}")
	public Optional<BudgetGroup> listGroupUnic(@PathVariable(value="id") long id){
		return budgetGroupRepository.findById(id);
	}
	
	@PostMapping("/budgetGroup")
	public BudgetGroup saveGroup(@RequestBody BudgetGroup budgetGroup) {
		return budgetGroupRepository.save(budgetGroup);
	}
	
	@PostMapping("/budgetGroups")
	public List<BudgetGroup> saveGroups(@RequestBody List<BudgetGroup> budgetGroups) {
		return budgetGroupRepository.saveAll(budgetGroups);
	}
	
	@DeleteMapping("/budgetGroups")
	public void deleteGroups(@RequestBody List<Long> data) {
		budgetGroupRepository.deleteAllById(data);
	}
}
