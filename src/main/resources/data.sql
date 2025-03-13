--  Users data
INSERT INTO users (id, username, email, password, created_date, last_modified_date, created_by, last_modified_by, version, is_active)
VALUES
    (1, 'johndoe', 'john.doe@example.com', '$2a$10$vLR5uL.Zc6VdkLmHtLXdie5G5wP5x4wEcK89JeJ2o7rjkUYOFnTFG', '2025-03-01 10:00:00', '2025-03-01 10:00:00', 'system', 'system', 0, true),
    (2, 'janedoe', 'jane.doe@example.com', '$2a$10$G/YWbk6dgwBjTyj4F.wzc.YfGvQ9Q5eSBAPnuGR/2NFaJB5G3Vcme', '2025-03-01 11:00:00', '2025-03-01 11:00:00', 'system', 'system', 0, true);
