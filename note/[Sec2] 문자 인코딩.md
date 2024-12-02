## 1. 컴퓨터와 데이터

### 메모리

- 수많은 전구들이 모여있는 것

- **트랜지스터** 라고 불리는 전자 스위치

- RAM(Random Access Memory)

  ![20241202162042](https://raw.githubusercontent.com/CodingWon/images/master/imgs/20241202162042.png)

### 2진수

- 전구를 켜고 끈다는 것은 0과 1만 나타낼 수 있는 2진수로 표현할 수 있다.
- 전구 1개 = 1bit : 2가지 표현 (0,1)

![20241202162602](https://raw.githubusercontent.com/CodingWon/images/master/imgs/20241202162602.png)

- 음수 표현
  - 1bit는 음수와 양수를 구분하는데 사용, 나머지 7bit로 숫자 범위 사용  
  - 0 ~ 127 (양수 표현시 첫 비트를 0으로 사용, 나머지 7bit로 128가지 0과 양수 숫자 표현)  
  - -128 ~ -1(음수 표현시 첫 비트를 1로 사용, 나머지 7bit로 128가지 음수 숫자 표현)  

## 2.  컴퓨터와 문자 인코딩1

- 문자를 이진수로 변경하는 방법이 없어서 각 문자를 숫자와 연결시키는 방법을 채택

- 문자 인코딩 :  (문자집합을 통해) 문자 -> 숫자

- 문자 디코딩 : (문자집합을 통해) 숫자 -> 문자

  ![20241202163235](https://raw.githubusercontent.com/CodingWon/images/master/imgs/20241202163235.png)

## 3. ASCII 문자 집합 (미국)

- 호환성 문제를 해결하기 위해 ASCII(American Standard Code for Information Interchange) 라는 표준 문자 집합 개발
- 7비트를 사용하여 총 128가지 문자를 표현  

## 4. ISO_8859_1  (유럽)

- 기존 ASCII에 서유럽 문자의 추가 필요  
- 기존 ASCII 문자 집합과 호환 가능  

## 5. 한글 문자 집합  

### EUC-KR

- 자주 사용하는 한글 2350개만 포함해서 만들었다.
- 2byte(16bit)를 사용하면 총 65536가지 표현 가능    
- 영어를 사용하면 1byte를, 한글을 사용하면 2byte를 메모리에 저장한다.  .
- **기존 ASCII 문자 집합과 호환 가능**

### MS949

- 마이크로소프트가 EUC-KR을 확장하여 만든 인코딩  
- EUC-KR과 마찬가지로 ASCII는 1byte, 한글은 2byte를 사용함
- 기존 ASCII 문자 집합과 호환 가능  

## 6. 전세계 문자 집합

### 호환성 문제

- 전세계 인구가 늘어나면서, 전세계 문자를 대부분 다 표현할 수 있는 문자 집합이 필요해짐
- EUC-KR이나 MS949 같은 한글 문자표를 PC에 설치하지 않으면 다른 나라 사람들은 한글로 작성된 문서를 열
  어볼 수 없다.  
- 한 문서 안에 영어, 한글, 중국어, 일본어, 히브리어, 아랍어를 함께 저장해야 한다면?  

### 유니코드의 등장

- 전 세계의 모든 문자들을 단일 문자 세트로 표현할 수 있는 유니코드(Unicode) 표준  
- UTF-16, UTF-8

### UTF-16

- 16 bit(2byte) 기반

- 자주 사용하는 기본 다국어들은 2byte로 표현, 2byte는 65536가지를 표현할 수 있다 
  - 영어, 유럽 언어, 한국어, 중국어, 일본어등이 2byte를 사용한다.   
- 그 외는 4byte로 표현 4byte는 42억 가지를 표현할 수 있다  
  - 고대 문자, 이모지, 중국어 확장 한자등  
- 대부분의 문자를 2byte로 처리하기 때문에 계산이 편리함  

> ### 단점 - ASCII 영문도 2byte를 사용한다. ASCII와 호환되지 않음 
>
> - UTF-16을 사용한다면 영문의 경우 다른 문자 집합 보다 **<u>2배의 메모리를 더 사용</u>**한다  
> - 웹에 있는 문서의 80% 이상은 영문 문서이다.  

### UTF-8 (현대의 표준 인코딩)

- 8bit(1byte) 기반, 가변길이 인코딩  
- 1byte ~ 4byte를 사용해서 문자를 인코딩  
  - 1byte: ASCII, 영문, 기본 라틴 문자  
  - 2byte: 그리스어, 히브리어 라틴 확장 문자
  - 3byte: 한글, 한자, 일본어
  - 4byte: 이모지, 고대문자등  
- ASCII 문자는 1바이트로 표현, ASCII 호환

> ### 단점 
>
> ### 1. 상대적으로 사용이 복잡함  
>
> - UTF-8에서는 각 문자가 가변 길이로 인코딩되므로 특정 문자에 접근할 때 복잡함
>
> ### 2. ASCII를 제외한 일부 언어에서 더 많은 용량 사용  
>
> - TF-8은 ASCII 문자를 1바이트로, 비ASCII 문자를 2~4바이트로 인코딩한다.  



## 7. 문자 집합 조회 - AvailableCharsetsMain 예제

### 이용 가능한 모든 문자 집합 조회

- `Charset.availableCharsets()`
  - 자바가 기본으로 제공하는 문자 집합과 OS가 제공하는 문자 집합을 포함  

### 특정 문자 집합 찾기

- `Charset.forName()`
  - 대소문자는 구분하지 않는다  

### 자주 사용하는 문자 집합

- `StandardCharsets.UTF_8`  
  - 상수로 지정되어 있다.

```
public final class StandardCharsets {
    public static final Charset US_ASCII = sun.nio.cs.US_ASCII.INSTANCE;
    public static final Charset ISO_8859_1 = 
    		sun.nio.cs.ISO_8859_1.INSTANCE;
    public static final Charset UTF_8 = sun.nio.cs.UTF_8.INSTANCE;
    public static final Charset UTF_16BE = new sun.nio.cs.UTF_16BE();
    public static final Charset UTF_16LE = new sun.nio.cs.UTF_16LE();
    public static final Charset UTF_16 = new sun.nio.cs.UTF_16();
}
```

### 기본 문자 집합

- `Charset.defaultCharset()`  
  - 현재 시스템에서 사용하는 기본 문자 집합  



## 8. 문자 인코딩 예제1  - EncodingMain1

- 문자를 컴퓨터가 이해할 수 있는 숫자(byte)로 변경하는 것을 문자 인코딩이라 한다  
- `String.getByte()` 의 인자로 `Charset` 객체를 전달하면 된다.  

## 9. 문자 인코딩 예제2 - EncodingMain2  

- 숫자 65를 디코딩하면 UTF-16을 제외하고 모두 디코딩이 가능하다.
  - UTF-16의 경우 디코딩에 실패해서 `�` 라는 특수문자가 출력되었다.  
- ASCII는 UTF-16을 제외한 대부분의 문자 집합에 호환된다  

### 한글이 깨지는 가장 큰 2가지 이유  

1. EUC-KR(MS949), UTF-8이 서로 호환되지 않음  
   - UTF-8로 인코딩한 한글을 EUC-KR(MS949)로 디코딩하거나 또는 EUCKR(MS949)로 인코딩한 한글을 UTF-8로 디코딩할 때 발생한다.  
2. EUC-KR(MS949) 또는 UTF-8로 인코딩한 한글을 `ISO-8859-1` 로 디코딩 할 때  
   - EUC-KR(MS949) 또는 UTF-8로 인코딩한 한글을 한글을 지원하지 않는 `ISO-8859-1` 로 디코딩 할 때 발생한다.  

