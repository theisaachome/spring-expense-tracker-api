package com.expenses.tracker.expensetrackerapi.service;

import com.expenses.tracker.expensetrackerapi.dto.request.UserRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.UserResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Account;
import com.expenses.tracker.expensetrackerapi.entity.Budget;
import com.expenses.tracker.expensetrackerapi.entity.Category;
import com.expenses.tracker.expensetrackerapi.entity.User;
import com.expenses.tracker.expensetrackerapi.mapper.UserMapper;
import com.expenses.tracker.expensetrackerapi.repository.AccountRepository;
import com.expenses.tracker.expensetrackerapi.repository.BudgetRepository;
import com.expenses.tracker.expensetrackerapi.repository.CategoryRepository;
import com.expenses.tracker.expensetrackerapi.repository.UserRepo;
import com.expenses.tracker.expensetrackerapi.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserService extends BaseServiceImpl<User,Long, UserRequestDto,UserResponseDto> {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final AccountRepository accountRepository;
    private final BudgetRepository budgetRepository;
    private final CategoryRepository categoryRepository;
    public UserService(UserRepo userRepo, UserMapper userMapper, AccountRepository accountRepository, BudgetRepository budgetRepository, CategoryRepository categoryRepository){
        super(userRepo,userMapper);
        this.userMapper=userMapper;
        this.userRepo = userRepo;
        this.accountRepository = accountRepository;
        this.budgetRepository = budgetRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    protected void updateEntity(User existingUser, UserRequestDto dto) {
        existingUser.setUsername(dto.username());
        existingUser.setPassword(dto.password());
        existingUser.setEmail(dto.email());
    }

    @Override
    protected void preSave(User entity, UserRequestDto dto) {
        userRepo.save(entity);
        // Call method to create sample data before saving the user
        createSampleDataForUser(entity);
    }

    private void createSampleDataForUser(User user) {
        // Sample Accounts
        List<Account> sampleAccounts = List.of(
                new Account("Touch & Go", "E-Wallet", new BigDecimal("100.00"), user),
                new Account("RHB Savings", "Bank", new BigDecimal("5000.00"), user),
                new Account("Cash Wallet", "Cash", new BigDecimal("200.00"), user)
        );
        accountRepository.saveAll(sampleAccounts);

        // Sample Categories
        List<Category> sampleCategories = List.of(
                new Category("Groceries", "Expenses for food and groceries", user),
                new Category("Transportation", "Travel expenses", user),
                new Category("Salary", "Income from job", user),
                new Category("Investments", "Income from stocks, dividends", user)
        );
        categoryRepository.saveAll(sampleCategories);

        // Sample Budget
        Budget sampleBudget = new Budget();
        sampleBudget.setName("Monthly Budget");
        sampleBudget.setDescription("Sample budget for tracking monthly expenses");
        sampleBudget.setBudgetLimit(new BigDecimal("2000.00"));
        sampleBudget.setPeriodStart(LocalDate.now().withDayOfMonth(1));
        sampleBudget.setPeriodEnd(LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth()));
        sampleBudget.setUser(user);
        budgetRepository.save(sampleBudget);
    }

    @Transactional
    public void clearSampleData(Long userId){
        accountRepository.deleteByUserId(userId);
        budgetRepository.deleteByUserId(userId);
        categoryRepository.deleteByUserId(userId);
    }
}
