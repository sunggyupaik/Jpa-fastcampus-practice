package com.example.demo.domain.listener;

import com.example.demo.domain.User;
import com.example.demo.domain.UserHistory;
import com.example.demo.repository.UserHistoryRepository;
import com.example.demo.util.BeanUtils;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class UserEntityListener {
    @PostPersist
    @PostUpdate
    public void prePersistAndPreUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;

        UserHistory userHistory = new UserHistory();
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setAddress(user.getAddress());
        userHistory.setUser(user);

        userHistoryRepository.save(userHistory);
    }
}
