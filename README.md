# Test microservicio API Spring Boot

Test de microservicio para entrada a bideafactory.com

## Prerequisitos

Tener instalado Docker Desktop 


## Installation

paso 1: clonar el repositorio 


[https://github.com/hmaussa24/bideafactoryTest.git](https://github.com/hmaussa24/bideafactoryTest.git)


En la termina Ingresar al directorio del proyecto que se clono y ejecutar el comando 

```bash
docker-compose up
```

## Usage

En un cliente para probar Apis puede ser [Postman](https://www.postman.com/) o [insomnia](https://insomnia.rest/download) o el de su preferencia crear una petición Post al localhost en el puesto 8080

```
http://localhost:8080/api/booking
```

y en el Body de la petición 

```
{
    "id": "14564088-5",
    "name": "Harold",
    "lastname": "Maussa",
    "age": 33,
    "startDate": "04-03-2022",
    "endDate": "10-03-2022",
    "phoneNumber": "3137950065",
    "houseId" : "213132",
    "discountCode": "D0542A23"
    
}
```



## License
[MIT](https://choosealicense.com/licenses/mit/)