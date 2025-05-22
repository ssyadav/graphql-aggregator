package com.satya.graphql.facade;

import com.satya.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserFacade {

    @Autowired private UserService userService;

    public Flux<Map<String, Object>> getUser(List<String> fields) {
        return userService.getUserAsJson()
                .map(fullJson -> filterJson(fullJson, fields));
    }

    private Map<String, Object> filterJson(Map<String, Object> fullJson, List<String> fields) {
        return fullJson.entrySet().stream()
                .filter(entry -> fields.contains(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
