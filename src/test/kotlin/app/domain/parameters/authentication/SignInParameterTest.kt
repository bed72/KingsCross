package app.domain.parameters.authentication

import org.junit.Test
import org.junit.Before
import org.junit.Assert.assertEquals

import app.domain.values.EmailValue
import app.domain.values.PasswordValue

import app.factories.authentication.SignInFactory

class SignInParameterTest {
    private lateinit var factory: SignInFactory

    @Before
    fun setUp() {
        factory = SignInFactory()
    }

    @Test
    fun `Should try validate SignInParams return success`() {
        factory.validParams.isValid().map { (email, password) ->
            assertEquals(email.value, "email@email.com")
            assertEquals(password.value, "P@ssw0rD")
        }
    }

    @Test
    fun `Should try validate SignInParams return failure when e-mail is invalid`() {
        factory.invalidParams
            .copy(
                email = EmailValue(""),
                password = PasswordValue("P@ssw0rD"),
            )
            .isValid()
            .mapLeft { message -> assertEquals(message, listOf("Preencha seu e-mail.")) }
    }

    @Test
    fun `Should try validate SignInParams return failure when password is invalid`() {
        factory.invalidParams
            .copy(
                email = EmailValue("email@email.com"),
                password = PasswordValue(""),
            )
            .isValid().mapLeft { message -> assertEquals(message, listOf("Preencha sua senha.")) }
    }

    @Test
    fun `Should try validate SignInParams return failure when email and password is invalid`() {
        val expect = listOf(
            "O e-mail precisa ser válido.",
            "A senha presica conter caracteres numéricos.",
        )

        factory.invalidParams
            .copy(
                email = EmailValue("emailemail.com"),
                password = PasswordValue("P@sswrD"),
            )
            .isValid().mapLeft { message -> assertEquals(message, expect) }
    }
}
