<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<table height="100%" width="100%" border="1" cellspacing="2" cellpadding="2">
	<tr>
        <td height="15%" colspan="2"><tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td height="70%"><tiles:insertAttribute name="menu" /></td>
        <td width="85%"><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td height="15%" colspan="2"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>