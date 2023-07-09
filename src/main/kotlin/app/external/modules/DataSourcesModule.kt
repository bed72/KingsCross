package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.data.datasources.authentication.SignUpDatasource
import app.data.datasources.authentication.SignUpDatasourceImpl

val datasourceModule = module {
    factoryOf(::SignUpDatasourceImpl) bind SignUpDatasource::class
}
