<%@page import="com.db.ConnectDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ConnectDB connectDB = ConnectDB.getInstance();

	//한글 인코딩 부분
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String email = request.getParameter("email");
	String hp = request.getParameter("hp");

	String returns = connectDB.connectionDB(id, pw, name, birth, email, hp);

	System.out.println(returns);

	//안드로이드로 전송
	out.println(returns);
%>
