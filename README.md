# **Password Validation API**

API RESTful desenvolvida para desafio tecnico Itaú, com objetivo de validar senhas com base em regras de segurança específicas. A aplicação foi construída em Java e segue boas práticas de desenvolvimento com Spring Boot, oferecendo um serviço assíncrono para validação de senhas e suporte à documentação OpenAPI via Swagger.

## **Sumário**
- [Funcionalidades](#funcionalidades)
- [Requisitos](#requisitos)
- [Clone o repositório](#clone-o-repositório)
- [Configuração](#configuração)
- [Acesso à Documentação](#acesso-à-documentação)

## **Funcionalidades**
A **Password Validation API** oferece as seguintes funcionalidades:

- **Validação de Senha**: Recebe uma senha e valida se atende às regras de segurança:
  - Pelo menos 9 caracteres
  - Ao menos 1 dígito
  - Ao menos 1 letra minúscula
  - Ao menos 1 letra maiúscula
  - Ao menos 1 caractere especial: `!@#$%^&*()-+`
  - Não pode ter caracteres repetidos.

- **API Assíncrona**: O serviço de validação de senha é executado de forma assíncrona para melhorar a performance.

- **Documentação Interativa**: A documentação está disponível através do Swagger UI, permitindo interagir com a API diretamente no navegador.

A API possui os seguintes endpoints:

- `POST /api/v1/validate-password`: Valida a senha de acordo com as regras de segurança.


## **Requisitos**
Para rodar a aplicação localmente, você precisará dos seguintes requisitos:

- **Java 21 ou superior**
- **Maven 3.8 ou superior**
- **Spring Boot** (configuração automática através de `spring-boot-starter-web`)


## **Configuração**

**Instalação do JDK, Maven:**

- [Instruções para instalação do JDK](https://docs.oracle.com/en/java/javase/21/install/overview-jdk-installation.html)
- [Instruções para instalação do Maven](https://maven.apache.org/install.html)


## **Clone o repositório**
Clone este repositório para sua máquina local utilizando o comando:

```bash
git clone https://github.com/gabiqassis/PasswordValidatorAPI.git
```

## **Configuração do Async**

O serviço de validação de senha está configurado para funcionar de maneira assíncrona. Certifique-se de ter a configuração do Spring Async habilitada, como segue no exemplo abaixo:

```java
@EnableAsync
@Configuration
public class AsyncConfig {
    // Configuração personalizada, se necessário
}
```


## **Acesso à Documentação**

### **Swagger UI**

A documentação interativa da API está disponível através do Swagger UI. Após rodar a aplicação, acesse o Swagger UI através da URL:

```bash
http://localhost:8080/swagger-ui.htm
```


## **Exemplo de Requisição de Validação de Senha**

### **Endpoint:**
POST `/api/v1/validate-password`

### **Corpo da Requisição:**

```json
{
  "password": "P@ssw0rd!"
}
```

### Resposta de Sucesso:

```json
{
  "valid": true,
  "message": "A senha atende a todas as regras."
}
```

### Resposta de Erro:
```json
{
  "valid": false,
  "message": "A senha deve conter ao menos uma letra maiúscula."
}

```
