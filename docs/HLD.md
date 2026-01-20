# High Level Design – Movie Ticket Booking System

<img width="796" height="291" alt="HLD_Movie_Booking System" src="https://github.com/user-attachments/assets/bcbc5aa8-7931-4c78-b81d-1ccd2003e431" />




## Architecture
- Microservices
- CQRS (Search vs Booking)
- B2B + B2C separation

## Components
- Client -> CDN -> Load Balancer -> API Gateway-> Services
- 
**Services**
- Booking Service (write-heavy)
- Search Service (read-heavy)
- Partner Service (B2B)
- 
**Data Stores**
- Redis (seat locking)
- Elasticsearch (search)
- PostgreSQL (booking, shows, seats)

## Non-Functional
- High availability
- Strong consistency for seats
- Horizontal scalability
  
## Key Decisions
- Redis TTL-based seat locking
- Elasticsearch denormalized read models
- Strategy pattern for offers
