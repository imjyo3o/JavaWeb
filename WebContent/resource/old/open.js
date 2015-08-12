
var win = null;	// var를 지우나 쓰나 똑같다. 그치만 쓰는 습관을 갖는 것이 좋다.

function btnNewTabClick(){
	win = open("open2.html", "_blank" );
}

function btnNewWinClick(){
	win = open("open2.html", "_blank" , "width=500px, height=400px");
}

function btnCloseWinClick(){
	win.close();
}

window.addEventListener("load", function(){
	var btnNewTab = document.getElementById("btn-new-tab");
	var btnNewWin = document.getElementById("btn-new-win");
	var btnCloseWin = document.getElementById("btn-close-win");
	
	btnNewTab.onclick = btnNewTabClick;
	btnNewWin.onclick = btnNewWinClick;
	btnCloseWin.onclick = btnCloseWinClick;
});
