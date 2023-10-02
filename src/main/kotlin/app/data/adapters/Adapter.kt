package app.data.adapters

interface Adapter<E, M> {
     fun toEntity(model: M): E
    fun toModel(entity: E): M
}