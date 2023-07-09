package app.data.mappers

interface Mapper<in I, out O> {
    operator fun invoke(map: I): O
}