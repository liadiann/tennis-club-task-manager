package task.code.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import task.code.repository.AdministratorRepository;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsManager {
    private AdministratorRepository administratorRepository;

    @Override
    public void createUser(UserDetails user) {
        throw new UnsupportedOperationException("unimplemented method");
    }

    @Override
    public void updateUser(UserDetails user) {
        throw new UnsupportedOperationException("unimplemented method");
    }

    @Override
    public void deleteUser(String username) {
        throw new UnsupportedOperationException("unimplemented method");
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        throw new UnsupportedOperationException("unimplemented method");
    }

    @Override
    public boolean userExists(String username) {
        throw new UnsupportedOperationException("unimplemented method");
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        var user = administratorRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }
}
