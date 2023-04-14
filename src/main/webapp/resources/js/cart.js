
//상단 nav 메뉴 고정
$(document).ready(function(){
    var menuOffset = $('.menu').offset();
    $(window).scroll(function(){
      if($(document).scrollTop() > menuOffset.top){
        $('.menu').addClass('fixedmenu');
      } else{
        $('.menu').removeClass('fixedmenu');
      }
    });
  });

//top banner
$(document).ready(function(){
    $(".topBannerBtn").on("click", function(){ // 버튼 클릭하면
      $(".topBanner").slideUp(); // 탑배너 사라지게 함
      });
    });


//장바구니 메인
$(document).ready(function(){
	
  /* 종합 정보 섹션 정보 삽입 */
  setTotalInfo();	
      
  /* 이미지 삽입 */
  $(".image_wrap").each(function(i, obj){
      
    const bobj = $(obj);
        
    if(bobj.data("product_no")){
      const uploadPath = bobj.data("path");
      const uuid = bobj.data("uuid");
      const fileName = bobj.data("filename");
          
      const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);
          
      $(this).find("img").attr('src', '/display?fileName=' + fileCallPath);
    } else {
      $(this).find("img").attr('src', '/resources/img/goodsNoImage.png');
    }  
  });    
// });	


/* 체크여부에따른 종합 정보 변화 */
   
$(".cartCheckbox").on("change", function(){
  /* 총 주문 정보 세팅(배송비, 총 가격, 물품 수) */
  setTotalInfo($(".cartinfo_td"));
});

/* 체크박스 전체 선택 */
$(".allcheckboxInput").on("click", function(){
  /* 체크박스 체크/해제 */
  if($(".allcheckboxInput").prop("checked")){
  $(".cartCheckbox").prop("checked", true);
  } else{
    $(".cartCheckbox").prop("checked", false);
  }
      
//   /* 총 주문 정보 세팅(배송비, 총 가격, 물품 수) */
  setTotalInfo($(".cartinfo_td"));	
      
});

/* 총 주문 정보 세팅(배송비, 총 가격, 물품 수) */
function setTotalInfo(){
      
  let totalPrice = 0;				// 총 가격
  let deliveryPrice = 0;			// 배송비-> 3000원으로 고정시킬건데 상품이 0원일 때는 배송비 0원으로 해줘야해서 조건문 추가
  let finalTotalPrice = 0; 		// 최종 가격(총 가격 + 배송비)
     
     //cartinfo_td 인 td 순회하는데 check되어 있는 상품만 total로 !!
  $(".cartinfo_td").each(function(index, element){ // each 메소드는 td객체가 존재하는 만큼 순회
      //제이쿼리 find 메소드로 input 태그에 접근    
    if($(element).find(".cartCheckbox").is(":checked") === true){	//체크여부
      
    // 총 가격
      totalPrice += parseInt($(element).find(".cartTotalPriceInput").val());
   }
  });

    //배송비
    if(totalPrice == 0 ){
      deliveryPrice = 0;
    } else{
      deliveryPrice = 3000;
    }
      
    //최종가격~!!!!!!!!!!!!
    finalTotalPrice = totalPrice + deliveryPrice;
      
      
    // 총 가격
    $(".totalPrice_span").text(totalPrice.toLocaleString()); // toLocaleString은 숫자 세자리 마다 쉼표찍어줌
    
    // 배송비
    $(".delivery_price").text(deliveryPrice);	
    
    // 최종 가격(총 가격 + 배송비)
    $(".finalTotalPrice_span").text(finalTotalPrice.toLocaleString());		
}


/* 수량버튼 */
$(".plus_btn").on("click", function(){
  let quantity = $(this).parent("div").find("input").val();
  $(this).parent("div").find("input").val(++quantity);
});

$(".minus_btn").on("click", function(){
  let quantity = $(this).parent("div").find("input").val();
  if(quantity > 1){
    $(this).parent("div").find("input").val(--quantity);		
  }
});

// /* 수량 수정 버튼 */
$(".quantity_modify_btn").on("click", function(){
  let no = $(this).data("no");
  let count = $(this).parent("td").find("input").val();
  $(".update_cartId").val(no);
  $(".update_cartCount").val(count);
  $(".quantity_update_form").submit();
      
});

// /* 장바구니 삭제 버튼 */
$(".delete_btn").on("click", function(e){
   e.preventDefault();
   const cartNo = $(this).data("no");
   $(".delete_cartNo").val(cartNo);
   $(".quantity_delete_form").submit();
});
    
      
/* 주문 페이지 이동 */	
// $(".order_btn").on("click", function(){
      
//   let form_contents ='';
//   let orderNumber = 0;
      
//   $(".cartinfo_td").each(function(index, element){
        
//     if($(element).find(".cartCheckbox").is(":checked") === true){	//체크여부
          
//       let bookId = $(element).find(".individual_bookId_input").val();
//       let bookCount = $(element).find(".cartCount").val();
          
//       let bookId_input = "<input name='orders[" + orderNumber + "].bookId' type='hidden' value='" + bookId + "'>";
//       form_contents += bookId_input;
          
//       let bookCount_input = "<input name='orders[" + orderNumber + "].bookCount' type='hidden' value='" + bookCount + "'>";
//       form_contents += bookCount_input;
          
//       orderNumber += 1;
          
//     }
//   });	
//   $(".order_form").html(form_contents);
//   $(".order_form").submit();
      
//  });    
});