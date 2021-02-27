package com.dailycodebuffer.user.VO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}

// ㅅㅣ부레 서로 Postman으로 통신이 안된다..
// LB and API Gateway = Pros Cons  // Secure ?

