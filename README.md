# NLW Expert (Java)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)


This project is an API built using **Java, Java Spring, PostgresSQL as the database**

This API was developed in the Java track of the NLW Expert event

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Contributing](#contributing)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/gabriel-afg/NLW-Expert.git
```

2. Install dependencies with Maven

3. Install [PostgresSQL](https://www.postgresql.org/)
4. Run the container (desktop docker required [DOCKER DESKTOP](https://www.docker.com/products/docker-desktop/))
```bash
docker compose up -d
```
5. Populate the database by running the main method of the CreateSeed class in src/main/java/com.rocketseat.certificate/seed/CreateSeed.java;

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

```markdown
GET /questions/technology/{technology} - Retrieve a list of all questions for a given technology
```

```markdown
Get /ranking/top10 - Retrieve a list of the top 10 highest scoring users
```
```markdown
POST /students/verifyCertification- Check whether the user has a certification in a technology
```
```json
[
    {
      "email": "teste@email.com",
      "technology": "JAVA"
    },
    
]
```
```markdown
POST /students/certification/answer - Register a new user into the App
```
```json
[
    {
      "email": "teste@email.com",
      "technology": "JAVA",
      "questionsAnswers": [
        {
          "questionID": "c5f02721-6dc3-4fa6-b46d-6f2e8dca9c66",
          "alternativeID": "bafdf631-6edf-482a-bda9-7dce1efb1890"
        },
        {
          "questionID": "b0ec9e6b-721c-43c7-9432-4d0b6eb15b01",
          "alternativeID": "f8e6e9b3-199b-4f0d-97ce-7e5bdc080da9"
        },
        {
          "questionID": "f85e9434-1711-4e02-9f9e-7831aa5c743a",
          "alternativeID": "d3e51a56-9b97-4bb8-9827-8bcf89f4b276"
        }
      ]
    },
    
]
```

## Database
The project utilizes [PostgresSQL](https://www.postgresql.org/) as the database. 

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.
