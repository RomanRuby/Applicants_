CREATE TABLE statuses (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR NOT NULL,
  code VARCHAR NOT NULL
);

CREATE TABLE offices (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR NOT NULL
);

CREATE TABLE resources (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR NOT NULL
);
CREATE TABLE vacancies (
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR NOT NULL,
  salary FLOAT,
  necessity VARCHAR NOT NULL
);

CREATE TABLE applicants (
  id               BIGSERIAL PRIMARY KEY,
  is_enable        BOOLEAN DEFAULT 'true',
  first_name       VARCHAR NOT NULL,
  second_name      VARCHAR NOT NULL,
  birth_date       DATE    NOT NULL,
  reference_resume VARCHAR,
  description  VARCHAR,
  vacancy_id       BIGINT REFERENCES vacancies,
  office_id        BIGINT REFERENCES offices
);

CREATE TABLE interviews (
  id           BIGSERIAL PRIMARY KEY,
  is_enable BOOLEAN DEFAULT 'true',
  description  VARCHAR,
  event_date   TIMESTAMP NOT NULL,
  creation_date  TIMESTAMP NOT NULL,
  preference BIGINT,
  applicant_id BIGINT    NOT NULL REFERENCES applicants,
  status_id    BIGINT    NOT NULL REFERENCES statuses
);





