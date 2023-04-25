package org.zerock.myapp.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
	
	//private String orderId; // 주문번호			-> MYMG_ORDER 테이블의 No 컬럼 인가..?
	private Integer no; // 주문번호			-> MYMG_ORDER 테이블의 No 컬럼 인가..?
	private String addressee; // 배송 받는사람
	private String memberId; // 주문 회원 아이디
//	private String memberAddr1; // 우편번호
	private Integer memberAddr1; // 우편번호
	private String memberAddr2; // 회원 주소
	private String memberAddr3; // 회원 상세주소
	private String orderState; // 주문 상태
	private List<OrderItemDTO> orders;	// 주문 상품
	private int delivery; // 배송비
	private Date orderDate; // 주문 날짜
	
	// DB테이블 존재 하지 않는 데이터 

	private int orderSalePrice; // 상품가격
	private int orderFinalSalePrice; // 최종 상품 가격

	// 주문작업에 필요한 데이터 세팅
	public void getOrderPriceInfo() {
		// 상품 비용
			for(OrderItemDTO order : orders) {
				orderSalePrice += order.getTotalPrice();
			}
		// 배송비
			if(orderSalePrice >= 30000) {
				delivery = 0;
			} else if (orderSalePrice == 0) {       
	            delivery = 0;   
	        } else {
				delivery = 3000;
			}
		// 최종 비용(상품 비용 + 배송비) -> 흠.. 할인가격 넣어줘야하나.. 나중에 출력해보고 다시 보자!
			orderFinalSalePrice = orderSalePrice + delivery;
	}
 
	
} // endclass
