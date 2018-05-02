
## Intent
—————————

Aggregate calls to microservices in a single location: the API Gateway. The user makes a single call to the API Gateway, and the API Gateway then calls each relevant microservice.

With the Microservices pattern, a client may need data from multiple different microservices. If the client called each microservice directly, that could contribute to longer load times, since the client would have to make a network request for each microservice called. Moreover, having the client call each microservice directly ties the client to that microservice - if the internal implementations of the microservices change (for example, if two microservices are
combined sometime in the future) or if the location (host and port) of a microservice changes,
then every client that makes use of those microservices must be updated.

The intent of the API Gateway pattern is to alleviate some of these issues. In the API Gateway
pattern, an additional entity (the API Gateway) is placed between the client and the
microservices. The job of the API Gateway is to aggregate the calls to the microservices.
Rather than the client calling each microservice individually, the client calls the API Gateway
a single time. The API Gateway then calls each of the microservices that the client needs.
 


## Applicability
————————————————

Use the API Gateway pattern when you're also using the Microservices pattern and need a single point of aggregation for your microservice calls
