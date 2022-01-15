package me.bactoria.hexagonal.account.application.port.`in`

/**
 * 어댑터와 서비스 사이에 이와 같은 간접 계층을 넣는 이유? 
 * 
 * -> 어플리케이션 코어가 외부 세계와 통신할 수 있는 곳에 대한 명세가 포트이기 때문이다. (p.55)
 */
interface SendMoneyUseCase {
	fun sendMoney(command: SendMoneyCommand)
}
