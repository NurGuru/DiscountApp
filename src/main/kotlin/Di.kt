import data.source.CsvParser
import data.source.FileLoader
import data.source.GuestsDataSource
import data.source.GuestsDataSourceImpl
import domain.GuestsRepository
import domain.GuestsUseCase
import domain.GuestsUseCaseImpl
import data.repository.GuestsRepositoryImpl
import ui.GuestsAdapter

object Di {
    //зависимости для слоя data
    fun createFileLoader(): FileLoader = FileLoader()
    fun createCsvParsr(): CsvParser = CsvParser()
    fun createDataSource(): GuestsDataSource = GuestsDataSourceImpl(createCsvParsr(), createFileLoader())
    fun createRepository(): GuestsRepository = GuestsRepositoryImpl(createDataSource())

    //зависимости для слоя domain
    fun createGuestUseCase(): GuestsUseCase = GuestsUseCaseImpl(createRepository())

    //зависимости для слоя UI
    fun createGuestAdapter() = GuestsAdapter(guestsUseCase = createGuestUseCase())
}