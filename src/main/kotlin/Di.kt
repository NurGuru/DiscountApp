import data.repository.GuestsRepositoryImpl
import data.source.*
import domain.*
import ui.GuestsAdapter

object Di {
    //зависимости для слоя data
    fun createFileLoader(): FileLoader = FileLoader()
    fun createCsvParsr(): CsvParser = CsvParser()
    fun createSaver():Saver= Saver()
    fun createDataSource(): GuestsDataSource = GuestsDataSourceImpl(createCsvParsr(), createFileLoader())
    fun createRepository(): GuestsRepository = GuestsRepositoryImpl(createDataSource())

    //зависимости для слоя domain
    fun createGuestUseCase(): GuestsUseCase = GuestsUseCaseImpl(createRepository())
    fun createAddVisitsUseCase(): AddVisitsUseCase = AddVisitsUseCaseImpl(createGuestUseCase(), createRepository(),
        createSaver()
    )

    //зависимости для слоя UI
    fun createGuestAdapter() = GuestsAdapter(
        guestsUseCase = createGuestUseCase(),
        addVisitsUseCase = createAddVisitsUseCase()
    )
}