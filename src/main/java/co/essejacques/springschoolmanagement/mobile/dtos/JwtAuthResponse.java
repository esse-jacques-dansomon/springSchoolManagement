package co.essejacques.springschoolmanagement.mobile.dtos;


import co.essejacques.springschoolmanagement.data.entity.User;
import co.essejacques.springschoolmanagement.data.projections.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
    private UserDetailsProjection user;
    private StudentWithClassRoomProjection student;
}