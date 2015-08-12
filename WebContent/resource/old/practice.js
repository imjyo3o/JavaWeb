function init()
{
	}

function printResult()
{
	
}

window.onload = function(){alert("test1")};
window.onload = function(){alert("test2")};
window.onload = function(){alert("test3")};
window.onload = ("load" , function(){alert("test1");});
window.onload = ("load" , function(){alert("test2");});
window.onload = ("load" , function(){alert("test3");});

//window.onload = init;
//window.addEventListener("load", init);