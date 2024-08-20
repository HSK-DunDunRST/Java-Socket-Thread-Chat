# Java 채팅 애플리케이션

## 소개
이 프로젝트는 Java를 사용하여 구현된 채팅 애플리케이션입니다. 
이 애플리케이션은 다수의 클라이언트가 하나의 서버에 접속하여 채팅방에서 실시간으로 메시지를 주고받을 수 있는 기능을 제공합니다. 
이 프로젝트는 네트워크 프로그래밍, 멀티스레딩 기능을 포함하고 있습니다.

## 주요 기능
- **채팅 서버**: 클라이언트의 연결을 관리하며, 채팅방에서 주고받는 메시지를 중개합니다.
- **채팅 클라이언트**: 사용자가 채팅 서버에 연결하여 메시지를 주고받을 수 있도록 합니다.
- **채팅방 관리**: 다수의 사용자가 참여할 수 있는 채팅방을 생성하고, 각 사용자의 메시지를 관리합니다.
- **멀티스레딩**: 각 클라이언트와의 통신을 개별 스레드로 처리하여 실시간 채팅이 원활하게 이루어지도록 합니다.

## 프로젝트 구조

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
│   │   ├── Main.java
│   │   └── SingletonExample.java
│   └── target/
│       ├── Study-1.0-SNAPSHOT.jar
│       └── classes/
└── .git/
```

### 주요 디렉토리 및 파일 설명

#### 1. `src/kr/co/ipdisk/DunDunHSK/JavaChat/`
이 디렉토리에는 채팅 애플리케이션의 주요 소스 코드가 포함되어 있습니다.

- **`ChatClient.java`**: 
  - 클라이언트 애플리케이션의 진입점입니다. 이 클래스는 사용자가 채팅 서버에 연결하고, 채팅방에서 다른 사용자들과 메시지를 주고받을 수 있도록 합니다.
  
- **`ChatServer.java`**: 
  - 서버 애플리케이션의 진입점입니다. 여러 클라이언트의 연결을 수락하고, 각 클라이언트에게 메시지를 중계하는 역할을 합니다.
  
- **`ChatRoom.java`**: 
  - 채팅방의 기능을 구현한 클래스입니다. 사용자가 채팅방에 참여하고 메시지를 주고받는 로직을 관리합니다.
  
- **`ChatThread.java`**: 
  - 각 클라이언트와의 통신을 처리하는 스레드 클래스입니다. 서버에서 클라이언트로, 그리고 클라이언트에서 서버로 메시지를 전달하는 역할을 합니다.
  
- **`UserData.java`**: 
  - 각 사용자의 정보를 관리하는 클래스입니다. 사용자 이름, 접속 상태 등의 정보를 저장합니다.

#### 2. `Study/`
이 디렉토리는 학습용 예제 코드와 관련 파일이 포함되어 있습니다.

- **`pom.xml`**: 
  - Maven 프로젝트의 빌드 설정 파일입니다. 프로젝트의 의존성을 관리하고 빌드 설정을 정의합니다.
  
- **`src/main/java/org/iptime/DunDunRST/`**: 
  - 학습용 예제 클래스들이 위치해 있습니다. 다양한 Java 예제가 포함되어 있어 학습과 실습에 도움이 됩니다.
  
- **`target/`**: 
  - Maven 빌드 후 생성된 클래스 파일들과 JAR 파일이 포함된 디렉토리입니다.

## 빌드 및 실행 방법

### 1. 요구 사항
- Java 17 이상
- Maven 3.x 이상

### 2. 빌드 절차
1. `Study` 디렉토리로 이동합니다:
   ```bash
   cd Study
   ```
2. Maven을 사용하여 프로젝트를 빌드합니다:
   ```bash
   mvn clean install
   ```
3. 빌드가 성공하면 `target/` 디렉토리에 `Study-1.0-SNAPSHOT.jar` 파일이 생성됩니다.

### 3. 실행 방법
서버와 클라이언트를 각각 실행해야 합니다.

1. **서버 실행**:
   ```bash
   java -cp target/Study-1.0-SNAPSHOT.jar kr.co.ipdisk.DunDunHSK.JavaChat.ChatServer
   ```

2. **클라이언트 실행**:
   ```bash
   java -cp target/Study-1.0-SNAPSHOT.jar kr.co.ipdisk.DunDunHSK.JavaChat.ChatClient
   ```

## 학습용 코드 설명 (`Study` 디렉토리)
이 디렉토리에는 Java의 다양한 개념을 학습할 수 있는 예제 코드가 포함되어 있습니다.

- **`ABC.java`**, **`Abstract.java`**: 추상 클래스와 상속에 대한 예제입니다.
- **`Example.java`**: 여러 Java 개념을 예제로 보여주는 파일입니다.
- **`SingletonExample.java`**: 싱글톤 패턴을 구현한 예제입니다.
