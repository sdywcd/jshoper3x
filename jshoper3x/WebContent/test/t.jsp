<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript"
		src="<%request.getContextPath(); %>/dwr/engine.js"></script>
	<script type="text/javascript"
		src="<%request.getContextPath(); %>/dwr/util.js"></script>

	<script type="text/javascript"
		src="<%request.getContextPath(); %>/dwr/interface/Demo.js"></script>

	<script type="text/javascript">
function update() {
	  var name = dwr.util.getValue("demoName");
	  Demo.sayHello(name, function(data) {
	    dwr.util.setValue("demoReply", data);
	  });
	}
</script>
	<p>
		Name: <input type="text" id="demoName" /> <input value="Send"
			type="button" onclick="update()" /> <br /> Reply: <span
			id="demoReply"></span>
	</p>
</body>
</html>