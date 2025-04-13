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
3. Abstract class @RequestBody and Repository mapping


## Response:
**Sample Response of Ticket Creation:**

```json
{
    "code": 201,
    "success": true,
    "message": "Successfully created ticket.",
    "data": {
        "id": "aef7a110-4519-440d-9df6-cc3ce4339ae5",
        "vehicle": {
            "id": "ac57ed98-1095-4be2-bbae-4d6ab51cbba0",
            "licensePlate": "test12345",
            "color": null,
            "size": "L",
            "vehicleType": "CAR",
            "ratePerHr": 10.0,
            "totalBill": null
        },
        "parkingSpot": {
            "id": "d9d71a56-ba1d-4e2e-876c-d32e1386553f",
            "parkingSpotNumber": 9595,
            "parkingSpotType": "CAR",
            "vehicleUdt": {
                "id": null,
                "licensePlate": "test12345",
                "color": null,
                "size": "L",
                "vehicleType": "CAR",
                "ratePerHr": 10.0,
                "totalBill": null
            },
            "occupied": true
        },
        "parkingStartTime": "2025-04-13T21:03:23.6464717",
        "parkingEndTime": null,
        "ratePerHrs": 10.0,
        "createdTime": "2025-04-13T21:03:23.6464717",
        "updatedTime": null
    }
}
```