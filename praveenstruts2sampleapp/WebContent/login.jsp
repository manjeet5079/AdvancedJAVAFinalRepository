<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:form action="login">
<s:fielderror/>
<s:textfield label="Loginid" key="userid"/>
<s:password label="Password" key="password" />
<s:submit align="center"/>
</s:form>
 