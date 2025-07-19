# 🧠 Research Assistant

A Spring Boot microservice for processing and analyzing content using the Gemini AI model (via Google's Generative Language API).

---

## 🚀 Features

- 🔹 **Summarization**: Transform input text into concise summaries  
- 🔹 **Topic Suggestions**: Generate related reading topics for deeper research  
- 🔹 **API-ready**: RESTful endpoint ready for integration  

---

## 🧰 Prerequisites

- JDK 17 (or newer)  
- Maven 3.8+  
- A valid [Google Generative Language API key](https://makersuite.google.com/app/apikey)

---

## 🛠️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/Babul98/IntelliSummarizer
cd research-assistant
```

### 2. Set Up Secrets

Rename the example properties file and add your actual API key:

```bash
mv src/main/resources/application.properties.example src/main/resources/application.properties
```

Then edit the file to include:

```
gemini.api.key=YOUR_GOOGLE_API_KEY_HERE
```

### 3. Build & Run

```bash
mvn clean package
java -jar target/research-assistant-0.0.1-SNAPSHOT.jar
```

---

## 🧪 Usage

### API Endpoint

Send a POST request to:

```
POST http://localhost:8080/api/research/process
Content-Type: application/json
```

### Request Body

```json
{
  "operation": "summarize",   // or "suggest"
  "content": "Your text to process..."
}
```

### Sample Response

- For `"summarize"` request →  
  `"Here’s a concise summary of your content..."`

- For `"suggest"` request →  
  ```
  - Related Topic 1
  - Related Topic 2
  ...
  ```

---

## 🧩 Project Structure

```
src/
├── main/
│   ├── java/com/research/research_assistant/
│   │   ├── ResearchService.java       // Business logic & API interaction
│   │   ├── ResearchController.java    // REST endpoint
│   │   └── ResearchRequest.java       // Request payload model
│   └── resources/
│       ├── application.properties.example  // Config template
│       └── application.properties          // (ignored, holds secrets)
└── test/                                   // Unit tests
```
