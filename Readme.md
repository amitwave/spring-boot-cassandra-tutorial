docker network create cassandra-net

docker run -p 9042:9042 --name my-cassandra --rm --network cassandra-net -d cassandra:latest

docker run -it --rm --network cassandra-net cassandra:latest cqlsh my-cassandra


CREATE KEYSPACE cassandra_tutorial
  WITH REPLICATION = { 
   'class' : 'SimpleStrategy', 
   'replication_factor' : 1 
  };
  
use cassandra_tutorial;

describe keyspaces;
describe tables;

  