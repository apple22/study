# Paperless Legacy Java EE Practice

## 1. 프로젝트 목적

이 프로젝트는 기존 레거시 Java/Spring 애플리케이션을 가정하여 **JDK 8에서 JDK 21로 업그레이드**하는 상황을 연습하기 위한 프로젝트입니다.

핵심 조건은 다음과 같습니다.

```text
JDK 21 사용
Spring Boot 2.7.18 사용
Jakarta 방식이 아닌 Java EE / J2EE 방식 유지
javax.* 패키지 사용
```

즉, 이 프로젝트는 Spring Boot 3 이상의 `jakarta.*` 전환 연습이 아니라, 기존 `javax.*` 기반 코드를 유지한 채 JDK만 21로 올리는 연습입니다.

---

## 2. 기술 스택

```text
Java 21
Spring Boot 2.7.18
Spring Framework 5.3.x
Gradle
Spring Web
Spring Validation
Spring Data JPA
H2 Database
Lombok
javax.validation
javax.persistence
javax.servlet
```

---

## 3. 왜 Spring Boot 2.7.18인가?

Spring Boot 3 이상은 Jakarta EE 기반입니다.

Spring Boot 3 이상에서는 다음과 같은 패키지를 사용합니다.

```java
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;
```

하지만 이번 연습의 목표는 기존 Java EE/J2EE 방식을 유지하는 것입니다.

따라서 다음과 같은 패키지를 사용합니다.

```java
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
```

그래서 Spring Boot 2.x 라인의 마지막 안정 버전인 `2.7.18`을 사용합니다.

---

## 4. build.gradle 예시

```gradle
plugins {
    id 'java'
    id 'org.springframework.boot' version '2.7.18'
    id 'io.spring.dependency-management' version '1.1.7'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
description = 'paperless-legacy-javaee'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

    runtimeOnly 'com.h2database:h2'

    compileOnly 'org.projectlombok:lombok:1.18.32'
    annotationProcessor 'org.projectlombok:lombok:1.18.32'

    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

tasks.named('test') {
    useJUnitPlatform()
}
```

---

## 5. Gradle JVM 설정 주의

IntelliJ에서 Gradle JVM이 Java 26 등 너무 높은 버전으로 잡히면 Gradle 동기화가 실패할 수 있습니다.

권장 설정은 다음과 같습니다.

```text
Project SDK: Java 21
Gradle JVM: Java 21
build.gradle toolchain: Java 21
```

IntelliJ 설정 경로:

```text
File
→ Settings
→ Build, Execution, Deployment
→ Build Tools
→ Gradle
→ Gradle JVM: Java 21
```

---

## 6. application.properties 예시

```properties
spring.application.name=paperless-legacy-javaee

server.servlet.encoding.charset=UTF-8
server.servlet.encoding.enabled=true
server.servlet.encoding.force=true

spring.datasource.url=jdbc:h2:mem:paperless_legacy;MODE=MySQL;DATABASE_TO_UPPER=false
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

---

## 7. Health Check API

### URL

```http
GET /health
```

### 예시 코드

```java
package com.example.paperlesslegacy.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "UP");
        response.put("application", "paperless-legacy-javaee");
        response.put("javaVersion", System.getProperty("java.version"));
        response.put("serverTime", LocalDateTime.now());
        return response;
    }
}
```

### 응답 예시

```json
{
  "status": "UP",
  "application": "paperless-legacy-javaee",
  "javaVersion": "21.0.x",
  "serverTime": "2026-..."
}
```

---

## 8. 카드 신청 생성 API

### URL

```http
POST /api/card-applications
```

### 요청 예시

```json
{
  "customerName": "홍길동",
  "phoneNumber": "010-1234-5678",
  "birthDate": "19900101",
  "cardProductCode": "HYUNDAI_CARD_M"
}
```

### 응답 예시

```json
{
  "applicationId": "uuid",
  "customerName": "홍길동",
  "phoneNumber": "010-1234-5678",
  "birthDate": "19900101",
  "cardProductCode": "HYUNDAI_CARD_M",
  "status": "TEMPORARY_SAVED",
  "createdAt": "2026-..."
}
```

---

## 9. javax 기반 Request DTO

```java
package com.example.paperlesslegacy.card.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CardApplicationCreateRequest {

    @NotBlank(message = "고객명은 필수입니다.")
    private String customerName;

    @NotBlank(message = "휴대폰 번호는 필수입니다.")
    @Pattern(
            regexp = "^01[0-9]-?\\d{3,4}-?\\d{4}$",
            message = "휴대폰 번호 형식이 올바르지 않습니다."
    )
    private String phoneNumber;

    @NotBlank(message = "생년월일은 필수입니다.")
    @Pattern(
            regexp = "^\\d{8}$",
            message = "생년월일은 yyyyMMdd 형식이어야 합니다."
    )
    private String birthDate;

    @NotBlank(message = "카드 상품 코드는 필수입니다.")
    private String cardProductCode;

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCardProductCode() {
        return cardProductCode;
    }
}
```

핵심은 다음 import입니다.

```java
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
```

이번 프로젝트에서는 아래 import를 사용하지 않습니다.

```java
import jakarta.validation.constraints.NotBlank;
```

---

## 10. javax 기반 Controller

```java
package com.example.paperlesslegacy.card.controller;

import com.example.paperlesslegacy.card.dto.CardApplicationCreateRequest;
import com.example.paperlesslegacy.card.dto.CardApplicationCreateResponse;
import com.example.paperlesslegacy.card.service.CardApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/card-applications")
public class CardApplicationController {

    private final CardApplicationService cardApplicationService;

    public CardApplicationController(CardApplicationService cardApplicationService) {
        this.cardApplicationService = cardApplicationService;
    }

    @PostMapping
    public ResponseEntity<CardApplicationCreateResponse> create(
            @Valid @RequestBody CardApplicationCreateRequest request
    ) {
        CardApplicationCreateResponse response = cardApplicationService.create(request);
        return ResponseEntity.ok(response);
    }
}
```

핵심 import는 다음과 같습니다.

```java
import javax.validation.Valid;
```

---

## 11. javax 기반 JPA Entity 예시

```java
package com.example.paperlesslegacy.card.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_application")
public class CardApplication {

    @Id
    @Column(name = "application_id", nullable = false, length = 36)
    private String applicationId;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "birth_date", nullable = false, length = 8)
    private String birthDate;

    @Column(name = "card_product_code", nullable = false, length = 50)
    private String cardProductCode;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    protected CardApplication() {
    }
}
```

핵심 import는 다음과 같습니다.

```java
import javax.persistence.*;
```

---

## 12. PowerShell 테스트

### UTF-8 설정

```powershell
chcp 65001
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
$OutputEncoding = [System.Text.Encoding]::UTF8
```

### Health Check

```powershell
Invoke-RestMethod `
    -Uri "http://localhost:8080/health" `
    -Method Get |
ConvertTo-Json -Depth 5
```

### 카드 신청 생성

```powershell
$body = @{
    customerName = "홍길동"
    phoneNumber = "010-1234-5678"
    birthDate = "19900101"
    cardProductCode = "HYUNDAI_CARD_M"
} | ConvertTo-Json

$utf8Body = [System.Text.Encoding]::UTF8.GetBytes($body)

$response = Invoke-RestMethod `
    -Uri "http://localhost:8080/api/card-applications" `
    -Method Post `
    -ContentType "application/json; charset=utf-8" `
    -Body $utf8Body

$response | ConvertTo-Json -Depth 5
```

---

## 13. H2 Console 접속

브라우저에서 접속합니다.

```text
http://localhost:8080/h2-console
```

접속 정보:

```text
JDBC URL: jdbc:h2:mem:paperless_legacy;MODE=MySQL;DATABASE_TO_UPPER=false
User Name: sa
Password:
```

비밀번호는 비워둡니다.

SQL 예시:

```sql
select * from card_application;
```

---

## 14. JDK8 → JDK21 업그레이드에서 자주 만나는 이슈

### 1. Gradle JVM 버전 문제

증상:

```text
호환되는 최대 Gradle JVM 버전은 24입니다.
```

해결:

```text
Gradle JVM을 Java 21로 변경
```

---

### 2. Lombok 버전 문제

JDK21에서 낮은 Lombok 버전은 컴파일 문제를 일으킬 수 있습니다.

권장:

```gradle
compileOnly 'org.projectlombok:lombok:1.18.32'
annotationProcessor 'org.projectlombok:lombok:1.18.32'
```

---

### 3. jakarta import 사용 실수

이번 프로젝트에서는 잘못된 방식입니다.

```java
import jakarta.validation.Valid;
import jakarta.persistence.Entity;
```

정상 방식:

```java
import javax.validation.Valid;
import javax.persistence.Entity;
```

---

### 4. JAXB 제거 이슈

JDK8에서는 기본 포함되던 JAXB 관련 API가 JDK11 이후 제거되어 JDK21에서는 별도 의존성이 필요할 수 있습니다.

예시 의존성:

```gradle
implementation 'javax.xml.bind:jaxb-api:2.3.1'
runtimeOnly 'org.glassfish.jaxb:jaxb-runtime:2.3.9'
```

---

## 15. 현재까지 성공 기준

```text
Spring Boot 2.7.18로 프로젝트 구성
Java 21 toolchain 적용
Gradle JVM Java 21 설정
Health Check API 구현
javax.validation 기반 DTO 구현
javax.validation.Valid 기반 Controller 구현
카드 신청 생성 API 구현
PowerShell로 API 호출 성공
H2 Console 접속 준비
```

---

## 16. 다음 단계

다음 코딩 단계는 아래 순서로 진행하면 좋습니다.

```text
1. javax.persistence 기반 Entity 완성
2. Spring Data JPA Repository 생성
3. H2 DB에 카드 신청 저장
4. 신청 단건 조회 API 구현
5. 공통 응답 ApiResponse 추가
6. GlobalExceptionHandler 추가
7. JDK21에서 JAXB 제거 이슈 재현 및 해결
8. 테스트 코드 작성
```

---

## 17. 핵심 요약

```text
이번 프로젝트는 최신 Jakarta 방식이 아니다.
목표는 JDK21 + Spring Boot 2.7.18 + javax.* 유지다.
즉, JDK8 레거시 프로젝트를 JDK21로 올리는 실무 상황을 연습한다.
```
