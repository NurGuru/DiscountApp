import data.repository.GuestsRepositoryImpl
import data.source.*
import domain.*
import ui.GuestsAdapter

object Di {
    //зависимости для слоя data
    fun createFileLoader(): FileHandler = FileHandler()

    fun createCsvParsr(): CsvParser = CsvParser()

    fun createMultiThreading(): MultiThreading = MultiThreading(createFileLoader())


    fun createDataSource(): GuestsDataSource =
        GuestsDataSourceImpl(createCsvParsr(), createFileLoader(), createMultiThreading())

    fun createRepository(): GuestsRepository = GuestsRepositoryImpl(createDataSource())

    fun createDataEntry(): DataEntry = DataEntry()

    //зависимости для слоя domain

    fun createDiscountApplierUseCase(): DiscountApplierUseCase = DiscountApplierUseCase()

    fun createSaveGuestsListUseCase(): SaveGuestsListUseCase = SaveGuestsListUseCase(createRepository())

    fun createAdder(): ApplyDiscountUseCase =
        ApplyDiscountUseCase(createDiscountApplierUseCase(), createRepository(), createSaveGuestsListUseCase())

    fun createChangeMoneySpentUseCase(): AddMoneySpentUseCase = AddMoneySpentUseCase(
        createRepository(), createAdder()
    )

    fun createAddVisitsUseCase(): AddVisitsUseCase =
        AddVisitsUseCase(createRepository(), createAdder())

    //зависимости для слоя UI
    fun createGuestAdapter() = GuestsAdapter(
        repository = createRepository(),
        addVisitsUseCase = createAddVisitsUseCase(),
        changeMoneySpentUseCase = createChangeMoneySpentUseCase(),
        input = createDataEntry(),
    )
}