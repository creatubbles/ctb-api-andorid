package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.PasswordChange;
import com.creatubbles.api.model.hashtag.Hashtag;
import com.creatubbles.api.model.school.School;
import com.creatubbles.api.model.user.AccountDetails;
import com.creatubbles.api.model.user.MultipleCreators;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.UserSortMode;

import java.util.List;

/**
 * Created by Janek on 18.02.2016.
 */
public interface UserRepository {

    String CURRENT_USER = "me";

    void searchUsers(@Nullable Integer page, @NonNull String query, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's profile.
     *
     * @param id the ID of the user for which we want to get the results
     */
    void getUser(@NonNull String id, @Nullable ResponseCallback<CreatubblesResponse<User>> callback);

    /**
     * Method used to obtain current user's profile.
     */
    void getUser(@Nullable ResponseCallback<CreatubblesResponse<User>> callback);

    /**
     * Method used to obtain current user's creators.
     */
    void getCreators(@Nullable Integer page, @Nullable String query, @Nullable UserSortMode sortMode, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain current user's managers.
     */
    void getManagers(@Nullable Integer page, @Nullable String query, @Nullable UserSortMode sortMode, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain current user's 'My Connections'.
     */
    void getConnections(@Nullable Integer page, @Nullable String query, @Nullable UserSortMode sortMode, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain current user's followed users.
     */
    void getFollowedUsers(@Nullable Integer page, @Nullable String query, @Nullable UserSortMode sortMode, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's creators.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getCreators(@NonNull String userId, @Nullable String query, @Nullable Integer page, @Nullable UserSortMode sortMode, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's managers.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getManagers(@NonNull String userId, @Nullable String query, @Nullable Integer page, @Nullable UserSortMode sortMode, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's followed users.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getFollowedUsers(@NonNull String userId, @Nullable Integer page, @Nullable String usernameFilter, ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain user's 'My Connections'.
     *
     * @param userId the ID of the user for which we want to get the results
     */
    void getConnections(@NonNull String userId, @Nullable String query, @Nullable Integer page, @Nullable UserSortMode sortMode, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to create new Creator managed by current user.
     */
    void createUser(@NonNull NewUser newUser, @Nullable ResponseCallback<CreatubblesResponse<User>> callback);

    /**
     * Method used to obtain users available for user switching.
     */
    void getUsersAvailableForSwitching(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to search obtain users available for user switching.
     */
    void getUsersAvailableForSwitching(@Nullable Integer page, @Nullable String query, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * This method adds multiple creators (managed users) to the list of creators managed by logged-in user.
     * Those creators have name generated automatically based on current user’s name.
     *
     * @param multipleCreators object defining required params
     */
    void createMultipleCreators(@NonNull MultipleCreators multipleCreators, @Nullable ResponseCallback<CreatubblesResponse<MultipleCreators>> callback);

    /**
     * Method used to obtain current user’s creators by group.
     */
    void getCreatorsFromGroup(@NonNull String groupId, @Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    /**
     * Method used to obtain current user's account details. This requires user access token
     * and the user must be manager of given user.
     *
     * @see AccountDetails
     */
    void getAccountDetails(@Nullable ResponseCallback<CreatubblesResponse<AccountDetails>> callback);

    /**
     * Method used to obtain specific user's account details. This requires user access token
     * and the user must be manager of given user.
     *
     * @see AccountDetails
     */
    void getAccountDetails(@NonNull String userId, @Nullable ResponseCallback<CreatubblesResponse<AccountDetails>> callback);

    /**
     * Method used to update details of user specified by {@code userId}.This requires user access token
     * and the user must be manager of given user.
     */
    void updateAccountDetails(@NonNull String userId, @NonNull AccountDetails accountDetails, @Nullable ResponseCallback<Void> callback);

    /**
     * Method used to link user with a School.
     */
    void linkSchoolWithAccount(@NonNull String userId, @NonNull School school, @Nullable ResponseCallback<Void> callback);

    /**
     * Method used to change user's password. In case of managed user you only need to provide new password.
     * When changing manager's password you have to provide both new and current password.
     */
    void changePassword(@NonNull String userId, @NonNull PasswordChange passwordChange, @Nullable ResponseCallback<CreatubblesResponse<User>> callback);

    /**
     * Method used to obtain current user's 'My Connections' filtered by {@code query} param.
     */
    void searchConnections(@NonNull String query, @Nullable Integer page, @Nullable UserSortMode sortMode, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    void getSuggestions(@Nullable Integer page, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    void getFollowers(@NonNull String userId, @Nullable Integer page, @Nullable String query, @Nullable ResponseCallback<CreatubblesResponse<List<User>>> callback);

    void getFollowedHashtags(@NonNull String userId, @Nullable Integer page, @Nullable String query, @Nullable ResponseCallback<CreatubblesResponse<List<Hashtag>>> callback);
}
