package app.framework.mappers

interface Mapper<in M, out D> {
    operator fun invoke(model: M): D
}