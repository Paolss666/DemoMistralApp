
# Mistral API Spring Boot Integration

This project demonstrates how to integrate the Mistral API with a Spring Boot application. The application exposes a `/chat/completions` endpoint that communicates with the Mistral API to generate text completions.

## Project Overview

- **Backend Framework**: Spring Boot
- **HTTP Client**: Retrofit
- **API**: Mistral API (v1)
- **Endpoint**: `/chat/completions`
- **Input**: JSON with the user's prompt
- **Output**: Text completion generated by Mistral API

## Prerequisites

Before running the application, ensure that you have the following prerequisites installed:

- **JDK 11 or higher**
- **Maven**
- **Postman** or **cURL** for testing

## Setup and Installation

### Step 1: Clone the repository

```bash
git clone $
cd your-repository-folder
```

### Step 2: Configure Mistral API Key

Create a file named `application.properties` (or `application.yml`) in the `src/main/resources` directory. Add your **Mistral API key** to it.

Example:
```properties
mistral.api.key=your-api-key-here
```

Make sure to replace `your-api-key-here` with your actual Mistral API key.

### Step 3: Build the application

Use Maven to build the application:

```bash
mvn clean install
```

### Step 4: Run the application

To start the application, run the following command:

```bash
mvn spring-boot:run
```

This will start the Spring Boot application on `localhost:8081`.

---

## Testing the Endpoint with `curl`

Once the application is up and running, you can test the `/chat/completions` endpoint using `curl` or Postman.

### **Test with `curl`**

To send a POST request to the `/chat/completions` endpoint with a user's prompt, use the following `curl` command:

```bash
curl -X POST http://localhost:8081/chat/completions      -H "Content-Type: application/json"      -d '{
           "messages": [
             {
               "role": "user",
               "content": "Bonjour, cooool tu parles ?"
             }
           ]
         }'
```

### **Expected Response**

If the request is successful, you should receive a JSON response with the generated completion from the Mistral model.

Example response:

```json
{
  "choices": [
    {
      "text": "Yes, I can speak! How can I assist you today?"
    }
  ]
}
```

If there's an error, you may get an error message like:

```json
{
  "error": "Invalid API key"
}
```

### **Test with a JSON File**

To avoid formatting errors in `curl`, you can also create a JSON file (`data.json`) containing the request body and send it with `curl`.

1. **Create `data.json`**:

```json
{
  "messages": [
    {
      "role": "user",
      "content": "Bonjour, cooool tu parles ?"
    }
  ]
}
```

2. **Send the request using `curl`**:

```bash
curl -X POST http://localhost:8081/chat/completions      -H "Content-Type: application/json"      -d @data.json
```

---

## Troubleshooting

If you encounter issues, here are some common troubleshooting steps:

1. **Malformed JSON error**: If you receive an error about malformed JSON, make sure your JSON is properly formatted. You can use online tools like [JSONLint](https://jsonlint.com/) to validate your JSON before sending it.

2. **Unauthorized error**: Ensure your Mistral API key is correctly set in `application.properties`.

3. **404 error**: Check that the Spring Boot application is running on the correct port (`8081`) and that the endpoint URL matches `/chat/completions`.

---

## Conclusion

This Spring Boot application integrates with the Mistral API to generate text completions. You can easily test it using `curl` or Postman by sending a POST request with a user's prompt.
