# Java Chat Application

## Introduction
This project is a chat application implemented using Java, allowing multiple clients to connect to a single server to exchange messages in real-time within a chat room. It demonstrates network programming and multithreading capabilities.

## Key Features
- **Chat Server**: Manages client connections and facilitates message exchange in the chat room.
- **Chat Client**: Allows users to connect to the chat server and exchange messages with others.
- **Chat Room Management**: Supports the creation of chat rooms that multiple users can join to send and receive messages.
- **Multithreading**: Handles communication with each client on a separate thread to enable seamless real-time chat.

## Project Structure

```
Java_Chat/
├── src/
│   └── kr/co/ipdisk/DunDunHSK/JavaChat/
│       ├── ChatClient.java
│       ├── ChatRoom.java
│       ├── ChatServer.java
│       ├── ChatThread.java
│       └── UserData.java
├── Study/
│   ├── pom.xml
│   ├── src/main/java/org/iptime/DunDunRST/
│   │   ├── ABC.java
│   │   ├── Abstract.java
│   │   ├── Example.java
│   │   └── SingletonExample.java
│   └── target/
│       ├── Study-1.0-SNAPSHOT.jar
│       └── classes/
└── .git/
```

### Directory and File Descriptions

#### 1. `src/kr/co/ipdisk/DunDunHSK/JavaChat/`
This directory contains the main source code for the chat application.

- **`ChatClient.java`**: 
  - The entry point for the client application. This class enables users to connect to the chat server and send or receive messages in the chat room.
  
- **`ChatServer.java`**: 
  - The entry point for the server application. Accepts multiple client connections and routes messages to the respective clients.
  
- **`ChatRoom.java`**: 
  - Implements chat room functionality. Manages users joining the chat room and exchanging messages.
  
- **`ChatThread.java`**: 
  - A thread class that handles communication with each client. It transfers messages from the server to the client and vice versa.
  
- **`UserData.java`**: 
  - Manages individual user information, including username and connection status.

#### 2. `Study/`
This directory contains example code and files for learning purposes.

- **`pom.xml`**: 
  - The build configuration file for the Maven project. Manages dependencies and build settings.
  
- **`src/main/java/org/iptime/DunDunRST/`**: 
  - Contains various example classes for learning Java concepts.
  
- **`target/`**: 
  - Directory where Maven generates compiled class files and JAR files after building the project.

## Build and Run Instructions

### 1. Requirements
- Java 17 or higher
- Maven 3.x or higher

### 2. Build Steps
1. Navigate to the `Study` directory:
   ```bash
   cd Study
   ```
2. Build the project using Maven:
   ```bash
   mvn clean install
   ```
3. Once built successfully, a `Study-1.0-SNAPSHOT.jar` file will be generated in the `target/` directory.

### 3. Running the Application
Both the server and the client must be run separately.

1. **Run the Server**:
   ```bash
   java -cp target/Study-1.0-SNAPSHOT.jar kr.co.ipdisk.DunDunHSK.JavaChat.ChatServer
   ```

2. **Run the Client**:
   ```bash
   java -cp target/Study-1.0-SNAPSHOT.jar kr.co.ipdisk.DunDunHSK.JavaChat.ChatClient
   ```

## Learning Code (`Study` Directory)
This directory contains example code to learn various Java concepts.

- **`ABC.java`**, **`Abstract.java`**: Examples of abstract classes and inheritance.
- **`Example.java`**: Demonstrates various Java concepts.
- **`SingletonExample.java`**: An implementation of the singleton pattern.
