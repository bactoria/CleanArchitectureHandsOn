package me.bactoria.hexagonal.account.application.service

import me.bactoria.hexagonal.account.application.port.`in`.SendMoneyCommand
import me.bactoria.hexagonal.account.application.port.`in`.SendMoneyUseCase
import me.bactoria.hexagonal.account.application.port.out.AccountLock
import me.bactoria.hexagonal.account.application.port.out.LoadAccountPort
import me.bactoria.hexagonal.account.application.port.out.UpdateAccountStatePort
import org.springframework.stereotype.Service
import javax.transaction.Transactional

/**
 * 하나의 서비스가 하나의 유스케이스를 구현하고, 도메인 모델을 변경하고, 변경된 상태를 저장하기 위해 아웃고잉 포트를 호출한다! (p.38)
 * 서비스는 인커밍/아웃고잉 포트 인터페이스에 의존하고 있다. 세부사항(어댑터) 이 없이도 서비스를 만들 수 있다!!
 */
@Service
@Transactional
class SendMoneyService(
	private val loadAccountPort: LoadAccountPort, // 계좌를 불러오기 위해 아웃고잉 포트 인터페이스 호출
	private val accountLock: AccountLock,
	private val updateAccountStatePort: UpdateAccountStatePort // 계좌를 업데이트하기 위해 아웃고잉 포트 인터페이스 호출
) : SendMoneyUseCase { // 인커밍 포트를 구현
	override fun sendMoney(command: SendMoneyCommand) {
		// TODO: 비즈니스 규칙 검증
		// TODO: 모델 상태 조작
		// TODO: 출력 값 반환
	}
}
