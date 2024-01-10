package com.api.smartfintrackapi.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.api.smartfintrackapi.dtos.CashFlowDTO;
import com.api.smartfintrackapi.model.CashFlow;
import com.api.smartfintrackapi.repository.CashFlowRepository;
import com.api.smartfintrackapi.service.CashFlowService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class CashFlowController {
	@Autowired
	CashFlowRepository cashFlowsRepository;
	
	@Autowired
	CashFlowService cashFlowService;
	
	@GetMapping("/expenses/{userLoginId}")
	public List<CashFlowDTO> listExpenses(@PathVariable Long userLoginId){
		return cashFlowService.getAllExpenses(userLoginId);
	}
	
	@GetMapping("/revenues/{userLoginId}")
	public List<CashFlowDTO> listRevenues(@PathVariable Long userLoginId){
		return cashFlowService.getAllRevenues(userLoginId);
	}
	
	@GetMapping("/cashFlowsReport/{userLoginId}")
	public List<CashFlowDTO> listCashFlow(@PathVariable Long userLoginId){
		return cashFlowService.getAllCashFlow(userLoginId);
	}
	
	@GetMapping("/cashFlows/{id}")
	public Optional<CashFlow> listCashFlowUnic(@PathVariable(value="id") long id){
		return cashFlowsRepository.findById(id);
	}
	
	@PostMapping("/cashFlow")
	public CashFlowDTO saveCashFlow(@RequestBody CashFlow cashFlow) {
		cashFlow.setCreationDate(LocalDate.now());
		cashFlowsRepository.save(cashFlow);
		return cashFlowService.convertToDto(cashFlow);
	}
	
	@PostMapping("/cashFlows")
	public List<CashFlow> saveCashFlows(@RequestBody List<CashFlow> cashFlows) {
		return cashFlowsRepository.saveAll(cashFlows);
	}
	
	@DeleteMapping("/cashFlows")
	public void deleteCashFlows(@RequestBody List<Long> data) {
		List<CashFlow> cashFlows = cashFlowsRepository.findAllById(data);
		cashFlowsRepository.deleteAll(cashFlows);
	}
	
	@GetMapping("/dashboard/{userLoginId}")
    public Map<String, BigDecimal> getDashboardSummary(@PathVariable Long userLoginId) {
		Map<String, BigDecimal> summary = new HashMap<String, BigDecimal>();
        summary.put("totalRevenue", cashFlowService.getTotalRevenue(userLoginId));
        summary.put("totalExpense", cashFlowService.getTotalExpense(userLoginId));
        summary.put("totalRevenueLast30Days", cashFlowService.getTotalRevenueLast30Days(userLoginId));
        summary.put("totalExpenseLast30Days", cashFlowService.getTotalExpenseLast30Days(userLoginId));
        summary.put("remainingBalance", cashFlowService.getRemainingBalance(userLoginId));
        summary.put("expensePercentage", cashFlowService.getExpensePercentage(userLoginId));
        return summary;
    }
}
