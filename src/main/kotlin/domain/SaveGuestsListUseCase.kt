package domain


import domain.model.Guest

class SaveGuestsListUseCase(private val repository: GuestsRepository) {
    fun saveNewGuestsList(guestList:List<Guest>)=repository.saveGuests(guestList)

}