# AI Text Assistant API

## Overview

This project is a simple **AI-powered REST API** built with **Java + Spring Boot** that integrates with a Large Language Model (LLM) to process text.

It provides endpoints for tasks such as:

* Text summarization
* (Extensible) text improvement and generation

The main goal of this project is to demonstrate:

* Integration with external AI APIs
* Backend development using Spring Boot
* Clean and simple service architecture

---

## 🚀 Technologies

* Java 25
* Spring Boot
* Spring Web / RestClient
* REST APIs
* LLM integration (OpenAI API)

---

## 🧠 Features

### POST `/ai/summarize`

Summarizes a given text using AI.

#### Request

```json
{
  "text": "Your long text here..."
}
```

#### Response

```json
{
  "summary": "Short summarized version..."
}
```

---

## 🔑 API Key Setup

This project requires an API key from an AI provider.

### 1. Get your API key

Create one at:
https://platform.openai.com/

---

### 2. Configure environment variable

#### 2.1 IntelliJ

1. Go to **Run → Edit Configurations**
2. Find **Environment variables**
3. Add:

```
OPENAI_API_KEY=your_api_key_here
```

####2.2 Replace on code
1. Go to WebClientConfig class
2. Replace + System.getenv("OPENAI_API_KEY") for YOUR API KEY

---

## ▶️ Running the Project

### Using IntelliJ

* Open the project
* Run the main Spring Boot application
* Ensure the environment variable is set

The API will be available at:

```
http://localhost:8080
```

---

## 🧪 Testing with cURL

### Summarize text

```bash
curl -X POST http://localhost:8080/ai/summarize \
-H "Content-Type: application/json" \
-d '{
  "text": "Artificial Intelligence is transforming the way we build software. It enables automation, better decision making, and new user experiences."
}'
```

---

## ⚠️ Notes

* Make sure your API key is valid and billing is enabled
* If you get `429 insufficient_quota`, check your account usage
* If you get timeout errors, verify your internet connection or increase client timeout

---

## 📈 Possible Improvements

* Add endpoints for:
    * Text improvement
    * Content generation
* Add DTOs instead of raw Maps
* Implement retry and timeout handling
* Add logging and observability
* Dockerize the application

---

## 💡 Learning Purpose

This project was built as a hands-on way to explore:

* AI integration in backend systems
* Prompt engineering basics
* Modern Spring HTTP clients (RestClient)
