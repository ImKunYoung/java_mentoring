# JAVA 스터디
## JAVA 스터디
### JAVA 스터디
#### JAVA 스터디
##### JAVA 스터디
###### JAVA 스터디

---

```java
public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
```

| 키워드    | 내용      |
|:-------|:--------|
| dlskdf | sldkfjd |

- 마크다운 작성법
  https://eungbean.github.io/2018/06/11/How-to-use-markdown/

---

<br/>

# ✔️ 1주차 - 자바 기초

```java
public class Main {

    /*Constructor - 클래스 초기화*/
    public Main() {
        System.out.println("Constructor");
    }

    public void calculate() {
        System.out.println("calculate");
    }

    public void calculate2(int param1, int param2) {
        System.out.println("--------calculate2--------");
        System.out.println("param1: "+param1);
        System.out.println("param2: "+param2);

        System.out.println("더하기: "+(param1+param2));
        System.out.println("곱하기: "+(param1*param2));
        System.out.println("나누기 몫: "+(param1/param2));
        System.out.println("나누기 나머지: "+(param1%param2));
    }

    public static void main(String[] args) {
        System.out.println("hello world");

        int temp = 1;
        System.out.println("temp: "+temp);

        String a = "문자입니다";
        System.out.println(a);

        // 객체 선언
        Main main = new Main();
        
        // 함수 호출
        main.calculate();

        int param1 = 1;
        int param2 = 4;

        main.calculate2(param1, param2);

    }

}
```

| 키워드    | 내용                                                                                                                                                                    |
|:-------|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|public static void main(String[] args)| Java 프로젝트의 시작점                                                                                                                                                        |
| Main main = new Main() | • Main 클래스를 main 이라는 이름으로 메모리에 할당 <br/> • main은 변수라고 부름 <br/> • 클래스가 메모리에 할당된 것을 객체라고 부름 <br/> • 이렇게 클래스를 메모리에 할당하는 것을 객체 선언이라고 부름 <br/> • 선언과 동시에 Constructor 함수 실행됨 |
|main.calculate()| • Main 클래스 내부에 있는 calculate() 함수를 호출함                                                                                                                                 |
|int param1 = 1| • param1 이라는 이름으로 메모리의 x번지에 4byte 할당함. 그리고 이 공간에 1이라는 숫자를 넣어둔 것 <br/> • param1은 변수라고 부름                                                                               |
|main.calculate2(param1, param2)| • main의 calculate2 함수에 param1과 param2의 값을 넘김 <br/> • () 공간을 파라미터라고 부름                                                                                                 |

<br/>

## 📑 숙제 📑

키보드를 통해 숫자와 더하기, 곱하기, 나누기 표식을 입력받고 계산된 결과를 출력하기
> ex) 입력값: 2 * 4  → 출력값: 8 