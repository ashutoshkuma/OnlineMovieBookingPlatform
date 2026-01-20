# High Level Design – Movie Ticket Booking System

<img width="796" height="291" alt="HLD_Movie_Booking System" src="https://github.com/user-attachments/assets/9ac6e6a2-67f5-4b3e-9137-7dabad513bf2" />



## Architecture
- Microservices
- CQRS (Search vs Booking)
- B2B + B2C separation

## Components
- CDN → Load Balancer → API Gateway
- Booking Service (write-heavy)
- Search Service (read-heavy)
- Partner Service (B2B)
- Redis (seat locking)
- Elasticsearch (search)
- PostgreSQL 

## Key Decisions
- Redis TTL-based seat locking
- Elasticsearch denormalized read models
- Strategy pattern for offers
