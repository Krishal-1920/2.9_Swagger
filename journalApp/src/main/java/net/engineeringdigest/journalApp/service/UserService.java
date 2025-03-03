package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserService.class);

    public boolean saveNewUser(@NotNull User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of("USER"));
            userRepository.save(user);
            return true;
        }
        catch (Exception e){
//            log.error("Error occured");
//            log.warn("Hahahahah");
//            log.info("hahhaha");
//            log.debug("ksjhfbhfbhbd");
//            log.trace("ldfbljsdbfjkdk");

            return false;

        }
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    // For Admin creation
    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of("USER", "ADMIN"));
        userRepository.save(user);
    }
}
