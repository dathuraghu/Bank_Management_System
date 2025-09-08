INSERT INTO customer (customer_id, name, email, phone_no, created_dt, last_updated_dt , meta_status)
VALUES
  (1, 'John Doe', 'john.doe@example.com', '9876543210', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,'A'),
  (2, 'Alice Smith', 'alice.smith@example.com', '9123456780', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,'A'),
  (3, 'Bob Johnson', 'bob.johnson@example.com', '9988776655', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,'A'),
  (4, 'Carol Williams', 'carol.williams@example.com', '9012345678', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,'A')
  ;