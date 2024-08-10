package Support.Service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LoginDto {
    private String userNameOrEmail;
    private String password;
}

