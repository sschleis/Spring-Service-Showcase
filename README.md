# Spring-Service-Showcase 1.0.0

Example REST Service

## Endpoints

**GET** http://localhost:8085/customer/findAll

**GET** http://localhost:8085/customer/<ID>

**POST** http://localhost:8085/customer <br/>
Body:
```
{
    "firstname": "Luke",
    "lastname": "Skywalker",
    "gender": "Male"
}
```

**DELETE** http://localhost:8085/customer/deleteAll

## Default Credentials

Username: admin <br/>
Password: geheim <br/>
Header: Basic YWRtaW46Z2VoZWlt