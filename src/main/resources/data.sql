
-- INSERT INTO users (id, username, email, password, created_date, last_modified_date, created_by, last_modified_by, version, is_active)
-- VALUES
--    (1, 'johndoe', 'john.doe@example.com', '$2a$10$rHqK04xbvSxpBiSplwvlduSbS4bp3ClQOLuibEfmKAP19vbT/R4vu', '2025-03-01 10:00:00', '2025-03-01 10:00:00', 'system', 'system', 0, true),
--    (2, 'janedoe', 'jane.doe@example.com', '$2a$10$rHqK04xbvSxpBiSplwvlduSbS4bp3ClQOLuibEfmKAP19vbT/R4vu', '2025-03-01 11:00:00', '2025-03-01 11:00:00', 'system', 'system', 0, true);


-- Roles
INSERT INTO roles (id, name, created_date, last_modified_date, created_by, last_modified_by, version, is_active)
VALUES
    (1, 'ROLE_USER',  '2025-03-01 10:05:00', '2025-03-01 10:05:00', 'system', 'system', 0, true),
    (2, 'ROLE_ADMIN', '2025-03-01 10:06:00', '2025-03-01 10:06:00', 'system', 'system', 0, true);

-- INSERT INTO users_roles (user_id,role_id)
-- VALUES ( 1, 1),( 2,2);
