package app.data.adapters

interface Adapter<in I, out O> {
    operator fun invoke(data: I): O
}