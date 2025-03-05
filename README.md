_**calendar-app-study**_

# 객체 지향 프로그래밍

<span style="color:red">상태</span>와 <span style="color:red">행위</span>로 이루어진 <span style="color:red">객체</span> 들 간의 <span style="color:red">상호작용</span>을 통해 프로그램을 설계 및 개발하는 프로그래밍 패러다임

* 객체 (Object) : 현실에 존재하는 대상. 주변에 존재하는 모든 사람, 사물, 동물, 물건 모두
* 지향 (Oriented) : 목표로 하는, 기반으로 하는
* 프로그래밍 (Programming) : 컴퓨터 프로그램을 작성하는 행위

=> 현실에 존재하는 모든 대상을 기반으로 컴퓨터 프로그램을 작성하는 행위

### 예시

#### 학생
상태 : 이름, 전공, 번호, 전체 성적

행위 : 공부하기, 시험치기, 전공 변경하기

각각의 학생이 하나의 오브젝트

### 객체지향 프로그래밍이 왜 필요할까?

#### 절차지향 프로그래밍
```java
int a = 1;      // 간단한 프로그램에서는 문제가 발생하지 않음.
int b = 2;
function sum() {
    return a + b;
}
sum(); // 3
```
아래 코드가 1,000줄 이상 되며 a 에 대한 정의가 코드 마지막 쯤에 변경되었다고 생각해보자.
```java
int a = 1;     
int b = 2;
function sum() {
    return a + b;
}

int a = 10;
function minus() {
    return a - b;
}

sum();      // 12
minus();    // 8
```
<span style="color:red">초기 개발 의도와 다르게 결과가 출력됨.</span>

프로그램의 규모가 커지고 개발자간 협업이 빈번해질수록 이런 이슈는 자주 발생함.

변수명을 다르게 작성하면 가능하지만 관리가 어려움.

#### 객체지향 프로그래밍

객체화를 시켜보자

```java
class Calculator {
    private int a;
    private int b;

    Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int add() {
        return a + b;
    }

    public int minus() {
        return a - b;
    }
}

Calculator first = new Calculator(1, 2);
Calculator second = new Calculator(10, 2);
```
<span style="color:red">객체는 서로 독립적인 존재이기 대문에 서로 영향을 주지 않음.</span>

### 객체지향 프로그래밍의 장점

* 코드 재사용 용이
* 생산성 향상
* 자연적인 모델링 가능
* 유지보수 용이

### 객체지향 프로그래밍의 단점

* 실행속도가 느림
* 프로그램 용량이 커짐
* 설계에 많은 시간이 필요함

### 객체지향 프로그래밍의 특징

1. 캡슐화
* 서로 연관있는 속성과 기능을 하나의 클래스로 만들어 분리하는 것
* 관련이 없는 외부에서는 해당 클래스로 제한적인 접근이 가능

2. 상속
* 부모 클래스의 속성과 기능을 자식 클래스가 가지게 되는 것
* A 클래스의 속성과 기능을 B 클래스에도 사용할 수 있음

3. 추상화
* 각 클래스들의 공통적인 속성과 기능을 정의하여 코드의 중복을 줄이고, 클래스간 관계를 효과적으로 설정하는 것
* 추상 클래스와 인터페이스를 활용할 수 있음

4. 다형성
* 두 개 이상의 메소드가 동일한 이름으로 구성될 수 있지만 수행되는 행위는 다를 수 있음

### 객체지향 프로그래밍 설계 5대 원칙 (SOLID)

유지보수성이 높고 확장성과 유연성이 높은 프로그램을 개발하기 위해 활용되는 설계 5대 원칙

1. Single Responsibility Principle (SRP) 단일 책임 원칙
2. Open-Closed Principle (OCP) 개방-폐쇄 원칙
3. Liskov Substitution Principle (LSP) 리스코프 치환 원칙
4. Interface Segregation Principle (ISP) 인터페이스 분리 원칙
5. Dependency Inversion Principle (DIP) 의존관계 역전 원칙

# 클래스

### 클래스 = 형태, 틀, 블루 프린트
클래스는 특정 객체를 생성하기 위해 변수와 메소드를 정의하는 형태, 틀

```java
class Car {                         // 현재 클래스는 껍데기만 존재
    
}

Car hyundaiCar = new Car();         // new 는 객체를 생성할 때 사용하는 키워드
Car kiaCar = new Car();             // hyundaiCar, kiaCar 등 Car 의 객체가 생성됨

```

### 클래스의 구성 요소

클래스는 객체 변수와 메소드로 구성되어 있음

객체 변수는 속성, 멤버 변수라고 하며 해당 클래스를 표현하기 위한 상태, 값을 가지고 있음

메소드는 클래스에 대한 행위를 표현하기 위함

### 클래스의 객체 변수와 메소드

```java
class Car {
    private String name;                    // name 이라는 객체 변수
                                            // Car 의 이름을 표현
    public String getName() {               // getName() 과 setName() 이라는 메소드
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
```

### 객체 변수와 메소드
```java
class Car { 
    private String name;
    public String description;
    
    Car(String name) {
        this.name = name;
    }
    
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
Car hyundaiCar = new Car("hyundai");
System.out.println(hyundaiCar.description);
System.out.println(hyundaiCar.getName());
hyundaiCar.setname("kia");
```