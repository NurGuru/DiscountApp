package domain

interface AddVisitsUseCase {
    fun addVisits(id: Int, addingVisitsCount: Int)
}
