// 액션 처리 Controller

function init()
{
	var btnSum = document.getElementById("btn-sum");
	btnSum.onclick = btnSumClick;
}

function btnSumClick()
{
	var txtX = document.getElementById("txt-x");
	var txtY = document.getElementById("txt-y");
	var sum = document.getElementById("txt-sum");
	var x = parseInt(txtX.value);
	var y = parseInt(txtY.value);
	
	alert(parseInt(txtX.value) + parseInt(txtY.value)); //value는 가지고 있는 값을 꺼내오는 녀석
	sum.setAttribute("value", x+y);
}

window.onload = init;
