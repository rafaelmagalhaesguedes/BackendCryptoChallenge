# Backend Cryptography Challenge

Your challenge is to implement encryption in a service transparently for the API and the service layers of your application. The goal is to ensure that sensitive fields of entity objects are not directly visible, performing encryption at runtime during the conversion of the entity to the corresponding database column and vice versa.

# Example

Consider the fields userDocument and creditCardToken as sensitive fields that should be encrypted. The example table would be as follows:

| id | userDocument          | creditCardToken | value |
|----|------------------------|-----------------|-------|
| 1  | MzYxNDA3ODE4MzM=       | YWJjMTIz        | 5999  |
| 2  | MzI5NDU0MTA1ODM=       | eHl6NDU2        | 1000  |
| 3  | NzYwNzc0NTIzODY=       | Nzg5eHB0bw==    | 1500  |

The corresponding entity structure would be:

| Field           | Type   |
|-----------------|--------|
| id              | Long   |
| userDocument    | String |
| creditCardToken | String |
| value           | Long   |

# Requirements

- Implement a simple CRUD considering the mentioned fields as sensitive.

- Use the encryption algorithm of your choice. Suggestions: SHA-512 or PBKDF2.
