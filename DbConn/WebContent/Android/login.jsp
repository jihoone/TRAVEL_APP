<%@page import="com.db.LoginDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	LoginDB loginDB = LoginDB.getInstance();

	//한글 인코딩 부분
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String returns = loginDB.connectionDB(id, pw);

	System.out.println(returns);

	//안드로이드로 전송
	out.println(returns);
%>
