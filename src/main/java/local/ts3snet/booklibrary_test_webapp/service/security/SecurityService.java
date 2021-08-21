package local.ts3snet.booklibrary_test_webapp.service.security;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
