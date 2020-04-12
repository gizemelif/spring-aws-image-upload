package com.dataSource;

import com.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataSource {

    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(),"gizem atalay", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(),"janet jones", null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
