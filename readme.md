# 💳 현대카드 태블릿 대면 카드 신청 시스템 프레임워크 마이그레이션 연습 프로젝트

본 프로젝트는 금융권(현대카드) 대면 신청계 시스템의 노후 프레임워크(Able 1.0)를 걷어내고, 차세대 웹 엔터프라이즈 표준인 **Lodos 프레임워크(Spring 5 기반)** 및 **Java 21** 환경으로 최적화 및 마이그레이션하는 전환 개발 실습 저장소입니다.

---

## 🛠️ 프로젝트 핵심 요구사항 및 기술 제약

금융권 SI 프로젝트의 엄격한 규정과 시스템 환경적 제약을 그대로 반영하여 아키텍처를 설계했습니다.

1. **Able 1.0 프레임워크 완전 제거**
   - 레거시 전용 상속 구조(`extends AbleAction`) 및 독자적인 데이터 맵핑 오브젝트를 완벽히 걷어내고 순수 Spring 표준 구조로 리팩토링합니다.
2. **Lodos (Spring 5 / Javax 서블릿 스펙) 고수**
   - 차세대 런타임 환경이지만 인프라 호환성을 위해 `jakarta.*` 패키지를 원천 차단하고 **`javax.servlet.*` 네임스페이스를 엄격히 사수**합니다.
3. **Java 1.8 ➔ Java 21 업그레이드 대응**
   - 컴파일러 및 런타임 버전을 Java 21로 빌드 가동하며, 버전에 따른 구형 오픈소스 라이브러리 충돌 및 빌드 에러를 수정합니다.
4. **현대카드 오픈소스 반입 가이드 준수**
   - 사내 보안 검증 시스템을 통과할 수 있도록 Java 21을 공식 지원하면서도 `javax` 스펙을 유지하는 검증된 버전의 오픈소스(Lombok 1.18.32 등)로 교체 및 격리합니다.
5. **금융 보안 심의 및 시큐어 코딩 필수 적용**
   - 모의해킹 및 정보보호 부서 심의 통과를 위해 태블릿 입력단에서 유입되는 고객 개인정보(주민등록번호 등)의 **로그 마스킹 처리** 및 방어 로직을 구현합니다.

---

## 🏗️ 개발 환경 (Development Environment)

- **IDE:** Eclipse IDE (Enterprise Java Developers)
- **Language:** Java 21 (OpenJDK / Azul Zulu 21)
- **Framework:** Lodos Framework Layer (Spring Framework 5.3.39 준수)
- **Build Tool:** Apache Maven 3.x
- **Web Spec:** Java EE 8 (javax.servlet-api 4.0.1)

---

## 📂 핵심 소스 코드 변경 요약 (Before & After)

### 1. Legacy (Able 1.0 구조)
- 독자 프레임워크 패키지에 강하게 종속되어 유연성이 떨어지고 구형 자바 버전에 갇혀 있는 형태입니다.
```java
public class CardApplyAction extends AbleAction {
    @Override
    public void executeAction(HttpServletRequest request) throws Exception {
        this.residentNo = request.getParameter("resNo");
        // ❌ 보안 취약점: 개인정보 평문 노출
        System.out.println("주민번호: " + residentNo); 
    }
}
```

### 2. Migration (Lodos / Spring 5 구조)
- POJO 기반의 순수 `@RestController` 구조로 전환하고 시큐어 코딩 유틸을 적용했습니다.
```java
@RestController
@RequestMapping("/api/v1/tablet")
public class CardApplyAction {
    @PostMapping("/card-apply")
    public String executeAction(HttpServletRequest request) throws Exception {
        this.residentNo = request.getParameter("resNo");
        // 🟢 시큐어 코딩: 암호화/마스킹 필터링 후 로그 출력
        String maskedResidentNo = maskResidentNumber(this.residentNo);
        System.out.println("주민번호: " + maskedResidentNo);
        return "SUCCESS";
    }
}
```

---

## 🚀 빌드 및 검증 방법 (Build Instructions)

이클립스 Maven 빌드 실행기(`Run Configurations`)의 JRE 설정을 **Java 21**로 반드시 일치시킨 후 아래 생명주기 명령을 실행합니다.

```bash
# 메이븐 청소 및 패키징 빌드 검증
mvn clean install
```

빌드가 성공하면 콘솔 창에 `BUILD SUCCESS`를 확인할 수 있으며, 기존 종속성 충돌 및 네임스페이스 오류가 완벽히 해결된 아티팩트(`war`)가 생성됩니다.
