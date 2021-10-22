package ru.backend.supermarket.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.backend.supermarket.config.security.CustomPrincipal;
import ru.backend.supermarket.model.User;
import ru.backend.supermarket.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(s);
        if(user.isPresent()) {
            return new CustomPrincipal(user.get());
        }
        throw new UsernameNotFoundException("Пользователь не найден");
    }
}
