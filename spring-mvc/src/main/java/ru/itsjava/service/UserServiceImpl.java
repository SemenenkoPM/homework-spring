package ru.itsjava.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PetService petService;
    private final CommunityService communityService;

    @Override
    @Transactional
    public User createUser(User user, Pet pet) {
        user.setCommunity(communityService.createCommunity(user.getCommunity().getName()));
        userRepository.save(user);
        pet.setUserId(user.getId());
        petService.createPet(pet);
        user = userRepository.getOne(user.getId());
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkingIfUserExistsWithThisId(long id) {
        return userRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
