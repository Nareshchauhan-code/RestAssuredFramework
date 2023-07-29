package ProjectLombok;

import lombok.Builder;
import lombok.Getter;
@Builder(toBuilder = true)
@Getter
public class EmployeeDataforLombok {

    private String fristName;
    private String lastName;
    private int age;
    private String gender;
}
