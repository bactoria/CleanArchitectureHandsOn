package me.bactoria.hexagonal.account.application.service

import me.bactoria.hexagonal.account.application.port.`in`.GetAccountBalanceQuery
import me.bactoria.hexagonal.account.application.port.out.LoadAccountPort
import me.bactoria.hexagonal.account.domain.Account
import me.bactoria.hexagonal.account.domain.Money
import org.springframework.stereotype.Service
import java.time.LocalDateTime

/**
 * 프로젝트 맥락에서 유스케이스로 간주되지 않는다면 실제 유스케이스와 구분하기 위해 쿼리로 구현할 수 있다. 이 클래스처럼 말이다. (p.50)
 * 
 * 읽기 전용 쿼리는 쓰기가 가능한 유스케이스(or 커멘드) 와 코드 상에서 명확하게 구분된다. (패키지는 구분안되네..) (p.51) 
 * 
 * 이런 방식은 CQS / CQRS 같은 개념과 잘 맞는다. (p.51)
 * 
 * 이 서비스는 아웃고잉 포트로 쿼리를 전달하는 것 외에 다른 일은 하지 않는다. 따라서 꼼수를 써서 클라이언트에서 직접 아웃고잉 포트를 호출하게 하고싶은 마음도 들 수 있지만 그러지 말자! (깨진 창문 이론) (p.133)
 */
@Service
class GetAccountBalanceService(
	private val loadAccountPort: LoadAccountPort // 데이터를 로드하기 위해 아웃고잉 포트를 호출
) : GetAccountBalanceQuery { // 인커밍 포트를 구현
	override fun getAccountBalance(accountId: Account.AccountId): Money {
		return loadAccountPort.loadAccount(accountId, LocalDateTime.now()).calculateBalance()
	}
}
