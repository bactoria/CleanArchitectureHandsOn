package me.bactoria.hexagonal.account.application.port.`in`

import me.bactoria.hexagonal.account.domain.Account
import me.bactoria.hexagonal.account.domain.Money

/**
 * SendMoneyCommand 는 유스케이스 API의 일부이므로 인커밍 포트 패키지에 위치하는 것이 맞다. (p.40)
 *
 * SendMoneyCommand 가 정상적으로 생성되면 항상 유효한 값을 가진다. 객체 생성 시 유효성 검증이 수행되며, 불변 필드만 존재하기에 잘못된 상태로 변경될 여지도 없기 때문이다. (p.40)
 */
data class SendMoneyCommand(
	val sourceAccountId: Account.AccountId,
	val targetAccountId: Account.AccountId,
	val money: Money
) {
	init {
		require(money.isGreaterThan(Money.ZERO))
	}
}
