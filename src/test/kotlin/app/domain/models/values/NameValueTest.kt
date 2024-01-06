package app.domain.models.values

import org.junit.Test
import org.junit.Assert.assertEquals

import app.domain.models.ResultModel

internal class NameValueTest {
    @Test
    fun `Should return message failure when Name is valid`() {
        when (val data = NameValue("Gabriel")) {
            is ResultModel.Failure -> {}
            is ResultModel.Success -> {
                assertEquals("Gabriel", data.success())
            }
        }
    }

    @Test
    fun `Should return message failure when Name is invalid`() {
        when (val data = NameValue("")) {
            is ResultModel.Success -> {}
            is ResultModel.Failure -> {
                assertEquals(MessagesValues.INVALID_NAME.message, data.failure.message)
            }
        }
    }

    @Test
    fun `Should return message failure when Name is invalid with partial validations`() {
        when (val data = NameValue("Ga")) {
            is ResultModel.Success -> {}
            is ResultModel.Failure -> {
                assertEquals(MessagesValues.INVALID_NAME.message, data.failure.message)
            }
        }
    }
}
