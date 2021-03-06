function btnResizeClick(){
	opener.resizeTo(100, 100);
	opener.resizeBy(100, 100);
}

function btnMoveClick(){
	opener.moveTo(100, 100);
	opener.moveBy(100, 100);
}

function btnOpenerClose(){
	opener.close();
}

window.addEventListener("load", function(){
	var btnResize = document.getElementById("btn-resize");
	var btnMove = document.getElementById("btn-move");
	var btnClose = document.getElementById("btn-opener-close");
	
	btnResize.onclick = btnResizeClick;
	btnMove.onclick = btnMoveClick;
	btnClose.onclick = btnOpenerClose;
});
