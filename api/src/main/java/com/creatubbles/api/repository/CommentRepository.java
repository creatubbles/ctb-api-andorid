package com.creatubbles.api.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.creatubbles.api.model.CreatubblesResponse;
import com.creatubbles.api.model.comment.Comment;
import com.creatubbles.api.response.ResponseCallback;

import java.util.List;

/**
 * Class allowing to obtain and create comments on creations, galleries and users.
 * <p>
 * Access Restrictions:
 * <ul>
 * <li>With an application only access token you get the published comments and cannot create new comments.</li>
 * <li>With an user access token you get all published comments and comments the user can approve.</li>
 * </ul>
 * </p>
 *
 * @author Pawel Szymanski
 */
public interface CommentRepository {


    /**
     * Method used to obtain comments on a Creation specified by {@code creationId} param.
     *
     * @param page       number of page
     * @param creationId ID of a Creation for which to return comments
     */
    void getForCreation(@Nullable Integer page, @NonNull String creationId,
                        ResponseCallback<CreatubblesResponse<List<Comment>>> callback);

    /**
     * Method used to obtain comments on a Gallery specified by {@code galleryId} param.
     *
     * @param page      number of page
     * @param galleryId ID of a Gallery for which to return comments
     */
    void getForGallery(@Nullable Integer page, @NonNull String galleryId,
                       ResponseCallback<CreatubblesResponse<List<Comment>>> callback);

    /**
     * Method used to obtain comments on a User specified by {@code userId} param.
     *
     * @param page   number of page
     * @param userId ID of a User for which to return comments
     */
    void getForUser(@Nullable Integer page, @NonNull String userId,
                    ResponseCallback<CreatubblesResponse<List<Comment>>> callback);

    /**
     * Method used to create comment on a Creation specified by {@code creationId}.
     */
    void createForCreation(@NonNull Comment comment, @NonNull String creationId,
                           ResponseCallback<CreatubblesResponse<Comment>> callback);

    /**
     * Method used to create comment on a Gallery specified by {@code galleryId}.
     */
    void createForGallery(@NonNull Comment comment, @NonNull String galleryId,
                          ResponseCallback<CreatubblesResponse<Comment>> callback);

    /**
     * Method used to create comment on a User specified by {@code userId}.
     */
    void createForUser(@NonNull Comment comment, @NonNull String userId,
                       ResponseCallback<CreatubblesResponse<Comment>> callback);

    /**
     * Method used to approve a comment specified by {@code commentId}.
     *
     * @param commentId the ID of a comment which to approve
     */
    void approve(@NonNull String commentId, ResponseCallback<Void> callback);

    /**
     * Method used to decline a comment specified by {@code commentId}.
     *
     * @param commentId the ID of a comment which to decline
     */
    void decline(@NonNull String commentId, ResponseCallback<Void> callback);
}
