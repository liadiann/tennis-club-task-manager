package task.code.component;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import task.code.model.Administrator;
import task.code.repository.AdministratorRepository;

@AllArgsConstructor
@Component
public class DataInitializer implements ApplicationRunner {
    private final AdministratorRepository administratorRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        var login = "adddmin88";
        var password = "asdf";
        if (administratorRepository.findByLogin(login).isEmpty()) {
            var admin = new Administrator();
            admin.setLogin(login);
            admin.setPasswordDigest(password);
            administratorRepository.save(admin);
        }
    }
}
