$(function() {
	isEmail = function(text) {
		return /^(?:[a-z0-9]+[_\-+.]+)*[a-z0-9]+@(?:([a-z0-9]+-?)*[a-z0-9]+.)+([a-z]{2,})+$/i.test(text);
	},
	// 手机：仅中国手机适应；以 1 开头，第二位是 3-9，并且总位数为 11 位数字
	isMobile = function(text) {
		return /^1[3-9]\d{9}$/.test(text);
	},

	isTel = function(text) {
		return /^(?:(?:0\d{2,3}[- ]?[1-9]\d{6,7})|(?:[48]00[- ]?[1-9]\d{6}))$/.test(text);
	},

	/**
	 * 判断字符串是否为空
	 *
	 * @param param通过$.("#param").val()获取的值
	 */
	isEmptyStr = function(param) {
		if (param === "") {
			return true;
		}
	},
	/**
	 * 判断是否浮点数
	 */
	isDoubleNumber = function(param) {
		if (param.match(/^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/)) {
			return true;
		}
	},
	/**
	 * 验证是否数字组成
	 */
	isNumber = function(param) {
		if (param.match(/^[0-9]*[1-9][0-9]*$/)) {
			return true;
		}
	},
	/**
	 * 比较2个时间大小
	 */
	compareTime = function(t1, t2) {
		var startTime = t1;
		var start = new Date(startTime.replace("-", "/").replace("-", "/"));
		var endTime = t2;
		var end = new Date(endTime.replace("-", "/").replace("-", "/"));
		if (end <= start) {
			return false;
		}
		return true;
	},
	/**
	 * 时间是否在同一天内
	 */
	isTimeInOneDay = function(t1, t2) {
		var startTime = t1;
		var start = new Date(startTime.replace("-", "/").replace("-", "/"));
		var endTime = t2;
		var end = new Date(endTime.replace("-", "/").replace("-", "/"));
		var etime = end.getTime();
		var stime = start.getTime();
		if (etime - stime <= 24 * 3600 * 1000) {
			return false;
		}
		return true;
	},
	/**
	 * 格式化时间
	 */
	formatData = function(num) {
		var formatTime = "";
		var la = new Date(num);
		localTime = la.getTime();
		localOffset = la.getTimezoneOffset() * 60000;
		utc = localTime + localOffset;
		offset = 8;
		bombay = utc + (3600000 * offset);
		var ndate = new Date(bombay);
		var year = ndate.getFullYear(); //当前年
		var month = ndate.getMonth(); //当前月
		var rmonth = selectRMonth(month);
		var day = ndate.getDate(); //当前日
		if (day < 10) {
			day = "0" + day;
		}
		var hour = ndate.getHours(); //当前时
		if (hour < 10) {
			hour = "0" + hour;
		}
		var minutes = ndate.getMinutes(); //当前分
		if (minutes < 10) {
			minutes = "0" + minutes;
		}
		var l = year + "-" + rmonth + "-" + day + " " + hour + ":" + minutes;
		formatTime = l;
		return formatTime;
	},
	/**
	 * 格式化年月日
	 */
	formatDataHYD = function(num) {
		var formatTime = "";
		var la = new Date(num);
		localTime = la.getTime();
		localOffset = la.getTimezoneOffset() * 60000;
		utc = localTime + localOffset;
		offset = 8;
		bombay = utc + (3600000 * offset);
		var ndate = new Date(bombay);
		var year = ndate.getFullYear(); //当前年
		var month = ndate.getMonth(); //当前月
		var rmonth = selectRMonth(month);
		var day = ndate.getDate(); //当前日
		if (day < 10) {
			day = "0" + day;
		}
		var l = year + "-" + rmonth + "-" + day;
		formatTime = l;
		return formatTime;
	},
	/**
	 * 格式化小时分钟
	 */
	formatDataHHMM = function(num) {
		var formatTime = "";
		var la = new Date(num);
		localTime = la.getTime();
		localOffset = la.getTimezoneOffset() * 60000;
		utc = localTime + localOffset;
		offset = 8;
		bombay = utc + (3600000 * offset);
		var ndate = new Date(bombay);

		var hour = ndate.getHours(); //当前时
		if (hour < 10) {
			hour = "0" + hour;
		}
		var minutes = ndate.getMinutes(); //当前分
		if (minutes < 10) {
			minutes = "0" + minutes;
		}
		var l = hour + ":" + minutes;

		formatTime = l;
		return formatTime;
	},
	selectRMonth=function(month){
		var m="0";
		switch (month) {
		case 0:
			m="01";
			break;
		case 1:
			m="02";
			break;
		case 2:
			m="03";
			break;
		case 3:
			m="04";
			break;
		case 4:
			m="05";
			break;
		case 5:
			m="06";
			break;
		case 6:
			m="07";
			break;
		case 7:
			m="08";
			break;
		case 8:
			m="09";
			break;
		case 9:
			m="10";
			break;
		case 10:
			m="11";
			break;
		case 11:
			m="12";
			break;
		default:
			break;
		}
		return m;
	},
});