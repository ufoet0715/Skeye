/**
 * 
 */
function commonLoad(id) {
	var option = {
		lines : 9, // 花瓣数目
		length : 1, // 花瓣长度
		width : 10, // 花瓣宽度
		radius : 15, // 花瓣距中心半径
		shadow : true,
		opacity : 1 / 8
	};
	var targetDiv = document.getElementById(id);
	var spinner = new Spinner(option).spin(targetDiv);// 显示加载
	return spinner;
}