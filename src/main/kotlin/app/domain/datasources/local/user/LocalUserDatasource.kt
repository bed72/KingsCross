package app.domain.datasources.local.user

import app.domain.parameters.authentication.SignUpParameter

interface LocalUserDatasource {
    suspend fun create(parameter: SignUpParameter)
}
