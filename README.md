# Parking-Lot-Design-in-Spring-Boot

Design Pattern Follows:

1. Factory Design Pattern
2. Strategy Design Pattern
3. SOLID

Cassandra Commands: connect it to the database using cqlsh.
1. docker-compose up -d
2. docker exec -it cassandra-container /bin/bash
3. nodetool status (for getting datacenter name)
3. cqlsh
4. CREATE KEYSPACE parking_lot_keyspaces
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};
5. desc keyspaces;


Problem Faced:
1. Lombok
2. datacenter of cassandara
3. Abstract class @RequestBody