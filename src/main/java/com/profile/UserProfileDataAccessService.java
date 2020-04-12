package com.profile;

import com.dataSource.FakeUserProfileDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileDataAccessService {
    private final FakeUserProfileDataSource fakeUserProfileDataSource;

    @Autowired
    public UserProfileDataAccessService(FakeUserProfileDataSource fakeUserProfileDataSource){
        this.fakeUserProfileDataSource = fakeUserProfileDataSource;
    }

    List<UserProfile> getUserProfiles(){
        return fakeUserProfileDataSource.getUserProfiles();
    }
}
