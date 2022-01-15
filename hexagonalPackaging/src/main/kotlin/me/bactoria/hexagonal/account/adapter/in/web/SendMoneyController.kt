package me.bactoria.hexagonal.account.adapter.`in`.web

import me.bactoria.hexagonal.account.application.port.`in`.SendMoneyCommand
import me.bactoria.hexagonal.account.application.port.`in`.SendMoneyUseCase
import me.bactoria.hexagonal.account.domain.Account
import me.bactoria.hexagonal.account.domain.Money
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 웹어댑터 책임 (p.56)
 *
 * 1. HTTP 요청을 자바 객체로 매핑
 *
 * 2. 권한 검사
 *
 * 3. 입력 유효성 검증
 *
 * 4. 입력을 유스케이스의 입력 모델로 매핑
 *
 * 5. 유스케이스 호출
 *
 * 6. 유스케이스의 출력을 HTTP 로 매핑
 *
 * 7. HTTP 응답을 반환
 * 
 * 웹 어댑터는 HTTP 요청을 애플리케이션의 유스케이스에 대한 메서드 호출로 변환하고, 결과를 다시 HTTP 로 변환할 뿐이다. 어떠한 도메인 로직도 수행하지 않는다. (p.61)
 * 
 * 애플리케이션 계층에서 HTTP 에 대한 상세정보를 노출시키지 말아야 한다. 그래야 추후 HTTP 대신 다른 수단으로 변경하기가 용이하다.
 *
 * 컨트롤러는 하나에 때려넣기 보다는 여러개로 분할하는 것이 더 좋다. (코드는 적을수록 파악하기 쉽다.)
 *
 * 가급적이면 메서드와 클래스명은 유스케이스를 최대한 반영해서 짓자. (p.60)
 *
 */
@RestController
class SendMoneyController(
	private val sendMoneyUseCase: SendMoneyUseCase
) {
	@PostMapping("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
	fun sendMoney(
		@PathVariable("sourceAccountId") sourceAccountId: Long,
		@PathVariable("targetAccountId") targetAccountId: Long,
		@PathVariable("amount") amount: Long
	) {

		val command = SendMoneyCommand(
			Account.AccountId(sourceAccountId),
			Account.AccountId(targetAccountId),
			Money.of(amount)
		)

		sendMoneyUseCase.sendMoney(command)
	}


}
