package org.aossie.agoraandroid.apitesting.user

import okhttp3.mockwebserver.MockResponse
import org.aossie.agoraandroid.apitesting.BaseTest
import org.aossie.agoraandroid.utilities.MockFileParser
import org.junit.Assert
import org.junit.Test
import retrofit2.Response
import java.io.IOException

class UpdateUserTest : BaseTest() {

  @Test
  @Throws(IOException::class)
  fun updateUserTest() {

    val updateUserRequest:String=MockFileParser("requests/user_requests/update_user_request.json").content
    val updateUserResponse:String=MockFileParser("responses/user_responses/update_user_response.json").content

    mockWebServer.enqueue(MockResponse().setBody(updateUserRequest))
    val response: Response<*> = apiService.updateUser(
            "authToken",
            updateUserResponse
        )
        .execute()
    Assert.assertEquals(response.body(), updateUserRequest)
  }
}