**Low Level Design**

**Read Scenarios**
1. Browse theatres by movie, city, date
2. Fetch platform offers by city & theatre

**Write Scenarios**
1. Book tickets with seat locking
2. Create / update / delete shows
3. Bulk booking & cancellation
4. Seat inventory allocation & updates

**Design Patterns**
- Strategy (Offers)
- Repository, Service

**API Contracts**
**Read Scenarios**
**1. Browse theatres by movie, city, date**
GET /api/v1/search/theatres
Sample Request
GET /api/v1/search/theatres?movieId=M123&city=Bangalore&date=2026-01-20

Response -200
[
  {
    "showId": "S101",
    "theatreName": "PVR Orion",
    "city": "Bangalore",
    "showDate": "2026-01-20",
    "showTime": "14:30"
  },
  {
    "showId": "S102",
    "theatreName": "INOX Malleshwaram",
    "city": "Bangalore",
    "showDate": "2026-01-20",
    "showTime": "18:45"
  }
]

**2. Fetch platform offers by city & theatre**
GET /api/v1/offers

Response -200
[
  {
    "offerId": "OFF50",
    "description": "50% discount on third ticket",
    "type": "TICKET_COUNT"
  },
  {
    "offerId": "OFF20",
    "description": "20% off for afternoon shows",
    "type": "SHOW_TIME"
  }
]

**Write Scenarios**
**1. Book tickets with seat locking**
   POST /api/v1/bookings
   
   Request Body
   {
  "userId": "U1001",
  "showId": 101,
  "seats": ["A1", "A2", "A3"],
  "showTime": "14:30",
  "amount": 900
}

Response 201
{
  "bookingId": 9001,
  "status": "CONFIRMED",
  "totalAmount": 450,
  "message": "Booking successful"
}


**2. Create / update / delete shows**
**Create**
POST /api/v1/partners/shows

Request Body
{
  "movieId": "M123",
  "theatreId": 10,
  "startTime": "2026-01-20T14:30:00"
}

Response 201
{
  "showId": 101,
  "message": "Show created successfully"
}
**Update**
PUT /api/v1/partners/shows/{showId}

Request Body
{
  "startTime": "2026-01-20T16:30:00"
}

Response
{
  "message": "Show updated successfully"
}
**Delete**
DELETE /api/v1/partners/shows/{showId}
Response – 204 No Content

**3. Bulk booking & cancellation**
   POST /api/v1/bookings/bulk
   
   Request Body
   [
  {
    "userId": "U1001",
    "showId": 101,
    "seats": ["A1", "A2"],
    "showTime": "11:00",
    "amount": 600
  },
  {
    "userId": "U1002",
    "showId": 101,
    "seats": ["B1", "B2"],
    "showTime": "11:00",
    "amount": 600
  }
]
Response 201

[
  { "bookingId": 9002, "status": "CONFIRMED" },
  { "bookingId": 9003, "status": "CONFIRMED" }
]
POST /api/v1/bookings/cancel

Request Body

[9002, 9003]

Response 200
{
  "message": "Bookings cancelled successfully"
}


**4. Seat inventory allocation & updates**
PUT /api/v1/partners/shows/{showId}/seats

Request Body

[
  { "seatNumber": "A1", "available": true },
  { "seatNumber": "A2", "available": false }
]

Respose -200

{
  "message": "Seat inventory updated"
}

409 - Conflict

{
  "errorCode": "SEAT_LOCKED",
  "message": "One or more selected seats are unavailable"
}

400 - Bad Request

{
  "errorCode": "INVALID_REQUEST",
  "message": "Invalid input parameters"
}



