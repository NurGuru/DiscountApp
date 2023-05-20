import data.repository.GuestsRepositoryImpl
import data.repository.OrdersRepositoryImpl
import data.source.*
import domain.*
import ui.GuestsAdapter

object Di {
    //зависимости для слоя data
    fun createFileLoader(): FileHandler = FileHandler()

    fun createCsvParsr(): CsvParser = CsvParser()

    fun createMultiThreading(): MultiThreading = MultiThreading(createFileLoader())


    fun createGuestsDataSource(): GuestsDataSource =
        GuestsDataSourceImpl(createCsvParsr(), createFileLoader(), createMultiThreading())

    fun createGuestsRepository(): GuestsRepository = GuestsRepositoryImpl(createGuestsDataSource())

    fun createDataEntry(): DataEntry = DataEntry()

    fun createOrdersDataSource(): OrdersDataSource =
        OrdersDataSourceImpl(createCsvParsr(), createFileLoader(), createMultiThreading())

    fun createOrdersRepository(): OrdersRepository = OrdersRepositoryImpl(createOrdersDataSource())

    //зависимости для слоя domain

    fun createDiscountApplierUseCase(): DiscountApplierUseCase = DiscountApplierUseCase()

    fun createSaveGuestsListUseCase(): SaveGuestsListUseCase = SaveGuestsListUseCase(createGuestsRepository())

    fun createAdder(): ApplyDiscountUseCase =
        ApplyDiscountUseCase(createDiscountApplierUseCase(), createGuestsRepository(), createSaveGuestsListUseCase())

    fun createChangeMoneySpentUseCase(): AddMoneySpentUseCase = AddMoneySpentUseCase(
        createGuestsRepository(), createAdder()
    )

    fun createAddVisitsUseCase(): AddVisitsUseCase =
        AddVisitsUseCase(createGuestsRepository(), createAdder())

    fun createOrdersUseCase():OrdersUseCase = OrdersUseCase(createOrdersRepository())

    //зависимости для слоя UI
    fun createGuestAdapter() = GuestsAdapter(
        guestsRepository = createGuestsRepository(),
        ordersUseCase= createOrdersUseCase(),
        addVisitsUseCase = createAddVisitsUseCase(),
        changeMoneySpentUseCase = createChangeMoneySpentUseCase(),
        input = createDataEntry(),
    )
}