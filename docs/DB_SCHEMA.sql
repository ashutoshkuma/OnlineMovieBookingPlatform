CREATE TABLE show (
  id BIGSERIAL PRIMARY KEY,
  movie_id VARCHAR(50),
  theatre_id BIGINT,
  start_time TIMESTAMP
);

CREATE TABLE booking (
  id BIGSERIAL PRIMARY KEY,
  user_id VARCHAR(50),
  show_id BIGINT,
  status VARCHAR(20),
  total_amount DOUBLE PRECISION
);

CREATE TABLE seat_inventory (
  id BIGSERIAL PRIMARY KEY,
  show_id BIGINT,
  seat_number VARCHAR(10),
  available BOOLEAN
);
