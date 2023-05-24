package ui

import domain.model.Status
import data.source.DataEntry
import domain.*

class GuestsAdapter(
    private val guestsRepository: GuestsRepository,
    private val ordersUseCase: OrdersUseCase,
    private val addVisitsUseCase: AddVisitsUseCase,
    private val changeMoneySpentUseCase: AddMoneySpentUseCase,
    private val input: DataEntry,
) {
    /**
     * [changeGuestVisitsAndMoneySpent] - функция вызвает добавление визитов и следом добавление потраченных денег
     *
     * [addVisitsToGuest] - добавление визитов гостю
     *
     * [addMoneySpentToGuest] - добавление потраченных денег гостю
     *  (используется после [addVisitsToGuest])
     *
     * [consoleApp] - имитация консольного приложения, чтоб легко посмотреть что все работает
     */
    fun getGuestByIdAndPrintInfo(id: Int) {
        val guest = guestsRepository.getGuestById(id)
        if (guest != null) {
            println(
                """
               Имя гостя с id ${guest.id} - ${guest.name}
               Телефон гостя ${guest.name} - ${guest.number}
               Гость ${guest.name} постетил заведение ${guest.visits} раз
               Гость ${guest.name} потратил ${guest.moneySpent}руб.
               Статус гостя ${guest.name} - ${guest.status}
               У гостя ${guest.name} скидка ${guest.discount}
               
            """.trimIndent()
            )
        }
    }

    fun getGuestsWithStatus(status: Status) {
        for (guest in guestsRepository.getGuestListByStatus(status)) {
            println("У гостя ${guest.name} статус ${guest.status}")
        }
    }

    fun changeGuestVisitsAndMoneySpent(id: Int) {
        addVisitsToGuest(id)
        addMoneySpentToGuest(id)
    }

    private fun addVisitsToGuest(id: Int) {
        val guest = guestsRepository.getGuestById(id)
        println("\nСколько посещений добавить гостю ${guest!!.name}?")
        val input = input.enterInt()
        addVisitsUseCase.addVisits(id, input)
    }

    private fun addMoneySpentToGuest(id: Int) {
        val guest = guestsRepository.getGuestById(id)
        println("Какую сумму оставил гостю ${guest!!.name}?")
        val input = input.enterInt()
        changeMoneySpentUseCase.addMoneySpent(id, input)
    }

    fun consoleApp() {
        while (true) {
            println("Работатет поток: ${Thread.currentThread().name}\n")
            /**добавил для наглядности,
            чтоб было видно, что загрузка файлов и остальная логика работают в разных потоках*/

            println("Меню: 1- Найти гостя, 2- Список гостей по статусу, 3- Добавить гостю данные, 4- Смотреть статистику по чекам, 0- выход")

            when (readln().toInt()) {
                0 -> break

                1 -> {
                    println("Введите id гостя")
                    val inputNumber = input.enterInt()
                    getGuestByIdAndPrintInfo(inputNumber)
                }

                2 -> {
                    println("Отобразить гостей со статусом: 1-NEW, 2-GOOD, 3-VIP")
                    when (readln().toInt()) {
                        1 -> {
                            getGuestsWithStatus(Status.NEW)
                        }

                        2 -> {
                            getGuestsWithStatus(Status.GOOD)
                        }

                        3 -> {
                            getGuestsWithStatus(Status.VIP)
                        }

                        else -> println("Такой команды нет, выберите нужную команду.")
                    }
                }

                3 -> {
                    println("Введите id гостя")
                    val input = input.enterInt()
                    changeGuestVisitsAndMoneySpent(input)
                }

                4 -> {
                    println("1- Показать сумму всех чеков, 2- Показать средний чек")
                    when (readln().toInt()) {
                        1 -> println("Общая сумма всех чеков = ${ordersUseCase.getSumOfAllOrders()}")

                        2 -> println("Средний чек = ${ordersUseCase.getAverageOrderSum()}")
                    }

                }

                else -> println("Такой команды нет, выберите нужную команду.")
            }
        }
    }
}