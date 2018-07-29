<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>footer.jsp</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>


<script type="text/javascript">
	//调用signUpDetails.jsp页面的addBack()方法
	//window.parent：就是signUpDetails.jsp页面  （父页面）
	window.parent.signupBack();
</script>

</body>
</html>