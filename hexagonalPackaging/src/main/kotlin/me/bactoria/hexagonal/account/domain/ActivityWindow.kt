package me.bactoria.hexagonal.account.domain


import org.springframework.lang.NonNull
import java.time.LocalDateTime
import java.util.*


/**
 * A window of account activities.
 */
class ActivityWindow {
	/**
	 * The list of account activities within this window.
	 */
	private var activities: MutableList<Activity>

	/**
	 * The timestamp of the first activity within this window.
	 */
	val startTimestamp: LocalDateTime
		get() = run { activities.minByOrNull { it.timestamp } ?: throw IllegalStateException() }.timestamp

	/**
	 * The timestamp of the last activity within this window.
	 * @return
	 */
	val endTimestamp: LocalDateTime
		get() {
			return run { activities.maxByOrNull { it.timestamp } ?: throw IllegalStateException() }.timestamp
		}

	/**
	 * Calculates the balance by summing up the values of all activities within this window.
	 */
	fun calculateBalance(accountId: Account.AccountId): Money {
		val depositBalance: Money = activities.stream()
			.filter { it.targetAccountId == accountId }
			.map { it.money }
			.reduce(Money.ZERO, Money.Companion::add)

		val withdrawalBalance: Money = activities.stream()
			.filter {it.sourceAccountId == accountId }
			.map {it.money}
			.reduce(Money.ZERO, Money.Companion::add)

		return Money.add(depositBalance, withdrawalBalance.negate())
	}

	constructor(@NonNull activities: MutableList<Activity>) {
		this.activities = activities
	}

	constructor(@NonNull vararg activities: Activity?) {
		this.activities = ArrayList(listOf(*activities))
	}

	fun getActivities(): List<Activity> {
		return Collections.unmodifiableList(activities)
	}

	fun addActivity(activity: Activity) {
		activities.add(activity)
	}
}
