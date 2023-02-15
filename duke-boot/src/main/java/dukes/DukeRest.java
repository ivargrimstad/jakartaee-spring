package dukes;

import dukes.dep.Account;
import dukes.dep.AccountRepository;
import dukes.lib.User;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class DukeRest {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/users")
    ResponseEntity<String> addUser(@Valid @RequestBody User user) {

        Account account = new Account();
        account.setName("Duke");
        account.setEmail(user.getEmail());

        accountRepository.save(account);

        System.out.println("Account created with ID: " + account.getId());
        return ResponseEntity.ok("User is valid: " + user.getEmail());
    }

    @GetMapping("/users")
    List<User> listusers() {

        return StreamSupport.stream(accountRepository.findAll().spliterator(), false)
                .map( a -> new User(a.getEmail())).collect(Collectors.toList());

    }
}
