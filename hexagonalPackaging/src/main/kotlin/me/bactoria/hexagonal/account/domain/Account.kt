package me.bactoria.hexagonal.account.domain

import java.time.LocalDateTime
import java.util.*

class Account private constructor(
	private var id: AccountId?,        // The unique ID of the account.
	val baselineBalance: Money,        // The baseline balance of the account.
	val activityWindow: ActivityWindow // The window of latest activities on this account.
) {

	fun getId(): Optional<AccountId> {
		return Optional.ofNullable(id)
	}

	/**
	 * Calculates the total balance of the account by adding the activity values to the baseline balance.
	 */
	fun calculateBalance(): Money {
		return Money.add(baselineBalance, activityWindow.calculateBalance(id!!))
	}

	/**
	 * &#91;출금&#93; Tries to withdraw a certain amount of money from this account.
	 * If successful, creates a new activity with a negative value.
	 * @return true if the withdrawal was successful, false if not.
	 */
	fun withdraw(money: Money, targetAccountId: AccountId?): Boolean {
		if (!mayWithdraw(money)) {
			return false
		}

		val withdrawal = Activity(
			this.id!!,
			this.id!!,
			targetAccountId!!,
			LocalDateTime.now(),
			money
		)
		activityWindow.addActivity(withdrawal)
		return true
	}

	private fun mayWithdraw(money: Money): Boolean {
		return Money.add(calculateBalance(), money.negate()).isPositiveOrZero
	}

	/**
	 * &#91;예금&#93; Tries to deposit a certain amount of money to this account.
	 * If sucessful, creates a new activity with a positive value.
	 * @return true if the deposit was successful, false if not.
	 */
	fun deposit(money: Money, sourceAccountId: AccountId): Boolean {
		val deposit = Activity(
			this.id!!,
			sourceAccountId,
			id!!,
			LocalDateTime.now(),
			money
		)
		activityWindow.addActivity(deposit)
		return true
	}

	data class AccountId(val value: Long)

	companion object {
		/**
		 * Creates an [Account] entity without an ID. Use to create a new entity that is not yet
		 * persisted.
		 */
		fun withoutId(baselineBalance: Money, activityWindow: ActivityWindow) = Account(null, baselineBalance, activityWindow)

		/**
		 * Creates an [Account] entity with an ID. Use to reconstitute a persisted entity.
		 */
		fun withId(accountId: AccountId, baselineBalance: Money, activityWindow: ActivityWindow) = Account(accountId, baselineBalance, activityWindow)
	}
}
