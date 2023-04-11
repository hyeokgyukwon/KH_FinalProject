<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 목록</title>
    <!-- <link href="/admin_page/css/notice/notice_list.css" type="text/css" rel="stylesheet" /> -->
    <link rel="stylesheet" href="/resources/css/admin/common.css">

    <style>
    
    .content {
        font-size: 13px;
        font-weight: 600;
        font-family: "맑은 고딕",AppleGothic,Dotum,"돋움",sans-serif;
        /* color: #000; */
        padding: 0;
        width : 990px;
        height: 700px;
        /* margin: 0 0 0 180px; */
        margin : 0 20%;
    }

    .content h1 {
        margin : 0 0 0 40px;
        padding-top : 20px;
    }

    table {
        display: table;
        width: 950px;
        /* border :#000 1px solid; */
        /* width: 100%; */
        margin: 40px;
        margin-bottom: 0px;
        /* border-collapse: collapse; */
        border-top: 4px solid #ceced2;
    }

    table th {
        /* border :#000 1px solid; */
        border-bottom: 1px solid #ceced2;
        padding : 8px;
    }

    table td {
        /* border :#000 1px solid; */
        padding: 14px 10px 13px 10px;
        border-bottom: 1px solid #ceced2;
        text-align: center;
        font-size: 13px;
        
    }

    .title {
        text-align: left;
    }

    /* ====================== 페이지 이동 ======================= */
    .page {
        margin-left: 250px;
    }

    .pagenation {
        /* display: inline-block; */
        text-align: center;
        margin-right: 20%;
        margin-bottom: 15px;
    }

    .pagenation ul {
        text-align: center;
        vertical-align: middle;
        padding: 0px;
        margin:0px;
    }

    .pagenation li {
        /* border: 1px black solid; */
        display: inline-block;
        min-width: 30px;
        vertical-align: middle;
        text-decoration: none;
        border: 1px solid #ceced2;
        margin-bottom: 20px;
    }

    /* ======================수정,삭제======================= */

    button {
        float: right;
        margin-right: 65px;
        font-size: 20px;
        font-weight: 800;
        width: 100px;
        height: 35px;
        background-color: rgb(175, 124, 213);
        border: 1px solid #ceced2;
    }


    </style>
    
</head>

<body>

<!-- 헤더 - 로그인/로그아웃 로고, 관리자페이지 메인글씨 -->
<header>
    <div class="state">
        <span class="login">admin님 로그인하였습니다</span>
        <span class="login">Ι</span>
        <span class="login"><a href="#">홈페이지</a></span>
        <span class="login">Ι</span>
        <span class="login"><a href="#">로그아웃</a></span>
    </div>
    <div>
        <h1><img src="/admin/css/admin/logo.png" id="logo" width="200"></h1> 
    </div>
    <h2 class="admin">관리자 페이지</h2>
    
</header>

<!-- 메인 - 보라색 가로줄(메인페이지글자), 왼쪽 메뉴 -->
<main>
    <div class="sub_content">
        <nav> 메인페이지 </nav>
        <div class="menu1">
            <ul id="menu2">
                <li><a href="#">상품등록</a></li>
                <li><a href="#">상품목록</a></li>
                <li><a href="/admin/notice/list">공지사항</a></li>
                <li><a href="/admin/faq/list">FAQ</a></li>
                <li><a href="/admin/member/list">회원관리</a></li>
                <li><a href="/admin/farm/list">거래처관리</a></li>
            </ul>
        </div>   
        
<!-- 메인 - 공지사항 글 목록 테이블, 이동페이지, 수정, 삭제 -->            
                
        <div class="content">
            <table>
                <h2>공지사항 <span class="test">테스트</span></h2>
                <!-- <a href="javascript:all_del()">전체선택 / 전체해제</a> -->
                <thead>
	                <tr>
	                    <th><input type="checkbox" name="selectall" value="selectall" onclick="selectAll(this)"></th>
	                    <th>번호</th>
	                    <th>제목</th>
	                    <th>작성날짜</th>
	                    <th>수정날짜</th>
	                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="NoticeVO">
                        <tr>
                        	<td><input type="checkbox" name="item" onclick="checkSelectAll()" /></td>
                            <td>${NoticeVO.no}</td>
                            <td><a href="/admin/notice/get?no=${NoticeVO.no}">${NoticeVO.title}</a></td>
                            <td>${NoticeVO.reg_date}</td>
                            <td>${NoticeVO.update_date}</td>
                        </tr>       
                    </c:forEach>    
                </tbody>
            </table>
            
            <div class="modify">
 				<button type="button" id="registerBtn">등록</button>
                <button type="button" id="removeBtn">삭제</button>
            </div>
            <div class="pagenation">
                <ul>
                    <li><span>1</span></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">7</a></li>
                    <li><a href="#">8</a></li>
                    <li><a href="#">9</a></li>
                    <li><a href="#">10</a></li>
                    <li><a href="#">〉</a></li>
                    <li><a href="#">〉〉</a></li>
                </ul>
            </div>
        </div>
        

    </div>
</main>

    
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>

<script>

//  ================= 공지사항 목록 전체선택 / 전체해제 / 체크 삭제 ========================= 
//  ================== 1. 전체선택, 전체해제 체크박스 =============================

    function selectAll(selectAll)  {
        const checkboxes 
        = document.getElementsByName("item");

        checkboxes.forEach((checkbox) => {
            checkbox.checked = selectAll.checked;
        })

    }

//  ================== 2. 하나라도 선택해제 될 경우 전체선택 해제 =============================

    function checkSelectAll()   {
        // 전체 체크박스
        const checkboxes 
            = document.querySelectorAll('input[name="item"]');
        // 선택된 체크박스
        const checked 
            = document.querySelectorAll('input[name="item"]:checked');
        // select all 체크박스
        const selectAll 
            = document.querySelector('input[name="selectall"]');

        // 만약 체크박스가 하나라도 선택해제되면 전체선택 해제 
        if(checkboxes.length === checked.length)  {
            selectAll.checked = true;
        }else {
            selectAll.checked = false;
        }

    }

</script>

<script>	
//  ================== 5. 버튼을 클릭하면 이동함. =============================

	
	
        var registerBtn = document.querySelector('#registerBtn');

        registerBtn.addEventListener('click', function () {
            location = '/admin/notice/register';
        }); // .addEventListener

      //만약 결과값에 어떤 값이든 들어왔다면(null이 아니라면) -> 결과값을 alert창으로 띄운다.
      
        var result = "${param.result}";
        if(result != null && result != "") {        
            alert('result: ' + result);
        } // if
        
        
        
		
        removeBtn.addEventListener('click', function(){
            console.log('removeBtn clicked ㅇ_<');

            //form 태그를 조작해서 삭제요청을 전송! 
            var form = document.querySelector('form');
            console.log(form.constructor.prototype);


            form.setAttribute('method', 'POST');
            form.setAttribute('action', '/admin/notice/remove');
            form.submit();

        });

</script>

</html>