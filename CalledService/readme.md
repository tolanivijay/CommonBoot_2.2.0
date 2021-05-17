This service (CalledService) is a simple service which makes a restful call
to another service and displays its response.

Purpose of this service to demonstrate how to call other service using resttemplate
Also, how to communicate when both the services live in a Dockerized env.

This implementation assumes usage of bridge network driver (single host) used in Docker.
We will need to inspect and fetch the IP of the calledservice and pass it in the environment,
which is then used in java to call the service.

Sample callerservice call:
docker run -p 9090:9090 -e IP_CALLED=172.17.0.2 callerservice

Command to find IPAddress of the calledservice.
docker inspect <container_hash> | grep IPAddress