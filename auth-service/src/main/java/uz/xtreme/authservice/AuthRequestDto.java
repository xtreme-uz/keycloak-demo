package uz.xtreme.authservice;

public record AuthRequestDto(
        String username,
        String password
) {
}
