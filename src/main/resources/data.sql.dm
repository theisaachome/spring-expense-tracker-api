--  Users data
INSERT INTO users (id, username, email, password, created_date, last_modified_date, created_by, last_modified_by, version, is_active)
VALUES
    (1, 'johndoe', 'john.doe@example.com', '$2a$10$vLR5uL.Zc6VdkLmHtLXdie5G5wP5x4wEcK89JeJ2o7rjkUYOFnTFG', '2025-03-01 10:00:00', '2025-03-01 10:00:00', 'system', 'system', 0, true),
    (2, 'janedoe', 'jane.doe@example.com', '$2a$10$G/YWbk6dgwBjTyj4F.wzc.YfGvQ9Q5eSBAPnuGR/2NFaJB5G3Vcme', '2025-03-01 11:00:00', '2025-03-01 11:00:00', 'system', 'system', 0, true);

-- Accounts for User 1
INSERT INTO accounts (id, name, type, balance, user_id, created_date, last_modified_date, created_by, last_modified_by, version, is_active)
VALUES
    (1, 'Chase Checking', 'CHECKING', 3500.00, 1, '2025-03-01 10:05:00', '2025-03-01 10:05:00', 'system', 'system', 0, true),
    (2, 'Chase Savings', 'SAVINGS', 12000.00, 1, '2025-03-01 10:06:00', '2025-03-01 10:06:00', 'system', 'system', 0, true),
    (3, 'PayPal Wallet', 'EWALLET', 850.00, 1, '2025-03-01 10:07:00', '2025-03-01 10:07:00', 'system', 'system', 0, true);

-- Accounts for User 2
INSERT INTO accounts (id, name, type, balance, user_id, created_date, last_modified_date, created_by, last_modified_by, version, is_active)
VALUES
    (4, 'Bank of America Checking', 'CHECKING', 4200.00, 2, '2025-03-01 11:05:00', '2025-03-01 11:05:00', 'system', 'system', 0, true),
    (5, 'Citi Savings', 'SAVINGS', 15000.00, 2, '2025-03-01 11:06:00', '2025-03-01 11:06:00', 'system', 'system', 0, true),
    (6, 'Venmo', 'EWALLET', 625.00, 2, '2025-03-01 11:07:00', '2025-03-01 11:07:00', 'system', 'system', 0, true);

-- Categories for both users
INSERT INTO categories (id, name, description, user_id, created_date, last_modified_date, created_by, last_modified_by, version, is_active)
VALUES
-- User 1 Categories
(1, 'Salary', 'INCOME', 1, '2025-03-01 10:10:00', '2025-03-01 10:10:00', 'system', 'system', 0, true),
(2, 'Groceries', 'EXPENSE', 1, '2025-03-01 10:11:00', '2025-03-01 10:11:00', 'system', 'system', 0, true),
(3, 'Utilities', 'EXPENSE', 1, '2025-03-01 10:12:00', '2025-03-01 10:12:00', 'system', 'system', 0, true),
(4, 'Rent', 'EXPENSE', 1, '2025-03-01 10:13:00', '2025-03-01 10:13:00', 'system', 'system', 0, true),
(5, 'Entertainment', 'EXPENSE', 1, '2025-03-01 10:14:00', '2025-03-01 10:14:00', 'system', 'system', 0, true),
-- User 2 Categories
(6, 'Salary', 'INCOME', 2, '2025-03-01 11:10:00', '2025-03-01 11:10:00', 'system', 'system', 0, true),
(7, 'Groceries', 'EXPENSE', 2, '2025-03-01 11:11:00', '2025-03-01 11:11:00', 'system', 'system', 0, true),
(8, 'Utilities', 'EXPENSE', 2, '2025-03-01 11:12:00', '2025-03-01 11:12:00', 'system', 'system', 0, true),
(9, 'Mortgage', 'EXPENSE', 2, '2025-03-01 11:13:00', '2025-03-01 11:13:00', 'system', 'system', 0, true),
(10, 'Dining Out', 'EXPENSE', 2, '2025-03-01 11:14:00', '2025-03-01 11:14:00', 'system', 'system', 0, true);

-- Budgets for User 1
INSERT INTO budgets (id, budget_name, description, budget_limit, period_start, period_end, user_id, created_date, last_modified_date, created_by, last_modified_by, version, is_active)
VALUES
    (1, 'Household', 'Monthly household expenses', 2500.00, '2025-03-01', '2025-03-31', 1, '2025-03-01 10:15:00', '2025-03-01 10:15:00', 'system', 'system', 0, true),
    (2, 'Entertainment', 'Monthly entertainment budget', 500.00, '2025-03-01', '2025-03-31', 1, '2025-03-01 10:16:00', '2025-03-01 10:16:00', 'system', 'system', 0, true),
    (3, 'Savings', 'Monthly savings goal', 1000.00, '2025-03-01', '2025-03-31', 1, '2025-03-01 10:17:00', '2025-03-01 10:17:00', 'system', 'system', 0, true);

-- Budgets for User 2
INSERT INTO budgets (id, budget_name, description, budget_limit, period_start, period_end, user_id, created_date, last_modified_date, created_by, last_modified_by, version, is_active)
VALUES
    (4, 'Household', 'Monthly household expenses', 3000.00, '2025-03-01', '2025-03-31', 2, '2025-03-01 11:15:00', '2025-03-01 11:15:00', 'system', 'system', 0, true),
    (5, 'Dining Out', 'Monthly restaurant budget', 600.00, '2025-03-01', '2025-03-31', 2, '2025-03-01 11:16:00', '2025-03-01 11:16:00', 'system', 'system', 0, true),
    (6, 'Savings', 'Monthly savings goal', 1200.00, '2025-03-01', '2025-03-31', 2, '2025-03-01 11:17:00', '2025-03-01 11:17:00', 'system', 'system', 0, true);

-- Transactions for User 1
INSERT INTO transactions (id, amount, transaction_date, transaction_type, note, description, user_id, account_id, category_id, budget_id, created_date, last_modified_date, created_by, last_modified_by, version, is_active)
VALUES
-- Income transaction
(1, 4500.00, '2025-03-05', 'INCOME', 'March Salary', 'Monthly salary deposit', 1, 1, 1, 3, '2025-03-05 09:00:00', '2025-03-05 09:00:00', 'johndoe', 'johndoe', 0, true),
-- Expense transactions
(2, 1200.00, '2025-03-06', 'EXPENSE', 'Rent payment', 'Monthly apartment rent', 1, 1, 4, 1, '2025-03-06 10:00:00', '2025-03-06 10:00:00', 'johndoe', 'johndoe', 0, true),
(3, 185.50, '2025-03-07', 'EXPENSE', 'Grocery shopping', 'Weekly grocery shopping at Whole Foods', 1, 1, 2, 1, '2025-03-07 16:30:00', '2025-03-07 16:30:00', 'johndoe', 'johndoe', 0, true),
(4, 65.75, '2025-03-08', 'EXPENSE', 'Electricity bill', 'Monthly electricity payment', 1, 1, 3, 1, '2025-03-08 14:00:00', '2025-03-08 14:00:00', 'johndoe', 'johndoe', 0, true),
(5, 120.00, '2025-03-09', 'EXPENSE', 'Movie night', 'Cinema tickets and dinner', 1, 3, 5, 2, '2025-03-09 20:15:00', '2025-03-09 20:15:00', 'johndoe', 'johndoe', 0, true);

-- Transactions for User 2
INSERT INTO transactions (id, amount, transaction_date, transaction_type, note, description, user_id, account_id, category_id, budget_id, created_date, last_modified_date, created_by, last_modified_by, version, is_active)
VALUES
-- Income transaction
(6, 5200.00, '2025-03-05', 'INCOME', 'March Salary', 'Monthly salary deposit', 2, 4, 6, 6, '2025-03-05 09:30:00', '2025-03-05 09:30:00', 'janedoe', 'janedoe', 0, true),
-- Expense transactions
(7, 1500.00, '2025-03-06', 'EXPENSE', 'Mortgage payment', 'Monthly mortgage payment', 2, 4, 9, 4, '2025-03-06 10:30:00', '2025-03-06 10:30:00', 'janedoe', 'janedoe', 0, true),
(8, 210.25, '2025-03-07', 'EXPENSE', 'Grocery shopping', 'Weekly grocery shopping at Safeway', 2, 4, 7, 4, '2025-03-07 17:00:00', '2025-03-07 17:00:00', 'janedoe', 'janedoe', 0, true),
(9, 85.40, '2025-03-08', 'EXPENSE', 'Water and gas bill', 'Monthly utilities payment', 2, 4, 8, 4, '2025-03-08 15:30:00', '2025-03-08 15:30:00', 'janedoe', 'janedoe', 0, true),
(10, 95.80, '2025-03-09', 'EXPENSE', 'Restaurant dinner', 'Dinner at Italian restaurant', 2, 6, 10, 5, '2025-03-09 19:45:00', '2025-03-09 19:45:00', 'janedoe', 'janedoe', 0, true);
