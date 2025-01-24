package vo.day1;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬복을 사용합니다.
@Getter
@Setter
@ToString
@AllArgsConstructor   // 모든 프로퍼티값 초기화 생성자 코드
// @RequiredArgsConstructor     // final 변수만 초기화 커스텀 생성자
@NoArgsConstructor
public class Customer {
    private String customId;
    private String name;
    private String email;
    private int age;
    private Date regDate;
    private String postcode;

    // 일부 프로퍼티 변수 초기화 생성자
    public Customer(String customId, String name, String email, int age, Date regDate) {
        this.customId = customId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.regDate = regDate;
    }

    

}

// ORM 프레임웍을 사용하면 기본생성자, setter 가 필요합니다.