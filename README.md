## Java 채팅 애플리케이션

### 소개
이 프로젝트는 Java를 사용하여 구현된 채팅 애플리케이션으로, 여러 클라이언트가 하나의 서버에 연결하여 실시간으로 메시지를 주고받을 수 있도록 합니다.
네트워크 프로그래밍 및 멀티스레딩 기능을 활용하여 구현되었습니다.

### 주요 기능
- **채팅 서버**: 클라이언트 연결을 관리하고 채팅룸 내에서 메시지를 중계합니다.
- **채팅 클라이언트**: 사용자가 채팅 서버에 연결하여 메시지를 주고받을 수 있도록 합니다.
- **채팅룸 관리**: 여러 사용자가 참여할 수 있는 채팅룸을 지원합니다.
- **멀티스레딩**: 각 클라이언트와의 통신을 개별 스레드에서 처리하여 원활한 실시간 채팅을 구현합니다.

### 추후 개선점
  - 현재 프로젝트는 채팅을 사용하기 위해 콘솔창이나 cmd에 입력하게 됩니다. GUI를 사용하여 채팅을 할 수 있게 변경할 예정입니다.
  - 현재 대화 내용을 저장하거나 방을 생성하는 기능이 없습니다. 추후에 DB를 사용하여 채팅방 생성 및 대화내용 보관을 할 예정입니다.
---

## 필수 요구사항
- Java 17 이상
- Maven 3.x 이상
- Microsft Visual Studio Code 또는 IntelliJ IDEA

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
│   │   └── SingletonExample.java
│   └── target/
│       ├── Study-1.0-SNAPSHOT.jar
│       └── classes/
└── .git/
```

---

## 디렉토리 및 파일 설명

### 1. `src/kr/co/ipdisk/DunDunHSK/JavaChat/`
이 디렉토리는 채팅 애플리케이션의 주요 소스 코드를 포함합니다.

- **`ChatClient.java`**  
  - 클라이언트 애플리케이션의 진입점입니다. 사용자가 채팅 서버에 연결하여 채팅룸에서 메시지를 송수신할 수 있도록 합니다.
  
- **`ChatServer.java`**  
  - 서버 애플리케이션의 진입점입니다. 여러 클라이언트의 연결을 받아들이고, 메시지를 클라이언트 간에 전달합니다.
  
- **`ChatRoom.java`**  
  - 채팅룸 기능을 구현합니다. 사용자의 입장 및 퇴장을 관리하며 메시지 교환을 처리합니다.
  
- **`ChatThread.java`**  
  - 각 클라이언트와의 통신을 처리하는 스레드 클래스입니다. 서버와 클라이언트 간의 메시지 전달을 담당합니다.
  
- **`UserData.java`**  
  - 사용자 정보를 관리합니다. 사용자명과 연결 상태 등을 저장합니다.


### 2. `Study/`
이 디렉토리는 학습 목적으로 사용되는 예제 코드와 관련 파일을 포함합니다.

- **`pom.xml`**  
  - Maven 프로젝트의 빌드 설정 파일입니다. 프로젝트의 의존성을 관리합니다.
  
- **`src/main/java/org/iptime/DunDunRST/`**  
  - Java 개념을 학습하기 위한 다양한 예제 클래스가 포함된 디렉토리입니다.
    - **`ABC.java`**, **`Abstract.java`**: 추상 클래스 및 상속 개념을 다루는 예제입니다.
    - **`Example.java`**: 여러 가지 Java 개념을 설명하는 예제 코드입니다.
    - **`SingletonExample.java`**: 싱글톤 패턴을 구현한 예제입니다.
  
- **`target/`**  
  - Maven 빌드 후 생성된 클래스 파일 및 JAR 파일이 저장되는 디렉토리입니다.

---
