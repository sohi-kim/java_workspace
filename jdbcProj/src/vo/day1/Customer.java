package vo.day1;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬복을 사용합니다.
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String customId;
    private String name;
    private String email;
    private int age;
    private Date regDate;

}

// ORM 프레임웍을 사용하면 기본생성자, setter 가 필요합니다.