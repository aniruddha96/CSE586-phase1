CREATE KEYSPACE IF NOT EXISTS phase1 WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : '1' };

CREATE TABLE IF NOT EXISTS phase1.user_checkin (
user_name text PRIMARY KEY,
checkin timestamp
);