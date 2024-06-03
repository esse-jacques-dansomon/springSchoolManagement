package co.essejacques.springschoolmanagement.services.interfaces;

import co.essejacques.springschoolmanagement.mobile.dtos.LoginDto;

public interface IAuthService {
    String login(LoginDto loginDto);
}
