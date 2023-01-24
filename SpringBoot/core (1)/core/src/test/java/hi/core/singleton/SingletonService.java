package hi.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonService {

    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    //2. public 으로 열어서 객체 인스턴스가 필요하면 이 static 메소드를 통해서만 조회하도록 허용
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private 으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() {

        //private으로 생성자를 막아두었다. 컴파일 오류 발생!
        //new SingletonService();

        //1.조회 : 호출 할 때마다 같은 객체 반환
        SingletonService singletonService1 = SingletonService.getInstance();

        //2.조회 : 호출 할 때마다 같은 객체 반환
        SingletonService singletonService2 = SingletonService.getInstance();

        //참조값이 같은 것을 확인
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // singletonService1 == singletonService2
        assertThat(singletonService1).isSameAs(singletonService2);
        singletonService1.logic();
    }
}
