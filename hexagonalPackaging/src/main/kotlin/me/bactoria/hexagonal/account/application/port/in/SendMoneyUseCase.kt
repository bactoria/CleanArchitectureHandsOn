package me.bactoria.hexagonal.account.application.port.`in`

interface SendMoneyUseCase {
	fun sendMoney(command: SendMoneyCommand)
}
