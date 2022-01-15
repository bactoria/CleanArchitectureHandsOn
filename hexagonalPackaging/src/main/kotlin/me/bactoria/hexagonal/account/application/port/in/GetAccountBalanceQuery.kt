package me.bactoria.hexagonal.account.application.port.`in`

import me.bactoria.hexagonal.account.domain.Account
import me.bactoria.hexagonal.account.domain.Money

interface GetAccountBalanceQuery {
	fun getAccountBalance(accountId: Account.AccountId): Money
}
