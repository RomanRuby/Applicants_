INSERT INTO applicants (first_name, second_name, birth_date, reference_resume,description, vacancy_id, office_id)
VALUES ('Ivan', 'Ivanov', DATE '1989-9-9', 'ref','sdgf',1, 1);

INSERT INTO applicants (first_name, second_name, birth_date, reference_resume, description,vacancy_id, office_id)
VALUES ('Igor', 'Petrov', DATE '1989-9-9', 'ref','sdf',1, 1);

INSERT  INTO interviews(is_enable, description, event_date, creation_date, preference, applicant_id, status_id)
VALUES (true,'sdf',DATE '1989-9-9',DATE '1989-9-9',3,1,1);
