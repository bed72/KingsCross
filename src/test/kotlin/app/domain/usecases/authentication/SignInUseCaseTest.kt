package app.domain.usecases.authentication

import arrow.core.Either

import org.junit.Rule
import org.junit.Test
import org.junit.Before

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK

import junit.framework.TestCase.assertTrue
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.ExperimentalCoroutinesApi

import app.rule.MainCoroutineRule

import app.factories.authentication.SignInFactory

import app.domain.repositories.authentication.AuthenticationRepository

import app.external.network.responses.message.MessageResponse
import app.external.network.responses.authentication.AuthenticationResponse

@ExperimentalCoroutinesApi
internal class SignInUseCaseTest {
    @get:Rule
    val rule = MainCoroutineRule()

    private lateinit var useCase: SignInUseCase

    private lateinit var factory: SignInFactory

    @MockK(relaxUnitFun = true)
    private lateinit var repository: AuthenticationRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        factory = SignInFactory()
        useCase = SignInUseCaseImpl(rule.dispatcher, repository)
    }

    @Test
    fun `Should return value not null when trying sign in account`() = runTest {
        coEvery { repository.signIn(any()) } returns  factory.failure

        val response = useCase(factory.validParams).first()

        assertNotNull(response)
    }

    @Test
    fun `Should only call repository once when trying sign in account`() = runTest {
        coEvery { repository.signIn(any()) } returns  factory.failure

        useCase(factory.validParams).first()

        coVerify(exactly = 1) { repository.signIn(any()) }
    }

    @Test
    fun `Should return failure value when trying a sign in account`() = runTest {
        coEvery { repository.signIn(any()) } returns  factory.failure

        val response = useCase(factory.validParams).first()

        assertTrue(response is Either.Left<Pair<Int, MessageResponse>>)
    }

    @Test
    fun `Should return failure value with status and message when trying a sign in account`() = runTest {
        coEvery { repository.signIn(any()) } returns  factory.failure

        val response = useCase(factory.validParams).first()

        response.onLeft { (status, data) ->
            assertEquals(status, 400)
            assertEquals(data.error, "Credenciais inválidas.")
        }
    }

    @Test
    fun `Should return success value when trying a sign in account`() = runTest {
        coEvery { repository.signIn(any()) } returns  factory.success

        val response = useCase(factory.validParams).first()

        assertTrue(response is Either.Right<Pair<Int, AuthenticationResponse>>)
    }

    @Test
    fun `Should return success value with status and message when trying a sign in account`() = runTest {
        coEvery { repository.signIn(any()) } returns  factory.success

        val response = useCase(factory.validParams).first()

        response.onRight { (status, data) ->
            assertEquals(status, 200)
            assertEquals(data.expireIn, 3600)
            assertEquals(data.accessToken, "5CQcsREkB5xcqbY1L...")
            assertEquals(data.refreshToken, "5CQcsREkB5xcqbY1L...")
            assertEquals(data.user.email, "bed@email.com")
            assertEquals(data.user.userMetadata.name, "Bed")
        }
    }
}
