// 액션 처리 Controller

function init()
{
	var btnCountDown = document.getElementById("btn-countdown");
	btnCountDown.onclick = btnCountDownClick;
}


var timerID = null;


function count()
{
	var lblCount = document.getElementById("lbl-count");
	var count = parseInt(lblCount.innerText);
	
	if(count>0)
		lblCount.innerText = --count;
	else
		//취소
		clearInterval(timerID)
		timerID = null;
}

function btnCountDownClick()
{
	//setTimeout(count, 1000);
	//setInterval(count, 100);
	if(timerID == null)
	timerID = setInterval(count, 1000);
	
}

window.onload = init;
