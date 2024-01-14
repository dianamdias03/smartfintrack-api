package com.api.smartfintrackapi.CashFlowTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.smartfintrackapi.repository.BudgetGroupRepository;
import com.api.smartfintrackapi.repository.CashFlowRepository;
import com.api.smartfintrackapi.service.BudgetGroupService;
import com.api.smartfintrackapi.service.CashFlowService;

@ExtendWith(MockitoExtension.class)
public class CashFlowServiceTest {

    @Mock
    private CashFlowRepository cashFlowRepository;

    @InjectMocks
    private CashFlowService cashFlowService;
    
    @InjectMocks
    private BudgetGroupService budgetGroupService;
    
    @Mock 
    private BudgetGroupRepository budgetGroupRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Teste para getTotalRevenueLast30Days
    @Test
    public void testGetTotalRevenueLast30Days() {
        Long userLoginId = 1L;
        BigDecimal expectedRevenue = BigDecimal.valueOf(300);
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        
        when(cashFlowRepository.totalRevenueLast30Days(thirtyDaysAgo, userLoginId)).thenReturn(expectedRevenue);
        
        BigDecimal actualRevenue = cashFlowService.getTotalRevenueLast30Days(userLoginId);
        
        assertEquals(expectedRevenue, actualRevenue, "A receita total nos últimos 30 dias deve ser igual ao esperado");
    }

    // Teste para getRemainingBalance
    @Test
    public void testGetRemainingBalance() {
        Long userLoginId = 1L;
        BigDecimal totalRevenue = BigDecimal.valueOf(1000);
        BigDecimal totalExpense = BigDecimal.valueOf(700);
        BigDecimal expectedBalance = BigDecimal.valueOf(300);

        when(cashFlowRepository.totalRevenue(userLoginId)).thenReturn(totalRevenue);
        when(cashFlowRepository.totalExpense(userLoginId)).thenReturn(totalExpense);

        BigDecimal actualBalance = cashFlowService.getRemainingBalance(userLoginId);

        assertEquals(expectedBalance, actualBalance, "O saldo remanescente deve ser calculado corretamente");
    }
}
